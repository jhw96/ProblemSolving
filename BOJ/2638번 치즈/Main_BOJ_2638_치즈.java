package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2638_치즈 {

	static int N, M;
	static int[][] cheese;
	static boolean flag;
	static boolean[][] outside;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static void injecting() {

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 1, 1 });
		outside[1][1] = true;

		while (!q.isEmpty()) {
			int[] top = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nX = top[0] + dx[dir];
				int nY = top[1] + dy[dir];
				if (nX >= 1 && nY >= 1 && nX <= M && nY <= N) {
					if (cheese[nY][nX] == 0 && !outside[nY][nX]) {
						outside[nY][nX] = true;
						q.add(new int[] { nX, nY });
					}
				}
			}

		}

	} // injecting end

	private static void melting() {
		ArrayList<int[]> target = new ArrayList<int[]>();

		for (int y = 1; y <= N; y++) { // 2변 이상 외부공기와 닿는 치즈 찾기
			for (int x = 1; x <= M; x++) {
				if (cheese[y][x] == 1) {
					int cnt = 0;
					for (int dir = 0; dir < 4; dir++) {
						int nX = x + dx[dir];
						int nY = y + dy[dir];
						if (nX >= 1 && nX <= M && nY >= 1 && nY <= N && outside[nY][nX]) {
							cnt++;
						}
					}

					if (cnt >= 2) {
						target.add(new int[] { x, y });
					}
				}
			}
		}

		for (int i = 0; i < target.size(); i++) { // 치즈 녹이기
			int[] place = target.get(i);
			cheese[place[1]][place[0]] = 0;
		}

		for (int y = 1; y <= N; y++)
			System.out.println(Arrays.toString(cheese[y]));
		System.out.println();

	} // melting end

	private static void check() {
		boolean find = false;

		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= M; x++) {
				if (cheese[y][x] == 1) {
					find = true;
					break;
				}
			}
		}

		if (!find)
			flag = true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheese = new int[N + 1][M + 1];

		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= M; x++) {
				cheese[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		while (!flag) {
			if (answer == 0)
				check();
			outside = new boolean[N + 1][M + 1];
			answer++;
			injecting();
			melting();
			check();
		}

		System.out.println(answer);

		br.close();
	}

}
