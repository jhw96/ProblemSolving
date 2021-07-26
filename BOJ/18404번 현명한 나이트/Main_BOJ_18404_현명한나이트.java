package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_18404_현명한나이트 {

	static int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dy = { -1, 1, -2, 2, -2, 2, -1, 1 };

	static boolean[][] visited;
	static int[][] map;
	static int N, M; // 체스판 크기, 상대편 말 개수
	static int sX, sY;
	static int eX, eY;
	static ArrayList<Integer> answer = new ArrayList<Integer>();

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
		map[sY][sX] = 0;
		q.add(new Node(sX, sY, 0));
		visited[sY][sX] = true;

		while (!q.isEmpty()) {
			Node top = q.poll();
			int x = top.x;
			int y = top.y;
			int depth = top.depth;

			for (int i = 0; i < 8; i++) {
				int nX = x + dx[i];
				int nY = y + dy[i];
				if (nX >= 1 && nX <= N && nY >= 1 && nY <= N) {
					if (!visited[nY][nX]) {
						visited[nY][nX] = true;
						map[nY][nX] = depth + 1;
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

		st = new StringTokenizer(br.readLine(), " ");
		sY = Integer.parseInt(st.nextToken());
		sX = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1][N + 1];
		map = new int[N+1][N+1];
		
		BFS();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			eY = Integer.parseInt(st.nextToken());
			eX = Integer.parseInt(st.nextToken());
			answer.add(map[eY][eX]);
		}

		for (int i = 0; i < answer.size(); i++)
			System.out.print(answer.get(i) + " ");

		br.close();
	}

}
