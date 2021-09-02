/*
 * 토마토가 모두 익는 최소일을 구하는 문제
 * 최소경로를 찾는 문제이므로 BFS 적합
*/
package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7576_토마토 {

	static int M, N; // 가로칸, 세로칸
	static int[][] tomato;
	static boolean[][] visited;

	static ArrayList<int[]> startTomato = new ArrayList<int[]>(); // 처음에 썩은 토마토 담기

	static int answer;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class Node {
		int x;
		int y;
		int time;

		Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	} // class end

	private static void BFS() {
		Queue<Node> q = new LinkedList<Node>();

		for (int i = 0; i < startTomato.size(); i++) {
			int[] start = startTomato.get(i);
			int x = start[0];
			int y = start[1];
			q.add(new Node(x, y, 0));
			visited[y][x] = true;
		}

		while (!q.isEmpty()) {
			Node top = q.poll();
			int x = top.x;
			int y = top.y;
			int time = top.time;

			if (time > answer)
				answer = time;

			for (int dir = 0; dir < 4; dir++) {
				int nX = top.x + dx[dir];
				int nY = top.y + dy[dir];
				if (nX >= 1 && nX <= M && nY >= 1 && nY <= N) {
					if (!visited[nY][nX] && tomato[nY][nX] == 0) {
						q.add(new Node(nX, nY, time + 1));
						tomato[nY][nX] = 1;
						visited[nY][nX] = true;
					}
				}
			}
		}

	} // BFS end

	private static boolean check() {
		
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= M; x++) {
				if (tomato[y][x] == 0)
					return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		
		tomato = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= M; x++) {
				tomato[y][x] = Integer.parseInt(st.nextToken());
				if (tomato[y][x] == 1) { // 썩은 토마토 위치 체크하기
					startTomato.add(new int[] { x, y });
				}
			}
		}

		BFS();
		
		if(check())
			System.out.println(answer);
		else
			System.out.println(-1);
		
		br.close();
	}

}
