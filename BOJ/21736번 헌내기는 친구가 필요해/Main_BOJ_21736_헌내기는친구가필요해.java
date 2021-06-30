package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_21736_헌내기는친구가필요해 {

	static int N, M; // 세로, 가로
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int cnt = 0;

	private static void DFS(int x, int y) {
		visited[y][x] = true;

		for (int i = 0; i < 4; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];
			if (nX >= 1 && nX <= M && nY >= 1 && nY <= N) {
				if (!visited[nY][nX] && map[nY][nX] != 'X') {
					if (map[nY][nX] == 'P')
						cnt++;
					visited[nY][nX] = true;
					DFS(nX, nY);
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
		visited = new boolean[N + 1][M + 1];

		int sX = 0, sY = 0;

		for (int y = 1; y <= N; y++) {
			String input = br.readLine();
			for (int x = 1; x <= M; x++) {
				map[y][x] = input.charAt(x - 1);
				if (map[y][x] == 'I') {
					sX = x;
					sY = y;
				}

			}
		}

		DFS(sX, sY);

		if (cnt == 0)
			System.out.println("TT");
		else
			System.out.println(cnt);

		br.close();
	}

}
