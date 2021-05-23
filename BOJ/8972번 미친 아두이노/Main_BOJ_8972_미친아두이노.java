package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_8972_미친아두이노 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int R = Integer.parseInt(st.nextToken()); // 보드의 세로 길이
		int C = Integer.parseInt(st.nextToken()); // 보드의 가로 길이

		// 움직임 명령에 따른 이동방향
		int[] dx = { 0, -1, 0, 1, -1, 0, 1, -1, 0, 1 };
		int[] dy = { 0, 1, 1, 1, 0, 0, 0, -1, -1, -1 };

		ArrayList<int[]> robots = new ArrayList<int[]>(); // 아두이노 좌표
		ArrayList<Integer> command = new ArrayList<Integer>(); // 종수의 움직임
		int[] where = new int[2]; // 종수의 좌표

		int[][] map = new int[R + 1][C + 1]; // 로봇의 개수 맵 위에 표시

		for (int y = 1; y <= R; y++) {
			String input = br.readLine();
			for (int x = 1; x <= C; x++) {
				char what = input.charAt(x - 1);
				if (what == 'I') { // 종수의 위치
					where[0] = x;
					where[1] = y;
					map[y][x] = 0;
				} else if (what == 'R') { // 로봇의 위치
					robots.add(new int[] { x, y });
					map[y][x] = 1;
				} else {
					map[y][x] = 0;
				}
			}
		}

		String input = br.readLine();
		for (int i = 0; i < input.length(); i++)
			command.add(input.charAt(i) - '0');
		boolean flag = false;
		// 로봇은 종수와 가까워지는 거리로 한칸씩 움직임 (|r1-r2| + |s1-s2|)
		for (int c = 0; c < command.size(); c++) { // 종수 움직임만큼 게임진행
			if (flag)
				break;

			{ // 종수 이동하기
				int dir = command.get(c);
				where[0] += dx[dir];
				where[1] += dy[dir];
				if (map[where[1]][where[0]] == 1) {
					flag = true;
					System.out.println("kraj " + (c+1));

					break;
				}
			}

			{// 로봇 이동하기
				for (int r = 0; r < robots.size(); r++) {
					int[] now = robots.get(r);
					int min = 9999;
					int minX = 0, minY = 0;
					for (int dir = 1; dir < 10; dir++) { // 종수와 가까워지는 거리 찾기
						if (dir == 5)
							continue;
						int nX = now[0] + dx[dir];
						int nY = now[1] + dy[dir];
						int distance = Math.abs(where[0] - nX) + Math.abs(where[1] - nY);

						if (min > distance) {
							min = distance;
							minX = nX;
							minY = nY;
						}
					}
					if (minY == where[1] && minX == where[0]) { // 로봇이 종수를 따라잡았으면
						System.out.println("kraj " + (c+1));
						flag = true;
						break;
					}
					map[now[1]][now[0]] -= 1;
					map[minY][minX] += 1;
				}
			}

			robots.clear();

			for (int y = 1; y <= R; y++) {
				for (int x = 1; x <= C; x++) {
					if (map[y][x] > 1) { // 여러 로봇이 있으면 터트리기
						map[y][x] = 0;
					} else if (map[y][x] == 1) {
						robots.add(new int[] { x, y });
					}
				}
			}

		} // 게임진행 end

		if (!flag) {
			for (int y = 1; y <= R; y++) {
				for (int x = 1; x <= C; x++) {
					if (x == where[0] && y == where[1]) { // 종수의 위치
						System.out.print('I');
					} else {
						if (map[y][x] < 1)
							System.out.print('.');
						else
							System.out.print('R');
					}
				}
				System.out.println();
			}
		}

		br.close();
	} // main end

} // class end
