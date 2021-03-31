package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11722_가장긴감소하는부분수열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N]; // idx번째 숫자를 마지막에 꼭 붙인 수열의 최대 길이
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i =0; i<N; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[i] < arr[j]) { // 비교하는 수가 현재 수보다 크면
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}		
		
		for(int i=0; i<N; i++)
			System.out.print(dp[i] + " ");
		
		
		
		br.close();
	}

}
