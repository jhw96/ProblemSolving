package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_21938_영상처리 {

	static int N, M; // 세로 가로
	static int T; // 경계값

	static int[][] pixels;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();

		q.add(new int[] { x, y });
		visited[y][x] = true;

		while (!q.isEmpty()) {
			int[] top = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nX = top[0] + dx[dir];
				int nY = top[1] + dy[dir];
				if (nX >= 1 && nX <= M && nY >= 1 && nY <= N) {
					if (!visited[nY][nX] && pixels[nY][nX] >= T) {
						visited[nY][nX] = true;
						q.add(new int[] { nX, nY });
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		pixels = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= M; x++) {
				int sum = 0;
				for (int i = 1; i <= 3; i++) {
					sum += Integer.parseInt(st.nextToken());
				}
				pixels[y][x] = sum;
			}
		}

		T = Integer.parseInt(br.readLine()) * 3;

		int answer = 0;

		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= M; x++) {
				if (!visited[y][x] && pixels[y][x] >= T) {
					answer++;
					BFS(x, y);
				}
			}
		}

		System.out.println(answer);

		br.close();
	}

}
