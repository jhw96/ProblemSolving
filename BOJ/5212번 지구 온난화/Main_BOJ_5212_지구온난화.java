package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_5212_지구온난화 {

	static int R, C; // 세로, 가로
	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];

		ArrayList<int[]> remove = new ArrayList<int[]>();

		for (int y = 1; y <= R; y++) {
			String input = br.readLine();
			for (int x = 1; x <= C; x++) {
				map[y][x] = input.charAt(x - 1);
			}
		}

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		for (int y = 1; y <= R; y++) {
			for (int x = 1; x <= C; x++) {
				if (map[y][x] == 'X') {
					int cnt = 0;
					for (int dir = 0; dir < 4; dir++) {
						int nX = x + dx[dir];
						int nY = y + dy[dir];
						if (nX >= 1 && nX <= C && nY >= 1 && nY <= R && map[nY][nX] == '.')
							cnt++;
						else if (nX < 1 || nX > C || nY < 1 || nY > R)
							cnt++;
					}
					if (cnt >= 3)
						remove.add(new int[] { x, y });
				}
			}
		}

		for (int i = 0; i < remove.size(); i++) {
			int[] place = remove.get(i);
			map[place[1]][place[0]] = '.';
		}


		for (int y = 1; y <= R; y++) {
			int cnt = 0;
			for (int x = 1; x <= C; x++) {
				if (map[y][x] == '.')
					cnt++;
				else
					break;
			}
			if (cnt == C) {
				for (int x = 1; x <= C; x++)
					map[y][x] = 'b';
			} else
				break;
		}

		for (int y = R; y >= 1; y--) {
			int cnt = 0;
			for (int x = 1; x <= C; x++) {
				if (map[y][x] == '.' || map[y][x] == 'b')
					cnt++;
				else
					break;
			}
			if (cnt == C) {
				for (int x = 1; x <= C; x++)
					map[y][x] = 'b';
			} else
				break;
		}

		for (int x = 1; x <= C; x++) {
			int cnt = 0;
			for (int y = 1; y <= R; y++) {
				if (map[y][x] == '.' || map[y][x] == 'b')
					cnt++;
				else
					break;
			}
			if (cnt == R) {
				for (int y = 1; y <= R; y++)
					map[y][x] = 'b';
			} else
				break;
		}

		for (int x = C; x >= 1; x--) {
			int cnt = 0;
			for (int y = 1; y <= R; y++) {
				if (map[y][x] == '.' || map[y][x] == 'b')
					cnt++;
				else
					break;
			}
			if (cnt == R) {
				for (int y = 1; y <= R; y++)
					map[y][x] = 'b';
			} else
				break;
		}
		
		
		for(int y=1; y<=R; y++) {
			boolean flag = false;
			for(int x=1; x<=C; x++) {
				if(map[y][x] == 'b')
					continue;
				flag = true;
				System.out.print(map[y][x]);
			}
			if(flag)
				System.out.println();
		}

		br.close();
	}

}
