package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2193_이친수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dp = new int[91];
		dp[1] = 1;
		dp[2] = 1;

		int n = Integer.parseInt(br.readLine());
		
		for(int i=3; i<=n; i++)
			dp[i] = dp[i-2] + dp[i-1];

		System.out.println(dp[n]);
		br.close();
	}

}
