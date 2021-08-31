/*
 * 1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸
 * 1,1의 시작점에서 N,M의 도착지까지 도착하는데까지 최소 지나야하는 칸 수를 구하시오
 * 최소 칸 수를 구하면 되므로 BFS를 이용하면 간단
 */

package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2178_미로탐색 {

	static int N, M; // 세로길이, 가로길이
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static int[][] map; // 미로
	static boolean[][] visited;
	static int answer = 0;

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
		q.add(new Node(1, 1, 1)); // 시작 칸 개수 포함
		visited[1][1] = true;

		while (!q.isEmpty()) {
			Node top = q.poll();
			int x = top.x;
			int y = top.y;
			int time = top.time;

			if (x == M && y == N) { // 도착지에 도착하면
				answer = time;
				break;
			}

			for (int dir = 0; dir < 4; dir++) { // 가중치가 없는, 어느 방향이 더 중요한 것이 없으므로 순서에 상관없이
				int nX = x + dx[dir];
				int nY = y + dy[dir];
				if (nX >= 1 && nX <= M && nY >= 1 && nY <= N) {
					if (!visited[nY][nX] && map[nY][nX] == 1) {
						q.add(new Node(nX, nY, time + 1));
						visited[nY][nX] = true;
					}

				}
			}
		}

	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int y = 1; y <= N; y++) {
			String input = br.readLine();
			for (int x = 1; x <= M; x++)
				map[y][x] = input.charAt(x - 1) - '0';
		}

		BFS();

		System.out.println(answer);

		br.close();
	}

}
