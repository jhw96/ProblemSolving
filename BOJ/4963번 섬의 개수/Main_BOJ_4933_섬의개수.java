package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_4933_섬의개수 {

	public static void DFS(int[][] map, boolean[][] visited, int w, int h, int sX, int sY) {

		// 위에서부터 시계방향으로
		int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
		visited[sY][sX] = true;

		for (int dir = 0; dir < 8; dir++) {
			int nX = sX + dx[dir];
			int nY = sY + dy[dir];
			if (nY >= 0 && nX >= 0 && nX < w && nY < h && !visited[nY][nX] && map[nY][nX] == 1) {
				DFS(map, visited, w, h, nX, nY);
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;
			int[][] map = new int[h][w];
			boolean[][] visited = new boolean[h][w];
			
			for(int i=0; i<h; i++) {
				st= new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<w; j++) 
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			int count = 0;
			for (int y = 0; y < h; y++) {
				for (int x = 0; x < w; x++) {
					if (map[y][x] == 1 && !visited[y][x]) {
						count++;
						DFS(map, visited, w, h, x, y);
					}
				}
			}

			System.out.println(count);

		}

		br.close();
	}

}
