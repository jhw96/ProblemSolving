package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17086_아기상어2 {

	static int N, M; // 맵 크기
	static ArrayList<int[]> sharks = new ArrayList<int[]>();
	static int[][] map;
	static boolean[][] visited;
	static int max = Integer.MIN_VALUE;
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 };

	static class Node {
		int x;
		int y;
		int distance;

		Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}

	private static void BFS(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x, y, 0));

		while (!q.isEmpty()) {
			Node top = q.poll();
			int sX = top.x;
			int sY = top.y;
			int distance = top.distance;

			if (map[sY][sX] == 1) {
				if (max < distance)
					max = distance;
				return;
			}

			for (int i = 0; i < 8; i++) {
				int nX = sX + dx[i];
				int nY = sY + dy[i];
				if (nX >= 1 && nX <= M && nY >= 1 && nY <= N) {
					if (!visited[nY][nX]) {
						q.add(new Node(nX, nY, distance + 1));
						visited[nY][nX] = true;
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

		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] == 1)
					sharks.add(new int[] { x, y });
			}
		}

		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= M; x++) {
				if (map[y][x] == 0) {
					visited = new boolean[N + 1][M + 1];
					BFS(x, y);
				}
			}
		}
		
		System.out.println(max);

		br.close();
	}

}
