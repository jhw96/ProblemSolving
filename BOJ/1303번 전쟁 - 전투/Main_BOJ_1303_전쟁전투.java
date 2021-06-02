package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1303_전쟁전투 {

	static int N, M;
	static char[][] map;
	static boolean[][] visited;

	private static int BFS(int x, int y, char c) {
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y });
		visited[y][x] = true;
		int cnt = 1;

		while (!q.isEmpty()) {
			int[] top = q.poll();

			for (int i = 0; i < 4; i++) {
				int nX = top[0] + dx[i];
				int nY = top[1] + dy[i];

				if (nX >= 1 && nY >= 1 && nX <= N && nY <= M) {
					if (!visited[nY][nX] && map[nY][nX] == c) {
						visited[nY][nX] = true;
						q.add(new int[] { nX, nY });
						cnt++;
					}
				}
			}

		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 가로 길이
		M = Integer.parseInt(st.nextToken()); // 세로 길이
		map = new char[M + 1][N + 1];
		visited = new boolean[M + 1][N + 1];

		for (int y = 1; y <= M; y++) {
			String input = br.readLine();
			for (int x = 1; x <= N; x++) {
				map[y][x] = input.charAt(x - 1);
			}
		}
		// W: 우리팀, B: 적팀

		int wCnt = 0, bCnt = 0;

		for (int y = 1; y <= M; y++) {
			for (int x = 1; x <= N; x++) {
				if (!visited[y][x]) {
					int result = BFS(x, y, map[y][x]);
					if (map[y][x] == 'W') // 우리팀
						wCnt += (result * result);
					else // 적팀
						bCnt += (result * result);

				}
			}
		}
		
		System.out.println(wCnt + " " + bCnt);

		br.close();
	}

}
