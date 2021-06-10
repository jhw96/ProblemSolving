package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16929_TwoDots {

	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean find = false;

	private static void DFS(int sX, int sY, int x, int y, char color, int step) {
		if (find)
			return;
		
		for (int dir = 0; dir < 4; dir++) {
			int nX = x + dx[dir];
			int nY = y + dy[dir];

			if (nX >= 1 && nY >= 1 && nX <= M && nY <= N) {
				if (nX == sX && nY == sY && step>=4) {
					find = true;
					return;
				}

				if (!visited[nY][nX] && color == map[nY][nX]) {
					visited[nY][nX] = true;
					DFS(sX, sY, nX, nY, color, step+1);
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N + 1][M + 1];

		for (int y = 1; y <= N; y++) {
			String input = br.readLine();
			for (int x = 1; x <= M; x++) {
				map[y][x] = input.charAt(x - 1);
			}
		}

		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= M; x++) {
				visited = new boolean[N + 1][M + 1];
				visited[y][x] = true;
				DFS(x, y, x, y, map[y][x],1);
			}
		}

		if (find)
			System.out.println("Yes");
		else
			System.out.println("No");

		br.close();
	}

}
