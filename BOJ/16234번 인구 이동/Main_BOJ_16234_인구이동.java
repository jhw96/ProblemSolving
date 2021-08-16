package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16234_인구이동 {

	static int N, L, R; // 땅의 크기, 최소 인구 차이, 최대 인구 차이
	static boolean flag;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static void openCountry(int x, int y) { // 국경선 오픈하기
		ArrayList<int[]> cords = new ArrayList<int[]>(); // 오픈한 곳 좌표 기억하기

		Queue<int[]> q = new LinkedList<int[]>();
		visited[y][x] = true;
		q.add(new int[] { x, y, map[y][x] });
		int sum = map[y][x], cnt = 1; // 인구 수 맞추기를 위한 변수
		cords.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] top = q.poll();
			int tX = top[0];
			int tY = top[1];
			int pop = top[2];

			for (int dir = 0; dir < 4; dir++) {
				int nX = tX + dx[dir];
				int nY = tY + dy[dir];
				if (nX >= 1 && nX <= N && nY >= 1 && nY <= N) {
					if (!visited[nY][nX]) {
						int diff = Math.abs(map[nY][nX] - pop);
						if (diff >= L && diff <= R) {
							q.add(new int[] { nX, nY, map[nY][nX] });
							cords.add(new int[] { nX, nY });
							visited[nY][nX] = true;
							sum += map[nY][nX];
							cnt++;
						}
					}
				}
			}

		}

		if (cnt != 1) {
			int movePop = sum / cnt;
			flag = true;
			for (int i = 0; i < cords.size(); i++) {
				int[] cord = cords.get(i);
				map[cord[1]][cord[0]] = movePop;
			}
		}

	} // openCountry end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];

		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= N; x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;

		while (true) {
			flag = false;
			visited = new boolean[N + 1][N + 1];

			for (int y = 1; y <= N; y++) {
				for (int x = 1; x <= N; x++) {
					if (!visited[y][x]) {
						openCountry(x, y);
					}
				}
			}
			
			if (!flag)
				break;
			else
				answer++;
		}

		System.out.println(answer);

		br.close();
	} // main end

}
