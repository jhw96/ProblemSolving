package com.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Jungol_4189_장기2 {

	static int N, M; // 행의 수, 열의 수
	static int eX, eY; // 졸의 위치
	static boolean[][] visited;

	static int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

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

	private static void BFS(int sX, int sY) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(sX, sY, 0));
		visited[sY][sX] = true;

		while (!q.isEmpty()) {
			Node top = q.poll();
			int x = top.x;
			int y = top.y;
			int depth = top.depth;

			if (x == eX && y == eY) {
				System.out.println(depth);
				return;
			}
			for (int i = 0; i < 8; i++) {
				int nX = x + dx[i];
				int nY = y + dy[i];
				if (nX >= 1 && nX <= M && nY >= 1 && nY <= N) {
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
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1][M + 1];

		st = new StringTokenizer(br.readLine(), " ");

		int sY = Integer.parseInt(st.nextToken());
		int sX = Integer.parseInt(st.nextToken());
		eY = Integer.parseInt(st.nextToken());
		eX = Integer.parseInt(st.nextToken());
		
		BFS(sX, sY);
		
		br.close();
	}

}
