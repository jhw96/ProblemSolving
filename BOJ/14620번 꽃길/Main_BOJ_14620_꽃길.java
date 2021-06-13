package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_14620_꽃길 {

	static int N; // 화단의 크기
	static int[][] map;
	static ArrayList<int[]> possible = new ArrayList<int[]>(); // 씨앗을 심을 후보 땅
	static boolean[][] selected; // 선택된 땅 표시
	static int min = Integer.MAX_VALUE;
	static int totalMoney = 0;
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, -1, 1, 0, 0 };

	private static int cal(int x, int y) {
		if (selected[y][x])
			return -1;

		int money = map[y][x];

		for (int i = 1; i <= 4; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];

			if (selected[nY][nX])
				return -1;
			money += map[nY][nX];
		}

		return money;
	} // cal end

	private static void initSelect(int x, int y) {

		for (int i = 0; i < 5; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];
			selected[nY][nX] = !selected[nY][nX];
		}

	}

	private static void subset(int start, int step) {
		if (step == 3) {
			if (totalMoney < min)
				min = totalMoney;
			return;
		}

		for (int i = start; i < possible.size(); i++) {
			int[] now = possible.get(i);
			int x = now[0];
			int y = now[1];
			int money = cal(x, y);

			if (money == -1)
				continue;

			totalMoney += money;
			initSelect(x, y);
			subset(i + 1, step + 1);
			initSelect(x, y);
			totalMoney -= money;
		}

	} // subset end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		map = new int[N + 1][N + 1];
		selected = new boolean[N + 1][N + 1];

		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (x != 1 && y != 1 && x != N && y != N) // 화단 테두리가 아니라면
					possible.add(new int[] { x, y });
			}
		}

		subset(0, 0);
		System.out.println(min);

		br.close();
	}

}
