package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1912_연속합{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[N]; // 수열
		
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[N]; // idx번째에서의 최대 누적합
		dp[0] = arr[0]; // 초기값 세팅
		
		for(int i=1; i<N; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]); // 이전에서 현재 값을 계속 더한 것 vs 현재 값만 더한 것 중에 큰 거
		}
		
		int answer = dp[0];
		for(int i=1; i<N; i++) {
			if(answer < dp[i])
				answer = dp[i];
		}
		
		System.out.println(answer);
		
	}

}
