package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_14442_벽부수고이동하기2 {

	static class Point {
		int x;
		int y;
		int depth;
		int k;

		public Point(int x, int y, int depth, int k) {
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.k = k;
		}

	}

	public static void BFS(int[][] map, int N, int M, int K) {
		boolean[][][] visited = new boolean[N][M][K + 1]; // 방문 체크

		// 상 하 좌 우
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0, 0, 1, K)); // 시작점
		visited[0][0][K] = true;

		while (!q.isEmpty()) {
			Point top = q.poll();

			if (top.x == M - 1 && top.y == N - 1) {
				System.out.println(top.depth);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nX = top.x + dx[i];
				int nY = top.y + dy[i];

				if (nX >= 0 && nY >= 0 && nX < M && nY < N) { // 맵 안이고
					if (map[nY][nX] == 1) { // 장애물이 있는 경우
						if (top.k >= 1 && !visited[nY][nX][top.k - 1]) {
							q.add(new Point(nX, nY, top.depth + 1, top.k - 1));
							visited[nY][nX][top.k - 1] = true;
						}
					} else if (map[nY][nX] == 0) { // 장애물이 없는 경우
						if (!visited[nY][nX][top.k]) {
							q.add(new Point(nX, nY, top.depth + 1, top.k));
							visited[nY][nX][top.k] = true;
						}
					}
				}
			}

		}

		System.out.println(-1);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 도착해야할 좌표 (y,x)좌표
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 벽 뚫을 수 있는 개수

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = input.charAt(j) - '0';
		}

		BFS(map, N, M, K);
		
		br.close();
	}

}
