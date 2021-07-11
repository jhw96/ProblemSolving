package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1326_폴짝폴짝 {

	static int N; // 징검다리의 개수
	static int[] stone;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;
	static int a, b; // a : 시작 , b : 목적

	static class Node {
		int where;
		int cnt;

		Node(int where, int cnt) {
			this.where = where;
			this.cnt = cnt;
		}
	}

	private static void BFS() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(a, 0));
		visited[a] = true;

		while (!q.isEmpty()) {
			Node top = q.poll();
			int where = top.where;
			int cnt = top.cnt;

			if (cnt > answer)
				continue;

			if (where == b) {
				if (answer > cnt) {
					answer = cnt;
					continue;
				}
			}

			for (int i = 1; i <= 10000; i++) {
				int next = where + stone[where] * i;
				if (next <= N) {
					if (!visited[next]) {
						visited[next] = true;
						q.add(new Node(next, cnt + 1));
					}
				} else
					break;
			}

			for (int i = -1; i >= -10000; i--) {
				int next = where + stone[where] * i;
				if (next >= 1) {
					if (!visited[next]) {
						visited[next] = true;
						q.add(new Node(next, cnt + 1));
					}
				}
			}
		}

	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		stone = new int[N + 1];
		visited = new boolean[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= N; i++)
			stone[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		BFS();

		if (answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);

		br.close();
	}

}
