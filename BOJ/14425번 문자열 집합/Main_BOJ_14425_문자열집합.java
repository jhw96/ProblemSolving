package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BOJ_14425_문자열집합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<String>();
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			set.add(input);
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
