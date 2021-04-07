package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_4179_불 {

	static Queue<int[]> fire = new LinkedList<int[]>();
	static Queue<int[]> jihun = new LinkedList<int[]>();
	static boolean flag = false;
	static int answer = 0;

	public static void BFS(char[][] map, int R, int C, int who) {
		// 상 하 좌 우
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		boolean[][] visited = new boolean[R][C];

		int size = 0;

		if (who == 1) // 불이면
			size = fire.size();
		else if (who == 2) // 지훈이면
			size = jihun.size();

		if (who == 2 && size == 0) {
			System.out.println("IMPOSSIBLE");
			flag = true;
			return;
		}

		for (int i = 0; i < size; i++) {
			int[] top = new int[2];
			if (who == 1)
				top = fire.poll();
			else if (who == 2) {
				top = jihun.poll();
				if(top[0] == 0 || top[0] == C-1 || top[1] == 0 || top[1] == R-1) {
					System.out.println(answer+1);
					flag = true;
					return;
				}
			}

			for (int dir = 0; dir < 4; dir++) {
				int nX = top[0] + dx[dir];
				int nY = top[1] + dy[dir];
				if (nX >= 0 && nX < C && nY >= 0 && nY < R && !visited[nY][nX]) { // 배열의 범위 안이면
					if (who == 1) {
						if (map[nY][nX] == '.' || map[nY][nX] == 'J') {
							visited[nY][nX] = true;
							map[nY][nX] = 'F';
							fire.add(new int[] { nX, nY });
						}
					} else if (who == 2) {
						if (map[nY][nX] == '.') {
							visited[nY][nX] = true;
							map[nY][nX] = 'J';
							jihun.add(new int[] { nX, nY });
						}
					}

				}

			}

		}
	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int R = Integer.parseInt(st.nextToken()); // 세로 길이
		int C = Integer.parseInt(st.nextToken()); // 가로 길이

		char[][] map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'F')
					fire.add(new int[] { j, i });
				else if (map[i][j] == 'J')
					jihun.add(new int[] { j, i });
			}
		}


		while (true) {
			
			BFS(map, R, C, 1);
			BFS(map, R, C, 2);
			answer++;

			if (flag)
				break;
		}

		br.close();
	}

}
