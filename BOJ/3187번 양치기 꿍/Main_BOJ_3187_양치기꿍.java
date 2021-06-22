package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_3187_양치기꿍 {

	static int R, C; // 세로, 가로 길이
	static char[][] map;
	static boolean[][] visited;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int shipCnt, woolfCnt;

	private static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y });
		visited[y][x] = true;

		int cnt1 = 0;
		int cnt2 = 0;

		if (map[y][x] == 'k')
			cnt1 = 1;
		else if (map[y][x] == 'v')
			cnt2 = 1;

		while (!q.isEmpty()) {
			int[] top = q.poll();
			int sX = top[0];
			int sY = top[1];

			for (int i = 0; i < 4; i++) {
				int nX = sX + dx[i];
				int nY = sY + dy[i];
				if (nX >= 1 && nX <= C && nY >= 1 && nY <= R) {
					if (!visited[nY][nX] && map[nY][nX] != '#') {
						if (map[nY][nX] == 'k')
							cnt1++;
						else if (map[nY][nX] == 'v')
							cnt2++;
						q.add(new int[] { nX, nY });
						visited[nY][nX] = true;
					}
				}
			}

		}

		if (cnt1 > cnt2)
			shipCnt += cnt1;
		else
			woolfCnt += cnt2;

	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];
		visited = new boolean[R + 1][C + 1];

		for (int y = 1; y <= R; y++) {
			String input = br.readLine();
			for (int x = 1; x <= C; x++)
				map[y][x] = input.charAt(x - 1);
		}

		for (int y = 1; y <= R; y++) {
			for (int x = 1; x <= C; x++) {
				if (!visited[y][x] && map[y][x] != '#') {
					BFS(x, y);
				}
			}
		}

		System.out.println(shipCnt + " " + woolfCnt);

		br.close();
	}

}
