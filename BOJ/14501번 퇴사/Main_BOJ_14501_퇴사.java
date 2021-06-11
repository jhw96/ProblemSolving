package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14501_퇴사 {

	static int N;
	static int[][] consultant;
	static boolean[][] dp;

	private static void DFS(int step, int totalMoney) {
		if (dp[step][totalMoney])
			return;
		dp[step][totalMoney] = true;

		if (step == N) {
			return;
		}

		int day = consultant[step][0];
		int money = consultant[step][1];
		if (step + day <= N)
			DFS(step + day, totalMoney + money);
		DFS(step + 1, totalMoney);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		consultant = new int[N][2]; // 0: 상담에 걸리는 일수, 1: 수익

		int sum = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++)
				consultant[i][j] = Integer.parseInt(st.nextToken());
			sum += consultant[i][1];
		}
		dp = new boolean[N + 1][sum + 1];

		DFS(0, 0);

		int max = 0;
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= sum; j++) {
				if (dp[i][j] && max < j)
					max = j;
			}
		}
		System.out.println(max);

		br.close();
	}

}
