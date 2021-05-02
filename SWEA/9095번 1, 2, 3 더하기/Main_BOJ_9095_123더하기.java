package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_9095_123더하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[] dp = new int[12]; // idx번 숫자를 만들 때 사용하는 경우의 수
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i <= 11; i++) {
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1]; 
			// i-3번째 수를 표현하는데 필요한 방법의 수 -> (i-3) + 3은 i가 됨
			// i-2번째 수를 표현하는데 필요한 방법의 수 -> (i-2) + 2는 i가 됨
			// i-1번째 수를 표현하는데 필요한 방법의 수 -> (i-1) + 1은 i가 됨
			// -> (i-3)를 표현하는 방법 + (i-2)를 표현하는 방법 + (i-1)를 표현하는 방법 -> i를 표현하는 방법의 수
		}
		

		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}

		br.close();
	}

}
