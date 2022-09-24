package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17129_윌리암슨수액빨이딱따구리가정보섬에올라온이유 {

	static int n, m; // 행 열
	static int sx, sy;// 시작위치
	static int answer; 

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static int[][] map;
	static boolean[][] visited;

	static class Node {
		int x;
		int y;
		int cnt;

		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static boolean BFS() {
		Queue<Node> q = new LinkedList<Node>();

		q.add(new Node(sx, sy, 0));
		visited[sy][sx] = true;
		
		while (!q.isEmpty()) {
			Node top = q.poll();

			int nowx = top.x;
			int nowy = top.y;
			int nowCnt = top.cnt;

			for (int i = 0; i < 4; i++) {
				int nx = nowx + dx[i];
				int ny = nowy + dy[i];
				int nCnt = nowCnt + 1;
				
				if (nx >= 1 && nx <= m && ny >= 1 && ny <= n) {
					if (!visited[ny][nx] && map[ny][nx] != 1) { // 방문한 곳이 아니고 장애물이 아니면
						visited[ny][nx] = true;
						
						if (map[ny][nx] != 0) { // 음식 발견하면
							answer = nCnt;
							return true;
						}

						q.add(new Node(nx, ny, nCnt));
					}
				}

			}

		}

		return false;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n + 1][m + 1];
		visited = new boolean[n + 1][m + 1];

		for (int y = 1; y <= n; y++) {
			String input = br.readLine();
			for (int x = 0; x < m; x++) {
				int num = input.charAt(x) - '0';

				map[y][x + 1] = num;

				if (num == 2) {
					sx = x+1;
					sy = y;
				}
			}
		}
		
		

		if (BFS()) {
			System.out.println("TAK");
			System.out.println(answer);
		} else
			System.out.println("NIE");

		br.close();
	}

}
