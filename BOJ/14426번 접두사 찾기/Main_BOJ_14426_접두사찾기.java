package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BOJ_14426_접두사찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<String>();

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < input.length(); j++) {
				sb.append(input.charAt(j));
				set.add(sb.toString());
			}
		}
		int answer = 0;
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			
			if (set.contains(input))
				answer++;
		}

		System.out.println(answer);

		br.close();
	}

}
