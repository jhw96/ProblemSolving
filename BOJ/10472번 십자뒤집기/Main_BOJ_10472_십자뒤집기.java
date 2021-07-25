package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main_BOJ_10472_십자뒤집기 {

	static Set<String> set;
	static String end;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class Node {
		String data;
		int depth;

		Node(String data, int depth) {
			this.data = data;
			this.depth = depth;
		}
	}

	private static void BFS() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node("", 0));
		set.add("");

		while (!q.isEmpty()) {
			Node top = q.poll();
			String data = top.data;
			int depth = top.depth;

			if (data.equals(end)) {
				System.out.println(depth);
				return;
			}
			char[][] map = new char[4][4];

			for (int i = 0; i < data.length(); i++) {
				int idx = data.charAt(i) - '0';

				int y = idx % 3 == 0 ? idx / 3 : idx / 3 + 1;
				int x = idx % 3 == 0 ? 3 : idx % 3;
				map[y][x] = '*';
			}

			for (int i = 1; i <= 9; i++) {
				char[][] clone = new char[4][4];

				for (int y = 1; y <= 3; y++)
					for (int x = 1; x <= 3; x++)
						clone[y][x] = map[y][x];

				int y = i % 3 == 0 ? i / 3 : i / 3 + 1;
				int x = i % 3 == 0 ? 3 : i % 3;

				if (clone[y][x] == '*') { // 버튼 한개 클릭
					clone[y][x] = '.';
				} else {
					clone[y][x] = '*';
				}

				for (int j = 0; j < 4; j++) { // 인접칸들 색 전환

					int nX = x + dx[j];
					int nY = y + dy[j];

					if (nX >= 1 && nX <= 3 && nY >= 1 && nY <= 3) {
						if (clone[nY][nX] == '*')
							clone[nY][nX] = '.';
						else
							clone[nY][nX] = '*';
					}
				}

				String tmp = "";
				for (int ny = 1; ny <= 3; ny++) {
					for (int nx = 1; nx <= 3; nx++) {
						if (clone[ny][nx] == '*')
							tmp += (nx + (ny - 1) * 3);
					}
				}

				if (!set.contains(tmp)) {
					set.add(tmp);
					q.add(new Node(tmp, depth + 1));
				}

			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			set = new HashSet<String>();
			end = "";

			for (int y = 1; y <= 3; y++) {
				String input = br.readLine();
				for (int x = 1; x <= 3; x++) {
					if (input.charAt(x - 1) == '*') {
						end += (x + (y - 1) * 3);
					}
				}
			}

			BFS();

		}

		br.close();
	}

}
