package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16174_점프왕쩰리 {

	static int N;
	static int[][] map;
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };
	static boolean success = false;
	static boolean[][] visited = new boolean[N + 1][N + 1];

	private static void DFS(int x, int y) {
		if (success)
			return;

		for (int dir = 0; dir < 2; dir++) {
			int nX = x + map[y][x] * dx[dir];
			int nY = y + map[y][x] * dy[dir];

			if (nX >= 1 && nY >= 1 && nX <= N && nY <= N) {
				if (map[nY][nX] == -1) {
					success = true;
					return;
				}
				if (!visited[nY][nX]) {
					visited[nY][nX] = true;
					DFS(nX, nY);
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];

		for (int y = 1; y <= N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		visited[1][1] = true;
		DFS(1, 1);

		if (success)
			System.out.println("HaruHaru");
		else
			System.out.println("Hing");

		br.close();
	}

}
