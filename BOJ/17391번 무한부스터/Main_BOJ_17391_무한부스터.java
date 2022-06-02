package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17391_무한부스터 {

	static int N, M; // 세로, 가로
	static int[][] map;
	static int[][] visited; // 방문
	static int[] dx = {  0, 1 };
	static int[] dy = {  1, 0 };

	static class Node {
		int x;
		int y;
		int cnt;
		int booster;

		Node(int x, int y, int cnt, int booster) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.booster = booster;
		}
	} // Node end

	public static void BFS() {

		Queue<Node> q = new LinkedList<Node>();

		q.add(new Node(1, 1, 0, map[1][1]));
		visited[1][1] = 1;

		while (!q.isEmpty()) {
			Node top = q.poll();

			int x = top.x;
			int y = top.y;
			int cnt = top.cnt;
			int booster = top.booster;


			for (int dir = 0; dir <2; dir++) { // 4방향 검사

				for (int a = 1; a <= booster; a++) { // 부스터 이동범위
					int nX = x + a * dx[dir];
					int nY = y + a * dy[dir];

					if (nX >= 1 && nY >= 1 && nX <= M && nY <= N) {
						int nCnt = cnt + 1;
						if (visited[nY][nX] > nCnt) { // 이번이 더 적은 횟수면
							visited[nY][nX] = nCnt;
							q.add(new Node(nX, nY, nCnt, map[nY][nX]));
						}
					}
				}
			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		visited = new int[N + 1][M + 1];

		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				visited[y][x] = Integer.MAX_VALUE;
			}
		}

		BFS();

		System.out.println(visited[N][M]);

		br.close();
	}

}
