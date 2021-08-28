package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_9251_LCS {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = br.readLine();
		String str2 = br.readLine();

		int[][] dp = new int[str2.length() + 1][str1.length() + 1]; // LCS 테이블 (수열 O, 부분문자열 X)

		for (int y = 0; y <= str2.length(); y++)
			dp[y][0] = 0;

		for (int x = 0; x <= str1.length(); x++)
			dp[0][x] = 0;

		int answer = 0;

		for (int y = 1; y <= str2.length(); y++) {
			for (int x = 1; x <= str1.length(); x++) {
				if (str1.charAt(x - 1) == str2.charAt(y - 1)) {
					dp[y][x] = dp[y - 1][x - 1] + 1;
				} else {
					dp[y][x] = Math.max(dp[y - 1][x], dp[y][x - 1]);
				}
				if (dp[y][x] > answer)
					answer = dp[y][x];
			}
		}

		System.out.println(answer);

		br.close();
	}

}
