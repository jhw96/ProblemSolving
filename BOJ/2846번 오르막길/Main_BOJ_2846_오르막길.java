package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2846_오르막길 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int[] dp = new int[N];
		dp[0] = 0;

		int max = 0;
		
		for (int i = 1; i < N; i++) {
			if (arr[i - 1] < arr[i]) { // 현재 수가 이전보다 높으면
				dp[i] = dp[i - 1] + (arr[i] - arr[i - 1]);
			} else // 현재 수가 이전보다 낮으면 새로 시작
				dp[i] = 0;
			
			if(dp[i] > max)
				max = dp[i];
		}
		
		System.out.println(max);

		br.close();
	}

}
