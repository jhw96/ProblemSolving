package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_11559_PuyoPuyo {

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static char[][] map;
	static boolean popping;
	static int answer = 0;
	static int cnt;

	public static void popPuyo() { // 뿌요 터트리기

		boolean[][] visited = new boolean[13][7];
		ArrayList<int[]> pointer = new ArrayList<int[]>();
		Queue<int[]> q = new LinkedList<int[]>();

		for (int y = 1; y <= 12; y++) {
			for (int x = 1; x <= 6; x++) {
				char now = map[y][x];
				if (now != '.') {
					pointer.clear();
					pointer.add(new int[] { x, y });
					q.add(new int[] { x, y });
					map[y][x] = '.';
					visited[y][x] = true;

					while (!q.isEmpty()) {
						int[] top = q.poll();

						for (int d = 0; d < 4; d++) {
							int nX = top[0] + dx[d];
							int nY = top[1] + dy[d];

							if (nX >= 1 && nY >= 1 && nX <= 6 && nY <= 12 && !visited[nY][nX]) {
								if (map[nY][nX] == now) {
									map[nY][nX] = '.';
									visited[nY][nX] = true;
									pointer.add(new int[] { nX, nY });
									q.add(new int[] { nX, nY });
								}
							}

						}

					} // q end

					int size = pointer.size();
					if (size >= 4) { // 연쇄작용 성공시
						popping = true;
					} else { // 연쇄작용 실패시 원상복구
						for (int i = 0; i < size; i++) {
							int[] p = pointer.get(i);
							map[p[1]][p[0]] = now;
						}
					}

				}
			}
		}

	}

	public static void cleanMap() { // 맵 정리하기
		char[][] clone = new char[13][7];

		for (int y = 1; y <= 12; y++)
			for (int x = 1; x <= 6; x++)
				clone[y][x] = map[y][x];

		for (int y = 1; y <= 12; y++) {
			for (int x = 1; x <= 6; x++) {
				if (clone[y][x] == '.') { // 빈칸이면
					int place = y; // 끌어내려야할 위치
					int down = -1; // 끌어내릴 뿌요의 위치
					for (int s = y + 1; s <= 12; s++) {
						if (clone[s][x] != '.') { // 뿌요 발견
							down = s;
							break;
						}
					}

					if (down != -1) { // 뿌요를 발견했으면
						clone[place][x] = clone[down][x];
						clone[down][x] = '.';
					}

				}
			}
		}

		for (int y = 1; y <= 12; y++)
			for (int x = 1; x <= 6; x++)
				map[y][x] = clone[y][x];

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[13][7]; // 세로 12, 가로 6

		for (int y = 12; y >= 1; y--) {
			String input = br.readLine();
			for (int x = 0; x < 6; x++)
				map[y][x + 1] = input.charAt(x);
		}

		while (true) {
			popping = false;

			popPuyo();

//			for (int i = 12; i >= 1; i--)
//				System.out.println(Arrays.toString(map[i]));
//			System.out.println();

			cleanMap();

			if (popping) // 터진게 있다면
				answer++;
			else // 터진게 없다면
				break;
		}

		System.out.println(answer);

		br.close();
	}

}
