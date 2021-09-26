package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_14940_쉬운최단거리 {

	static int n, m; // 세로 길이, 가로 길이
	static int[][] map;
	static boolean[][] visited; // 방문여부 체크

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static void check() {

		for (int y = 1; y <= n; y++) {
			for (int x = 1; x <= m; x++) {
				if (map[y][x] != 0 && !visited[y][x]) { // 갈 수 있는 땅인데 방문하지 않았다면
					map[y][x] = -1;
				}
			}
		}

	} // check end

	private static void BFS(int sx, int sy) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sx, sy, 0 });
		visited[sy][sx] = true;
		map[sy][sx] = 0;

		while (!q.isEmpty()) {
			int[] top = q.poll();
			int x = top[0];
			int y = top[1];
			int cnt = top[2];

			for (int dir = 0; dir < 4; dir++) {
				int nX = x + dx[dir];
				int nY = y + dy[dir];
				if (nX >= 1 && nX <= m && nY >= 1 && nY <= n) {
					if (map[nY][nX] != 0 && !visited[nY][nX]) { // 아직 방문하지 않은 갈 수 있는 땅이면
						q.add(new int[] { nX, nY, cnt + 1 });
						visited[nY][nX] = true;
						map[nY][nX] = cnt + 1;
					}
				}
			}
		}

	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];

		int sx = 0, sy = 0; // 시작점

		for (int y = 1; y <= n; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= m; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 2) { // 목표지점
					sy = y;
					sx = x;
				}
			}
		}

		BFS(sx, sy);
		
		check();
		
		for(int y =1; y<=n; y++) {
			for(int x=1; x<=m; x++) {
				System.out.print(map[y][x] + " ");
			}
			System.out.println();
		}

		br.close();
	}

}
