package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11055_가장큰증가부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N]; // idx번째 수를 뒤에 꼭 붙인 가장 큰 누적합

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		dp[0] = arr[0];

		int max = 0;
		for (int i = 0; i < N; i++) { // 순서대로 숫자 비교하기
			boolean flag = true;

			for (int j = 0; j <= i - 1; j++) { // 현재 수와 앞의 숫자들 비교하기
				if (arr[j] < arr[i]) { // 앞의 수보다 현재 수가 크다면
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
					flag = false;
				}
			}

			if (flag) // 앞의 수가 큰게 없으면
				dp[i] = arr[i];
			
			if (max < dp[i])
				max = dp[i];
		}

		System.out.println(max);

		br.close();
	}

}
