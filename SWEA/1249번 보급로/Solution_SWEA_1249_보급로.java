package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1249_보급로 {

	static int N; // 맵 크기
	static int[][] map;
	static int[][] dp;

	static int[] dx = { 0,0,-1,1  };
	static int[] dy = { -1,1,0,0 };

	private static void BFS() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 1, 1 });

		while (!q.isEmpty()) {
			int[] top = q.poll();
			int x = top[0];
			int y = top[1];

			for (int dir = 0; dir < 4; dir++) {
				int nX = x + dx[dir];
				int nY = y + dy[dir];
				
				if (nX >= 1 && nX <= N && nY >= 1 && nY <= N) {
					int next = dp[y][x] + map[nY][nX];
					if (next < dp[nY][nX]) {
						dp[nY][nX] = next;
						q.add(new int[] { nX, nY });
					}
				}

			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder().append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			map = new int[N + 1][N + 1];
			dp = new int[N + 1][N + 1];

			for (int y = 1; y <= N; y++) {
				Arrays.fill(dp[y], 9999);
			}
			dp[1][1] = 0;

			for (int y = 1; y <= N; y++) {
				String input = br.readLine();
				for (int x = 1; x <= N; x++) {
					map[y][x] = input.charAt(x - 1) - '0';
				}
			}
			
			BFS();
			
			sb.append(dp[N][N]);
			System.out.println(sb.toString());

		}

		br.close();
	}

}
