package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_15886_내선물을받아줘2 {

	static int N; // 골목길 크기
	static String input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int answer = 0;

		N = Integer.parseInt(br.readLine());
		input = br.readLine();

		for (int i = 0; i < N - 1; i++) {
			if (input.charAt(i) == 'E' && input.charAt(i + 1) == 'W')
				answer++;
		}

		System.out.println(answer);

		br.close();
	}

}
