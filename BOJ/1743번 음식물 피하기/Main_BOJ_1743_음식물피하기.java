package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1743_음식물피하기 {

	static int N, M, K;
	static int[][] map;
	static boolean[][] visited;
	static int answer;

	private static void BFS(int sX, int sY) {
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		int cnt = 1;

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { sX, sY });
		visited[sY][sX] = true;

		while (!q.isEmpty()) {
			int[] top = q.poll();
			int x = top[0];
			int y = top[1];

			for (int i = 0; i < 4; i++) {
				int nX = x + dx[i];
				int nY = y + dy[i];
				if (nX >= 1 && nX <= M && nY >= 1 && nY <= N) {
					if (!visited[nY][nX] && map[nY][nX] == 1) {
						visited[nY][nX] = true;
						q.add(new int[] { nX, nY });
						cnt++;
					}
				}
			}
		}

		if (cnt > answer)
			answer = cnt;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 세로 길이
		M = Integer.parseInt(st.nextToken()); // 가로 길이
		K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기의 개수

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			map[y][x] = 1;
		}

		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= M; x++) {
				if (!visited[y][x] && map[y][x] == 1) {
					BFS(x, y);
				}
			}
		}

		System.out.println(answer);

		br.close();
	}

}
