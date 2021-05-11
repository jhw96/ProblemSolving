package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_10026_적록색약 {

	static int N;
	static char[][] map;
	static boolean[][] normal;
	static boolean[][] abnormal;

	public static void DFS(int sx, int sy, char color, int who) {
		// 상 하 좌 우
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { sx, sy });

		if (who == 0) // 정상
			normal[sy][sx] = true;
		else // 색약
			abnormal[sy][sx] = true;

		while (!q.isEmpty()) {
			int[] top = q.poll();

			for (int i = 0; i < 4; i++) {
				int nX = top[0] + dx[i];
				int nY = top[1] + dy[i];
				if (nX >= 1 && nY >= 1 && nX <= N && nY <= N) {
					if (who == 0) { // 정상인 경우
						if (map[nY][nX] == color && !normal[nY][nX]) { // 같은 색인 경우에만 같은 구역으로
							normal[nY][nX] = true;
							q.add(new int[] { nX, nY });
						}
					} else { // 색약인 경우
						if (color == 'R' || color == 'G') { // 초록, 빨강일 경우
							if (map[nY][nX] == 'G' || map[nY][nX] == 'R') { // 초록이나 빨강일 경우 같은 애로 침
								if (!abnormal[nY][nX]) {
									abnormal[nY][nX] = true;
									q.add(new int[] { nX, nY });
								}
							}
						} else { // 파랑일 경우
							if (map[nY][nX] == 'B' && !abnormal[nY][nX]) {
								abnormal[nY][nX] = true;
								q.add(new int[] { nX, nY });
							}
						}
					}

				}
			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new char[N + 1][N + 1];
		normal = new boolean[N + 1][N + 1]; // 색약이 아닌 사람의 방문여부
		abnormal = new boolean[N + 1][N + 1]; // 색약인 사람의 방문여부

		int normCnt = 0;
		int abCnt = 0;

		for (int y = 1; y <= N; y++) {
			String input = br.readLine();
			for (int x = 1; x <= N; x++)
				map[y][x] = input.charAt(x-1);
		}

		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= N; x++) {
				if (!normal[y][x]) { // 색약이 아닌 사람이 방문하지 않았으면
					normCnt++;
					DFS(x, y, map[y][x], 0);
				}
				if (!abnormal[y][x]) { // 색약인 사람이 방문하지 않았으면
					abCnt++;
					DFS(x, y, map[y][x], 1);
				}
			}
		}
		
		System.out.println(normCnt + " " + abCnt);

		br.close();
	}

}
