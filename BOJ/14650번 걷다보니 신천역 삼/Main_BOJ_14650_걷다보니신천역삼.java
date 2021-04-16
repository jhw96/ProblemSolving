package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_14650_걷다보니신천역삼 {

	static int answer = 0;

	public static void subset(int cnt, int N, String s) {
		if (cnt == N) {

			if (Integer.parseInt(s) % 3 == 0) {
				answer++;
			}

			return;
		}

		for (int i = 0; i <= 2; i++) {
			if (cnt == 0 && i == 0)
				continue;
			subset(cnt + 1, N, s + Integer.toString(i));
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		subset(0, N, "");
		
		System.out.println(answer);
		br.close();
	}

}
