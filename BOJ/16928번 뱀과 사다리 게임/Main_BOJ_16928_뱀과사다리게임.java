package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_16928_뱀과사다리게임 {

	static int N, M; // 사다리의 수, 뱀의 수
	static int[] map = new int[101];
	static boolean[] visited = new boolean[101];

	static class Node {
		int where;
		int time;

		Node(int where, int time) {
			this.where = where;
			this.time = time;
		}
	}

	private static void BFS() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(1, 0));
		visited[1] = true;

		while (!q.isEmpty()) {
			Node top = q.poll();
			int where = top.where;
			int time = top.time;

			if (where == 100) {
				System.out.println(time);
				return;
			}

			for (int i = 1; i <= 6; i++) {
				int next = where + i;
				if (next <= 100 && !visited[next]) {
					visited[next] = true;
					if (map[next] != 0) { // 사다리나 뱀을 만나면
						visited[map[next]] = true;
						q.add(new Node(map[next], time + 1));
					} else
						q.add(new Node(next, time + 1));
				}
			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from] = to;
		}
		
		BFS();

		br.close();
	}

}
