package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BOJ_17219_비밀번호찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 입력 개수
		int M = Integer.parseInt(st.nextToken()); // 정답 개수

		Map<String, String> map = new HashMap<String, String>();
		ArrayList<String> answer = new ArrayList<String>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			map.put(st.nextToken(), st.nextToken());
		}
		
		
		for(int i=0; i<M; i++) {
			String input = br.readLine();
			
			String tmp = map.get(input);
			answer.add(tmp);
		}
		
		for(int i=0; i<M; i++)
			System.out.println(answer.get(i));
		

		br.close();
	}

}
