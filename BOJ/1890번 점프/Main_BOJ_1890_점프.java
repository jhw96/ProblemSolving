package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1890_점프 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		long[][] dp = new long[N][N]; // 해당 좌표까지 가는데 가능한 경로 갯수

		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0 }); // 시작점

		// 오른쪽, 아래쪽
		int[] dx = { 1, 0 };
		int[] dy = { 0, 1 };

		dp[0][0] = 1;

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (dp[y][x] == 0)
					continue;
				if(y==N-1 && x==N-1)
					continue;
				for (int dir = 0; dir < 2; dir++) {
					int nX = x + dx[dir] * map[y][x];
					int nY = y + dy[dir] * map[y][x];
					if (nX < N && nY < N) {
						dp[nY][nX] += dp[y][x];
					}
				}
			}
		}

		System.out.println(dp[N - 1][N - 1]);

		br.close();
	}

}
