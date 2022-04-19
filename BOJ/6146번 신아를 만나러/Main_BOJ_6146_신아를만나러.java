package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_6146_신아를만나러 {

	static boolean[][] visited = new boolean[1001][1001];
	static int X, Y, N; // 목적지 좌표, 웅덩이 개수
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class Node {
		int x;
		int y;
		int cnt;

		Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	private static void BFS() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(500, 500, 0));

		while (!q.isEmpty()) {
			Node top = q.poll();

			int sX = top.x;
			int sY = top.y;
			int cnt = top.cnt;
			
			if(sX == X && sY == Y) {
				System.out.println(cnt);
				return;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nX = sX + dx[dir];
				int nY = sY + dy[dir];

				if (nX >= 0 && nX <= 1000 && nY >= 0 && nY <= 1000) {
					if (!visited[nY][nX]) {
						visited[nY][nX] = true;
						q.add(new Node(nX, nY, cnt + 1));
					}
				}

			}
		}

	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		X = Integer.parseInt(st.nextToken()) + 500;
		Y = Integer.parseInt(st.nextToken()) + 500;
		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) { // 웅덩이 위치 입력
			st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			visited[y + 500][x + 500] = true;
		}
		
		BFS();

		br.close();
	} // main end

}
