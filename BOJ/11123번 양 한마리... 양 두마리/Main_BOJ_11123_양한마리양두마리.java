package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_11123_양한마리양두마리 {

	static int H, W; // 높이, 너비
	static char[][] map;
	static boolean[][] visited;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y });
		visited[y][x] = true;

		while (!q.isEmpty()) {
			int[] top = q.poll();
			int sX = top[0];
			int sY = top[1];

			for (int i = 0; i < 4; i++) {
				int nX = sX + dx[i];
				int nY = sY + dy[i];
				if (nX >= 1 && nX <= W && nY >= 1 && nY <= H) {
					if (!visited[nY][nX] && map[nY][nX] == '#') {
						visited[nY][nX] = true;
						q.add(new int[] { nX, nY });
					}
				}

			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H + 1][W + 1];
			visited = new boolean[H + 1][W + 1];

			for (int y = 1; y <= H; y++) {
				String input = br.readLine();
				for (int x = 1; x <= W; x++) {
					map[y][x] = input.charAt(x - 1);
				}
			}
			
			int cnt = 0;
			
			for (int y = 1; y <= H; y++) {
				for (int x = 1; x <= W; x++) {
					if (map[y][x] == '#' && !visited[y][x]) {
						cnt++;
						BFS(x, y);
					}
				}
			}
			
			System.out.println(cnt);

		}

		br.close();
	}

}
