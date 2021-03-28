package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2206_벽부수고이동하기 {

	static class Pointer {
		int x;
		int y;
		int k;
		int depth;

		public Pointer(int x, int y, int k, int depth) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.depth = depth;
		}
	}

	public static void BFS(int[][] map, boolean[][][] visited, int N, int M) {

		// 상 하 좌 우
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		Queue<Pointer> q = new LinkedList<Pointer>();
		q.add(new Pointer(0, 0, 1, 1));
		visited[0][0][1] = true;

		while (!q.isEmpty()) {
			Pointer top = q.poll();

			if (top.x == M-1 && top.y == N-1) {
				System.out.println(top.depth);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nX = top.x + dx[i];
				int nY = top.y + dy[i];

				if (nY >= 0 && nX >= 0 && nY < N && nX < M) {
					if (map[nY][nX] == 1 && top.k > 0 && !visited[nY][nX][top.k - 1]) {
						q.add(new Pointer(nX, nY, top.k - 1, top.depth + 1));
						visited[nY][nX][top.k - 1] = true;
					}
					if (map[nY][nX] == 0 && !visited[nY][nX][top.k]) {
						q.add(new Pointer(nX, nY, top.k, top.depth + 1));
						visited[nY][nX][top.k] = true;
					}
				}

			}

		}

		System.out.println(-1);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 세로길이
		int M = Integer.parseInt(st.nextToken()); // 가로길이

		int[][] map = new int[N][M];
		boolean[][][] visited = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = input.charAt(j) - '0';
		}

		BFS(map, visited, N, M);

		br.close();
	}

}
