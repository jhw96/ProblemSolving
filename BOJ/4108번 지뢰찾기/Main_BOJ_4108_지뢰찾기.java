package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_4108_지뢰찾기 {
	static int R, C;

	private static void search(int x, int y, char[][] map) {

		int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int mineCnt = 0;
		
		for (int dir = 0; dir < 8; dir++) {
			int nX = x + dx[dir];
			int nY = y + dy[dir];
			if (nX >= 0 && nY >= 0 && nX < C && nY < R && map[nY][nX] == '*') {
				mineCnt++;
			}
		}
		
		map[y][x] = (char) (mineCnt + '0');

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken()); // 세로 길이
			C = Integer.parseInt(st.nextToken()); // 가로 길이

			if (R == 0 && C == 0)
				break;

			char[][] map = new char[R][C];
			
			for(int y=0; y<R; y++) {
				String input = br.readLine();
				for(int x=0; x<C; x++) {
					map[y][x] = input.charAt(x);
				}
			}

			for (int y = 0; y < R; y++) {
				for (int x = 0; x < C; x++) {
					if (map[y][x] != '*') {
						search(x, y, map);
					}
				}
			}

			for (int y = 0; y < R; y++) {
				for (int x = 0; x < C; x++) {
					System.out.print(map[y][x]);
				}
				System.out.println();
			}

		}

		br.close();
	}

}
