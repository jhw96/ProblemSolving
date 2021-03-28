package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11048_이동하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 미로 세로 길이
		int M = Integer.parseInt(st.nextToken()); // 미로 가로 길이

		int[][] map = new int[N + 1][M + 1];
		int[][] dp = new int[N + 1][M + 1]; // 이 위치에서의 사탕개수 최적해
		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= M; x++) {
				dp[y][x] = Math.max(dp[y][x], dp[y - 1][x - 1] + map[y][x]);
				dp[y][x] = Math.max(dp[y][x], dp[y][x - 1] + map[y][x]);
				dp[y][x] = Math.max(dp[y][x], dp[y - 1][x] + map[y][x]);
			}
		}

		System.out.println(dp[N][M]);

		br.close();
	}

}
