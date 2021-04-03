package com.programmers;

import java.util.LinkedList;
import java.util.Queue;

class Pointer {
	int x;
	int y;
	int depth;

	public Pointer(int x, int y, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
	}

}

public class Solution_Programmers_게임맵최단거리 {

	static int answer = 0;

	public static void BFS(int[][] maps, int width, int height, boolean[][] visited) {
		// 상 하 좌 우
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		Queue<Pointer> q = new LinkedList<Pointer>();
		q.add(new Pointer(0, 0, 1));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Pointer top = q.poll();
			
			if (top.x == width - 1 && top.y == height - 1) { // 종점 도착하면
				answer = top.depth;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nX = top.x + dx[i];
				int nY = top.y + dy[i];

				if (nY >= 0 && nX >= 0 && nX < width && nY < height && !visited[nY][nX] && maps[nY][nX] == 1) {
					// 범위 안이고 되돌아가지 않으면
					visited[nY][nX] = true;
					q.add(new Pointer(nX, nY, top.depth + 1));
				}

			}

		}

		answer = -1;
		return;

	}

	public static void main(String[] args) {
		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 } };

		int height = maps.length;
		int width = maps[0].length;

		boolean[][] visited = new boolean[height][width];

		BFS(maps, width, height, visited);
		
		System.out.println(answer);

	}

}
