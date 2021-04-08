package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_8394_악수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] dp = new int[10000001];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=3; i<=n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) %10;
		}
		
		System.out.println(dp[n]);

		br.close();
	}

}
