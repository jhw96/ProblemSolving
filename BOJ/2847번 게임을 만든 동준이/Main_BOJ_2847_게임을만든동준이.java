package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2847_게임을만든동준이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] score = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}

		int answer = 0;

		for (int i = N - 1; i >= 0; i--) {
			if (score[i + 1] <= score[i]) {
				int diff = score[i] - score[i + 1] + 1;
				answer += diff;
				score[i] -= diff;
			}
		}
		System.out.println(answer);

		br.close();
	}

}
