package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2589_보물섬 {

	static int height, width;
	static char[][] map;
	static int max;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class Node {
		int x;
		int y;
		int depth;

		public Node(int x, int y, int depth) {
			super();
			this.x = x;
			this.y = y;
			this.depth = depth;
		}

	}

	public static void BFS(int x, int y) {
		boolean[][] visited = new boolean[height + 1][width + 1];
		Queue<Node> q = new LinkedList<Node>();

		q.add(new Node(x, y, 0));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			Node top = q.poll();

			if (top.depth > max)
				max = top.depth;

			for (int i = 0; i < 4; i++) {
				int nX = top.x + dx[i];
				int nY = top.y + dy[i];
				if (nX >= 1 && nY >= 1 && nX <= width && nY <= height) {
					if (!visited[nY][nX] && map[nY][nX] == 'L') {
						visited[nY][nX] = true;
						q.add(new Node(nX, nY, top.depth + 1));
					}
				}
			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());

		map = new char[height + 1][width + 1];

		for (int y = 1; y <= height; y++) {
			String input = br.readLine();
			for (int x = 1; x <= width; x++) {
				map[y][x] = input.charAt(x - 1);
			}
		}

		for (int y = 1; y <= height; y++) {
			for (int x = 1; x <= width; x++) {
				if (map[y][x] == 'L') {
					BFS(x, y);
				}
			}
		}

		System.out.println(max);

		br.close();
	}

}
