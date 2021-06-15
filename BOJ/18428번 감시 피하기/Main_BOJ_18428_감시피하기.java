package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_18428_감시피하기 {

	static int N;
	static ArrayList<int[]> candidate = new ArrayList<int[]>(); // 장애물 설치 후보
	static ArrayList<int[]> teachers = new ArrayList<int[]>(); // 선생님 위치
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static char[][] map;
	static boolean flag;

	private static boolean check(int x, int y) {
		if (x >= 1 && y >= 1 && x <= N && y <= N)
			return true;
		return false;
	}

	private static boolean simulation(char[][] clone) {

		for (int i = 0; i < teachers.size(); i++) {
			int[] teacher = teachers.get(i);
			int x = teacher[0];
			int y = teacher[1];

			for (int dir = 0; dir < 4; dir++) {
				int nX = x + dx[dir];
				int nY = y + dy[dir];

				while (check(nX, nY)) {
					if (clone[nY][nX] == 'S') {// 학생 발견 시
						return false;
					} else if (clone[nY][nX] == 'O') // 장애물 발견 시
						break;

					nX += dx[dir];
					nY += dy[dir];
				}
			}
		}
		return true;
	}

	private static void combi(int start, int step, boolean[] selected) {
		if (step == 3) {
			char[][] clone = new char[N + 1][N + 1];

			for (int y = 1; y <= N; y++) {
				for (int x = 1; x <= N; x++) {
					clone[y][x] = map[y][x];
				}
			}

			for (int i = 0; i < candidate.size(); i++) {
				if (selected[i]) {
					int[] place = candidate.get(i);
					clone[place[1]][place[0]] = 'O';
				}
			}

			if (simulation(clone)) {
				System.out.println("YES");
				flag = true;
				return;
			}

		}

		for (int i = start; i < candidate.size(); i++) {
			selected[i] = true;
			combi(i + 1, step + 1, selected);
			selected[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new char[N + 1][N + 1];
		boolean[][] selected = new boolean[N + 1][N + 1];

		for (int y = 1; y <= N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= N; x++) {
				map[y][x] = st.nextToken().charAt(0);
				if (map[y][x] == 'T') {
					teachers.add(new int[] { x, y });
				}
			}
		}
		for (int t = 0; t < teachers.size(); t++) {
			int[] teacher = teachers.get(t);
			int x = teacher[0];
			int y = teacher[1];

			for (int i = 0; i < 4; i++) {
				int nX = x + dx[i];
				int nY = y + dy[i];
				if (check(nX, nY) && map[nY][nX] == 'X') {
					if (!selected[nY][nX]) {
						selected[nY][nX] = true;
						candidate.add(new int[] { nX, nY });
					}
				}
			}
		}

		combi(0, 0, new boolean[candidate.size()]);

		if (!flag)
			System.out.println("NO");

		br.close();
	}

}
