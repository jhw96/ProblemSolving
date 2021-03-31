package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_1904_01타일 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long[] dp = new long[1000001];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=3; i<=N; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%15746;
		}
		
		System.out.println(dp[N]);
		
		
		br.close();
	}

}
