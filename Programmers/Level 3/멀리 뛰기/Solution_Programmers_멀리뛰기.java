package com.programmers;

public class Solution_Programmers_멀리뛰기 {

	public static void main(String[] args) {

		long answer = 0;
		int[] dp = new int[2001];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		int n = 4;

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
		}
		answer = dp[n];
		System.out.println(answer);

	}

}
