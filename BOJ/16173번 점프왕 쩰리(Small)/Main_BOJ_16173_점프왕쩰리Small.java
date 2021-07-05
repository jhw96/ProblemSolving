package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16173_점프왕쩰리Small {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static boolean flag;

	private static void BFS() {
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		Queue<int[]> q = new LinkedList<int[]>();

		q.add(new int[] { 1, 1 });
		visited[1][1] = true;

		while (!q.isEmpty()) {
			int[] top = q.poll();
			int x = top[0];
			int y = top[1];

			if (x == N && y == N) {
				flag = true;
				return;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nX = x + map[y][x] * dx[dir];
				int nY = y + map[y][x] * dy[dir];

				if (nX >= 1 && nY >= 1 && nX <= N && nY <= N) {
					if (!visited[nY][nX]) {
						visited[nY][nX] = true;
						q.add(new int[] { nX, nY });
					}
				}

			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];

		for (int y = 1; y <= N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		BFS();
		
		if(flag)
			System.out.println("HaruHaru");
		else
			System.out.println("Hing");

		br.close();
	}

}
