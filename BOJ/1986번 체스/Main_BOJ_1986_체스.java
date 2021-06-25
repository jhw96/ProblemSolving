package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1986_체스 {

	static int n, m; // 세로, 가로
	static int[][] map;
	static boolean[][] visited;

	// 퀸의 움직임
	static int[] qx = { 1, -1, 1, -1, 0, 0, -1, 1 };
	static int[] qy = { -1, -1, 1, 1, -1, 1, 0, 0 };

	// 나이트의 움직임
	static int[] kx = { -1, 1, -1, 1, -2, 2, -2, 2 };
	static int[] ky = { -2, -2, 2, 2, -1, -1, 1, 1 };

	private static void moveKnight(int x, int y) {

		for (int i = 0; i < 8; i++) {
			int nX = x + kx[i];
			int nY = y + ky[i];
			if (nX >= 1 && nY >= 1 && nX <= m && nY <= n) {
				if (map[nY][nX] == 0) {
					visited[nY][nX] = true;
				}
			}
		}
	}

	private static void move(int x, int y, int dir) {
		int nX = x + qx[dir];
		int nY = y + qy[dir];

		while (true) {

			if (nX >= 1 && nY >= 1 && nX <= m && nY <= n) {
				if (map[nY][nX] != 0) // 장애물이 있으면 멈춤
					break;
				visited[nY][nX] = true;
				nX += qx[dir];
				nY += qy[dir];
			} else
				break;

		}

	} // move end

	private static void moveQueen(int x, int y) {
		for (int dir = 0; dir < 8; dir++) {
			move(x, y, dir);
		}

	} // moveQueen end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];

		st = new StringTokenizer(br.readLine(), " ");
		int q = Integer.parseInt(st.nextToken());

		for (int i = 0; i < q; i++) {
			int y = 0;
			int x = 0;

			for (int j = 0; j < 2; j++) {
				if (j == 0)
					y = Integer.parseInt(st.nextToken());
				else
					x = Integer.parseInt(st.nextToken());
			}
			map[y][x] = 3;
			visited[y][x] = true;
		}

		st = new StringTokenizer(br.readLine(), " ");
		int k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < k; i++) {
			int y = 0;
			int x = 0;

			for (int j = 0; j < 2; j++) {
				if (j == 0)
					y = Integer.parseInt(st.nextToken());
				else
					x = Integer.parseInt(st.nextToken());
			}
			map[y][x] = 2;
			visited[y][x] = true;
		}

		st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken());

		for (int i = 0; i < p; i++) {
			int y = 0;
			int x = 0;

			for (int j = 0; j < 2; j++) {
				if (j == 0)
					y = Integer.parseInt(st.nextToken());
				else
					x = Integer.parseInt(st.nextToken());
			}
			map[y][x] = 1;
			visited[y][x] = true;
		}

		for (int y = 1; y <= n; y++) {
			for (int x = 1; x <= m; x++) {
				if (map[y][x] == 3) {
					moveQueen(x, y);
				} else if (map[y][x] == 2) {
					moveKnight(x, y);
				}
			}
		}

		int answer = 0;

		for (int y = 1; y <= n; y++) {
			for (int x = 1; x <= m; x++) {
				if (!visited[y][x])
					answer++;
			}
		}

		System.out.println(answer);

		br.close();
	}

}
