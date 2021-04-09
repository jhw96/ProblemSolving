package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2468_안전영역 {

	public static void DFS(int[][] map, boolean[][] visited, int n, int sX, int sY, int rain) {

		visited[sY][sX] = true;
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		for (int i = 0; i < 4; i++) {
			int nX = sX + dx[i];
			int nY = sY + dy[i];
			if (nY >= 0 && nY < n && nX >= 0 && nX < n) { // 범위 안이고
				if (!visited[nY][nX] && map[nY][nX] > rain) { // 아직 방문하지 않았고 비의 높이보다 높으면
					DFS(map, visited, n, nX, nY, rain);
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];

		int max = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (max < map[i][j])
					max = map[i][j];
			}
		}

		int answer = 0;

		for (int rain = 0; rain <= max; rain++) {
			int cnt = 0;
			boolean[][] visited = new boolean[n][n];
			for (int y = 0; y < n; y++) {
				for (int x = 0; x < n; x++) {
					if (map[y][x] > rain && !visited[y][x]) {
						cnt++;
						DFS(map, visited, n, x, y, rain);
					}
				}
			}
			if (answer < cnt)
				answer = cnt;
		}

		System.out.println(answer);
		br.close();
	}

}
