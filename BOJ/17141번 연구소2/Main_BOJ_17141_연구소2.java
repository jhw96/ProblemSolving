package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17141_연구소2 {

	static int N, M;
	static int[][] map;
	static ArrayList<int[]> possibleVirus = new ArrayList<int[]>(); // 바이러스를 놓을 수 있는 좌표들
	static int answer = 1000;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class Virus {
		int x;
		int y;
		int depth;

		public Virus(int x, int y, int depth) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
		}

	}

	private static void virusSpread(boolean[] selected, int size) {
		boolean[][] visited = new boolean[N + 1][N + 1];

		Queue<Virus> q = new LinkedList<Virus>();

		for (int i = 0; i < size; i++) { // 조합에서 뽑힌 위치에 바이러스 초반 설정
			if (selected[i]) {
				int[] choice = possibleVirus.get(i);
				q.add(new Virus(choice[0], choice[1], 0));
				visited[choice[1]][choice[0]] = true;
			}
		}
		int max = 0;
		while (!q.isEmpty()) {
			Virus top = q.poll();
			if (max < top.depth)
				max = top.depth;

			for (int i = 0; i < 4; i++) {
				int nX = top.x + dx[i];
				int nY = top.y + dy[i];

				if (nX >= 1 && nX <= N && nY >= 1 && nY <= N) {
					if (!visited[nY][nX] && map[nY][nX] != 1) { // 방문하지않았고 벽이 아니면
						visited[nY][nX] = true;
						q.add(new Virus(nX, nY, top.depth + 1));
					}
				}
			}
		}

		boolean flag = true;

		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= N; x++) {
				if (!visited[y][x] && map[y][x] != 1) { // 벽이 아닌데 방문하지 않은 곳이 있으면
					flag = false;
					break;
				}
			}
		}

		if (flag) { // 모든 곳을 바이러스로 퍼뜨렸으면
			if (answer > max) {
				answer = max;
			}
		}

	} // virusSpread end

	private static void subset(int start, int step, boolean[] selected, int size) {
		if (step == M) { // M개 조합을 뽑으면

			virusSpread(selected, size); // 바이러스 퍼뜨리기

			return;
		}

		for (int i = start; i < size; i++) {
			selected[i] = true;
			subset(i + 1, step + 1, selected, size);
			selected[i] = false;
		}

	} // subset end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 연구소의 크기
		M = Integer.parseInt(st.nextToken()); // 바이러스의 개수

		map = new int[N + 1][N + 1];

		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 1; x <= N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 2) // 바이러스를 놓을 수 있는 위치
					possibleVirus.add(new int[] { x, y });
			}
		}
		int size = possibleVirus.size();
		subset(0, 0, new boolean[size], size); // 바이러스 놓을 위치 조합

		if (answer != 1000)
			System.out.println(answer);
		else
			System.out.println(-1);

		br.close();
	} // main end

}
