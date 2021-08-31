package com.baekjoon;

/*
 * 개강총회 시작시간 이하에 채팅을 남기면 입장
 * 개강총회 종료시간 이상과 스트리밍 종료시간에 채팅을 남기면 퇴장
 * 입,퇴장을 다 한 사람의 수를 세아려보자
 * -> 시간:분 으로 주어지기 때문에 조건이 까다롭다. 60*시간 + 분으로 계산하여 누적 분으로 쉽게 구별하자
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BOJ_19583_싸이버개강총회 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		String startTime = st.nextToken();
		String endTime = st.nextToken();
		String finishTime = st.nextToken();

		
		st = new StringTokenizer(startTime, ":");
		int start = 0; // 개강총회 시작시간
		start += (60 * Integer.parseInt(st.nextToken()));
		start += Integer.parseInt(st.nextToken());

		
		st = new StringTokenizer(endTime, ":");
		int end = 0; // 개강총회 종료시간
		end += (60 * Integer.parseInt(st.nextToken()));
		end += Integer.parseInt(st.nextToken());

		
		st = new StringTokenizer(finishTime, ":");
		int finish = 0; // 스트리밍 종료시간
		finish += (60 * Integer.parseInt(st.nextToken()));
		finish += Integer.parseInt(st.nextToken());

		int answer = 0;
		Set<String> people = new HashSet<String>();

		String input = "";

		while ((input = br.readLine()) != null) {
			st = new StringTokenizer(input, " ");
			String time = st.nextToken();
			String name = st.nextToken();

			int totalTime = 0;
			st = new StringTokenizer(time, ":");
			totalTime += Integer.parseInt(st.nextToken()) * 60;
			totalTime += Integer.parseInt(st.nextToken());
			
			if(totalTime <= start) {
				people.add(name);
			} 
			
			if(totalTime>= end && totalTime<=finish) {
				if(people.contains(name)) {
					answer++;
					people.remove(name);
				}
			}

		}

		System.out.println(answer);

		br.close();
	}

}
