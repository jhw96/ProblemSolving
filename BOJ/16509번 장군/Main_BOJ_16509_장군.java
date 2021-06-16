package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16509_장군 {

	static int[] elephant = new int[2]; // 0 : y, 1 : x
	static int[] king = new int[2]; // 0 : y, 1 : x
	static boolean[][] visited = new boolean[10][9];
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

	private static boolean rangeCheck(int x, int y) {
		if (x < 0 || y < 0 || x > 8 || y > 9)
			return false;
		return true;
	}

	private static boolean meetKing(int x, int y) {
		if (x == king[1] && y == king[0])
			return true;
		return false;
	}

	private static void BFS() {
		// 상 하 좌 우
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(elephant[1], elephant[0], 0));
		visited[elephant[0]][elephant[1]] = true;

		while (!q.isEmpty()) {
			Node top = q.poll();
			int x = top.x;
			int y = top.y;
			int depth = top.depth;
			
			for (int dir = 0; dir < 4; dir++) {
				int nX = x + dx[dir];
				int nY = y + dy[dir];
				if (rangeCheck(nX, nY) && !meetKing(nX, nY)) { // 맵 범위 안이고 움직이는 중에 왕을 만나지 않았다면
					if (dir < 2) { // 상 하
						for (int i = 2; i <= 3; i++) {
							int tX = nX;
							int tY = nY;
							// 대각선으로 움직이기
							tX += (dx[dir] + dx[i]);
							tY += (dy[dir] + dy[i]);
							if (rangeCheck(tX, tY) && !meetKing(tX, tY)) {
								tX += (dx[dir] + dx[i]);
								tY += (dy[dir] + dy[i]);
								if (rangeCheck(tX, tY)) {
									if (!visited[tY][tX]) {
										if (meetKing(tX, tY)) { // 왕을 만나면
											System.out.println(depth + 1);
											flag = true;
											return;
										} else {
											visited[tY][tX] = true;
											q.add(new Node(tX, tY, depth + 1));
										}
									}
								}
							}

						}

					} else { // 좌 우

						for (int i = 0; i <= 1; i++) {
							int tX = nX;
							int tY = nY;
							// 대각선으로 움직이기
							tX += (dx[dir] + dx[i]);
							tY += (dy[dir] + dy[i]);
							if (rangeCheck(tX, tY) && !meetKing(tX, tY)) {
								tX += (dx[dir] + dx[i]);
								tY += (dy[dir] + dy[i]);
								if (rangeCheck(tX, tY)) {
									if (!visited[tY][tX]) {
										if (meetKing(tX, tY)) { // 왕을 만나면
											System.out.println(depth + 1);
											flag = true;
											return;
										} else {
											visited[tY][tX] = true;
											q.add(new Node(tX, tY, depth + 1));
										}
									}
								}
							}

						}

					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		elephant[0] = Integer.parseInt(st.nextToken());
		elephant[1] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		king[0] = Integer.parseInt(st.nextToken());
		king[1] = Integer.parseInt(st.nextToken());

		BFS();

		if (!flag)
			System.out.println(-1);

		br.close();
	}

}
