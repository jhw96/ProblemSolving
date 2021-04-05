package com.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_Jungol_1824_스도쿠 {

	static ArrayList<int[]> blank = new ArrayList<int[]>();
	static boolean flag = false;

	public static boolean check(int[][] map, int x, int y, int num) {

		for (int i = 1; i <= 9; i++) { // 가로줄 검사
			if (map[y][i] == num)
				return false;

		}

		for (int i = 1; i <= 9; i++) { // 세로줄 검사
			if (map[i][x] == num)
				return false;
		}

		// 작은 3x3 칸에서의 위치
		int rel_x = x % 3 == 0 ? 3 : x % 3;
		int rel_y = y % 3 == 0 ? 3 : y % 3;

		int start_x = x - rel_x + 1;
		int start_y = y - rel_y + 1;

		for (int i = start_y; i <= start_y + 2; i++) { // 3x3 작은칸 검사
			for (int j = start_x; j <= start_x + 2; j++) {
				if (map[i][j] == num)
					return false;
			}
		}

		return true;
	}

	public static void solve(int[][] map, int cnt, int blankCnt) {
		if (flag)
			return;

		if (cnt == blankCnt) { // 모든 빈칸 채웠으면
			flag = true;
			for (int y = 1; y <= 9; y++) {
				for (int x = 1; x <= 9; x++) {
					System.out.print(map[y][x] + " ");
				}
				System.out.println();
			}
			return;
		}

		// 현재 빈칸의 좌표
		int x = blank.get(cnt)[0];
		int y = blank.get(cnt)[1];

		for (int num = 1; num <= 9; num++) { // 빈칸에 1부터 9까지 넣어보기

			if (check(map, x, y, num)) {
				map[y][x] = num;
				solve(map, cnt + 1, blankCnt);
				map[y][x] = 0;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[10][10];

		int blankCnt = 0; // 빈칸 갯수
		for (int y = 1; y <= 9; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= 9; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 0) {// 빈칸 갯수 및 좌표
					blank.add(new int[] { x, y });
					blankCnt++;
				}
			}
		}

		solve(map, 0, blankCnt);

		br.close();
	}

}
