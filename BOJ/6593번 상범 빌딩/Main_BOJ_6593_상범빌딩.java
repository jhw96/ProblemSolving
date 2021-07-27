package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_6593_상범빌딩 {

	static int L, R, C; // L : 빌딩의 층 수, R : 세로, C : 가로
	static char[][][] building;
	static boolean[][][] visited;
	static int sH, sX, sY;
	static boolean flag;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	static int[] dh = { -1, 1 };

	static class Node {
		int height;
		int x;
		int y;
		int time;

		Node(int height, int x, int y, int time) {
			this.height = height;
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	private static void BFS() {
		Queue<Node> q = new LinkedList<Node>();
		visited[sH][sY][sX] = true;
		q.add(new Node(sH, sX, sY, 0));

		while (!q.isEmpty()) {
			Node top = q.poll();
			int height = top.height;
			int x = top.x;
			int y = top.y;
			int time = top.time;
			
			if(building[height][y][x] == 'E') {
				flag = true;
				System.out.println("Escaped in "+time+" minute(s).");
				return;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nX = top.x + dx[dir];
				int nY = top.y + dy[dir];
				if (nX >= 1 && nX <= C && nY >= 1 && nY <= R) {
					if (!visited[height][nY][nX] && building[height][nY][nX] != '#') {
						visited[height][nY][nX] = true;
						q.add(new Node(height, nX, nY, time + 1));
					}
				}
			}

			for (int dir = 0; dir < 2; dir++) {
				int nH = height + dh[dir];
				if (nH >= 1 && nH <= L && building[nH][y][x] != '#') {
					if (!visited[nH][y][x]) {
						visited[nH][y][x] = true;
						q.add(new Node(nH, x, y, time + 1));
					}
				}
			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0)
				break;

			building = new char[L + 1][R + 1][C + 1];
			visited = new boolean[L + 1][R + 1][C + 1];
			flag = false;

			for (int i = 1; i <= L; i++) {
				for (int y = 1; y <= R; y++) {
					String input = br.readLine();
					for (int x = 1; x <= C; x++) {
						building[i][y][x] = input.charAt(x - 1);
						if (building[i][y][x] == 'S') {
							sH = i;
							sX = x;
							sY = y;
						}
					}
				}
				br.readLine();
			}

			BFS();
			
			if(!flag)
				System.out.println("Trapped!");

		} // while end

		br.close();
	} // main end

}
