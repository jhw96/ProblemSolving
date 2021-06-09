package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_2665_미로만들기 {

	static int N;
	static int[][] map;
	static boolean[][][] visited;
	static int min = Integer.MAX_VALUE;

	static class Node {
		int x;
		int y;
		int changeCnt; // 검은 방을 바꾼 횟수

		Node(int x, int y, int changeCnt) {
			this.x = x;
			this.y = y;
			this.changeCnt = changeCnt;
		}
	}

	private static void BFS() {
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(1, 1, 0));
		visited[0][1][1] = true;

		while (!q.isEmpty()) {
			Node top = q.poll();
			
			if(top.changeCnt > min)
				continue;

			if (top.x == N && top.y == N) {
				if (min > top.changeCnt) {
					min = top.changeCnt;
					continue;
				}
			}

			for (int i = 0; i < 4; i++) {
				int nX = top.x + dx[i];
				int nY = top.y + dy[i];
				if (nX >= 1 && nY >= 1 && nX <= N && nY <= N) {
					if (map[nY][nX] == 1) { // 흰 방
						if (!visited[top.changeCnt][nY][nX]) {
							visited[top.changeCnt][nY][nX] = true;
							q.add(new Node(nX, nY, top.changeCnt));
						}
					} else { // 검은 방
						if (!visited[top.changeCnt + 1][nY][nX]) {
							visited[top.changeCnt + 1][nY][nX] = true;
							q.add(new Node(nX, nY, top.changeCnt + 1));
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
		visited = new boolean[N*N+1][N + 1][N + 1];

		for (int y = 1; y <= N; y++) {
			String input = br.readLine();
			for (int x = 1; x <= N; x++)
				map[y][x] = input.charAt(x - 1) - '0';
		}

		BFS();

		System.out.println(min);

		br.close();
	}

}
