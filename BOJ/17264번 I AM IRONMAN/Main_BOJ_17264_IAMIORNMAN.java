package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_BOJ_17264_IAMIORNMAN {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		HashMap<String, Character> map = new HashMap<String, Character>();
		HashSet<String> set = new HashSet<String>();
		
		st = new StringTokenizer(br.readLine(), " ");
		int win = Integer.parseInt(st.nextToken()); // 승점
		int lose = Integer.parseInt(st.nextToken()); // 패점
		int goal = Integer.parseInt(st.nextToken()); // 목표 점수

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String player = st.nextToken();
			char result = st.nextToken().charAt(0);
			set.add(player);
			map.put(player, result);
		}

		boolean flag = false;
		int process = 0;
		
		for (int i = 0; i < N; i++) {
			String player = br.readLine();
			char result = ' ';
			
			if(set.contains(player)) 
				result = map.get(player);
			 else
				result = 'L';

			if (result == 'W') { // 이기는 플레이어일 경우
				process += win;
				if (process >= goal) {
					flag = true;
					break;
				}
			} else { // 지는 플레이어일 경우
				if(process - lose >= 0)
					process -= lose;
				else if(process - lose < 0)
					process = 0;
			}

		}
		
		if(flag)
			System.out.println("I AM NOT IRONMAN!!");
		else
			System.out.println("I AM IRONMAN!!");

		br.close();
	}

}
