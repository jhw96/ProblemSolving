package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_14716_현수막 {

	static int[][] paper;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int M = Integer.parseInt(st.nextToken()); // 세로길이
		int N = Integer.parseInt(st.nextToken()); // 가로길이

		paper = new int[M][N];

		for (int y = 0; y < M; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 0; x < N; x++) {
				paper[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		boolean[][] visited = new boolean[M][N];
		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				if (!visited[y][x] && paper[y][x] == 1) {
					BFS(x, y, visited, M, N);
					answer++;
				}
			}
		}

		System.out.println(answer);

		br.close();
	}

	private static void BFS(int x, int y, boolean[][] visited, int m, int n) {
		// 위에서부터 시계방향으로
		int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y });
		visited[y][x] = true;

		while (!q.isEmpty()) {
			int[] top = q.poll();

			for (int i = 0; i < 8; i++) {
				int nX = top[0] + dx[i];
				int nY = top[1] + dy[i];

				if (nX >= 0 && nY >= 0 && nX < n && nY < m) {
					if (!visited[nY][nX] && paper[nY][nX] == 1) {
						visited[nY][nX] = true;
						q.add(new int[] { nX, nY });
					}
				}
			}
		}

	}

}
