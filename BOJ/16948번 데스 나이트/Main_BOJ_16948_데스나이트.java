package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16948_데스나이트 {

	static int N;
	static boolean[][] visited;
	static int[] start = new int[2];
	static int[] end = new int[2];

	static int[] dx = { -2, -2, 0, 0, 2, 2 };
	static int[] dy = { -1, 1, -2, 2, -1, 1 };
	static boolean flag;

	static class Node {
		int x;
		int y;
		int depth;

		Node(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}

	private static void BFS() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(start[0], start[1], 0));

		while (!q.isEmpty()) {
			Node top = q.poll();

			int x = top.x;
			int y = top.y;
			int depth = top.depth;

			if (x == end[0] && y == end[1]) {
				flag = true;
				System.out.println(depth);
				return;
			}

			for (int i = 0; i < 6; i++) {
				int nX = x + dx[i];
				int nY = y + dy[i];
				if (nX >= 0 && nY >= 0 && nX < N && nY < N) {
					if (!visited[nY][nX]) {
						visited[nY][nX] = true;
						q.add(new Node(nX, nY, depth + 1));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		visited = new boolean[N][N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < 2; i++)
			start[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 2; i++)
			end[i] = Integer.parseInt(st.nextToken());

		BFS();

		if (!flag)
			System.out.println(-1);

		br.close();
	}

}
