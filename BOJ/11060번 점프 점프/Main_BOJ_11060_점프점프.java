package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
0 0 0 1 0

10
1 2 0 1 3 2 1 5 4 2
 */
public class Main_BOJ_11060_점프점프 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] jump = new int[N]; // 점프 미로

		for (int i = 0; i < N; i++)
			jump[i] = Integer.parseInt(st.nextToken());

		int[] dp = new int[N]; // index번까지 가는데 필요한 점프 수 (최적해)
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 0; i < N; i++) {
			int cnt = jump[i];
			for (int j = 1; j <= cnt; j++) {
				if (dp[i] == Integer.MAX_VALUE)
					continue;
				if (i + j < N)
					dp[i + j] = Math.min(dp[i] + 1, dp[i + j]);
			}
		}

		if (dp[N - 1] != Integer.MAX_VALUE)
			System.out.println(dp[N - 1]);
		else
			System.out.println(-1);

		br.close();
	}

}
