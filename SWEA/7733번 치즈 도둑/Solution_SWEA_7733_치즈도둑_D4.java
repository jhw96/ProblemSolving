package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_7733_치즈도둑_D4 {

	public static void DFS(int[][] map, int n, int sX, int sY, boolean[][] visited) {
		// 상 하 좌 우
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };
		visited[sY][sX] = true;

		for (int i = 0; i < 4; i++) {
			int nX = sX + dx[i];
			int nY = sY + dy[i];
			if (nX >= 0 && nY >= 0 && nX < n && nY < n && map[nY][nX] != 0) { // 범위 안이고 갉아먹힌 곳이 아니라면
				if (!visited[nY][nX]) // 방문하지 않았으면
					DFS(map, n, nX, nY, visited);
			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder().append("#").append(tc).append(" ");
			int answer = 1;

			int n = Integer.parseInt(br.readLine());
			int[][] cheese = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					cheese[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int day = 1; day <= 100; day++) {
				
				boolean[][] visited = new boolean[n][n];
				
				for (int y = 0; y < n; y++) { // 치즈 갉아먹기
					for (int x = 0; x < n; x++) {
						if (cheese[y][x] == day) {
							cheese[y][x] = 0;
							visited[y][x] = true;
						}
					}
				}


				int cnt = 0;
				for (int y = 0; y < n; y++) {
					for (int x = 0; x < n; x++) {
						if (!visited[y][x] && cheese[y][x] != 0) { // 치즈가 갉아먹히지 않았고 아직 방문하지 않았으면
							cnt++;
							DFS(cheese, n, x, y, visited);
						}
					}
				}

				if (cnt > answer)
					answer = cnt;

			}

			sb.append(answer);
			System.out.println(sb.toString());
		}

		br.close();
	}

}
