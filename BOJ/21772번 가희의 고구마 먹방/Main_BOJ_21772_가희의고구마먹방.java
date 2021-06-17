package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_21772_가희의고구마먹방 {

	static int R, C, T; // 세로 크기, 가로 크기, 주어진 시간
	static char[][] map;
	static boolean[][][] visited;
	static int max;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static void DFS(int x, int y, int time, int goguma) {
		if (max < goguma)
			max = goguma;

		if (time == 0)
			return;

		for (int i = 0; i < 4; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];

			if (nX >= 1 && nY >= 1 && nX <= C && nY <= R) {
				if (map[nY][nX] == '.')
					DFS(nX, nY, time - 1, goguma);
				else if (map[nY][nX] == 'S') {
					map[nY][nX] = '.';
					DFS(nX, nY, time - 1, goguma + 1);
					map[nY][nX] = 'S';
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];
		visited = new boolean[11][R + 1][C + 1];

		int sX = 0, sY = 0;

		for (int y = 1; y <= R; y++) {
			String input = br.readLine();
			for (int x = 1; x <= C; x++) {
				map[y][x] = input.charAt(x - 1);
				if (map[y][x] == 'G') {
					sX = x;
					sY = y;
					map[y][x] = '.';
				}
			}
		}

		DFS(sX, sY, T, 0);

		System.out.println(max);

		br.close();
	}

}
