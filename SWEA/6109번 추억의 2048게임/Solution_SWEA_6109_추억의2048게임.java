package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_6109_추억의2048게임 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] map;
	static boolean[][] visited;
	static int N;

	private static void moveBox(int x, int y, int dir) {
		boolean flag = false;
		int zX = 0, zY = 0;
		for (int i = 1; i <= N; i++) {
			int nX = x + dx[dir] * i;
			int nY = y + dy[dir] * i;
			if (nX >= 1 && nX <= N && nY >= 1 && nY <= N) {
				if (map[nY][nX] == map[y][x] && !visited[nY][nX]) {
					visited[nY][nX] = true;
					map[nY][nX] *= 2;
					map[y][x] = 0;
					flag = true;
				} else if (map[nY][nX] != 0) {
					if(i==1)
						flag = true;
					break;
				}
				else if (map[nY][nX] == 0) {
					zX = nX;
					zY = nY;
				}
			} else
				break;
		}

		if (!flag) {
			map[zY][zX] = map[y][x];
			map[y][x] = 0;
		}
	}

	private static void game(int dir) {
		if (dir == 0) {
			for (int y = 1; y <= N; y++) {
				if (y == 1)
					continue;
				for (int x = 1; x <= N; x++) {
					if (map[y][x] != 0)
						moveBox(x, y, dir);
				}
			}
		} else if (dir == 1) {
			for (int y = N; y >= 1; y--) {
				if (y == N)
					continue;
				for (int x = 1; x <= N; x++) {
					if (map[y][x] != 0)
						moveBox(x, y, dir);
				}
			}

		} else if (dir == 2) {
			for (int x = 1; x <= N; x++) {
				if (x == 1)
					continue;
				for (int y = 1; y <= N; y++) {
					if (map[y][x] != 0)
						moveBox(x, y, dir);
				}
			}
		} else {
			for (int x = N; x >= 1; x--) {
				if (x == N)
					continue;
				for (int y = 1; y <= N; y++) {
					if (map[y][x] != 0)
						moveBox(x, y, dir);
				}
			}
		}

		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= N; x++) {
				System.out.print(map[y][x] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			String com = st.nextToken();

			int dir = 0;
			if (com.equals("down"))
				dir = 1;
			else if (com.equals("left"))
				dir = 2;
			else if (com.equals("right"))
				dir = 3;

			map = new int[N + 1][N + 1];
			visited = new boolean[N + 1][N + 1];

			for (int y = 1; y <= N; y++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int x = 1; x <= N; x++)
					map[y][x] = Integer.parseInt(st.nextToken());
			}

			System.out.println("#" + tc);

			game(dir);
		}

		br.close();
	}

}
