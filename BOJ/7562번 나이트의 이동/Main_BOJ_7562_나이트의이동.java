package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7562_나이트의이동 {

	static int N;

	static class Node {
		int x;
		int y;
		int depth;

		public Node(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

	public static void BFS(int[] knight, int[] destination) {
		int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };

		boolean[][] visited = new boolean[N][N];

		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(knight[0], knight[1], 0));
		visited[knight[1]][knight[0]] = true;

		while (!q.isEmpty()) {
			Node top = q.poll();

			if (top.x == destination[0] && top.y == destination[1]) {
				System.out.println(top.depth);
				return;
			}

			for (int i = 0; i < 8; i++) {
				int nX = top.x + dx[i];
				int nY = top.y + dy[i];

				if (nX >= 0 && nY >= 0 && nX < N && nY < N) {
					if (!visited[nY][nX]) {
						visited[nY][nX] = true;
						q.add(new Node(nX, nY, top.depth + 1));
					}
				}
			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int[] knight = new int[2]; // 말의 위치

			for (int i = 0; i < 2; i++)
				knight[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			int[] destination = new int[2]; // 목적지의 위치

			for (int i = 0; i < 2; i++)
				destination[i] = Integer.parseInt(st.nextToken());

			BFS(knight, destination);
		}

	}

}
