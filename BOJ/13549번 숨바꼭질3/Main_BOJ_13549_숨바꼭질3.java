package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_13549_숨바꼭질3 {

	static int start, end;
	static boolean[] visited = new boolean[100001];

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
		q.add(new Node(start, 0));
		visited[start] = true;

		while (!q.isEmpty()) {
			Node top = q.poll();
			int where = top.where;
			int time = top.time;

			if (where == end) {
				System.out.println(time);
				return;
			}

			if (where * 2 <= 100000 && !visited[where * 2]) {
				visited[where * 2] = true;
				q.add(new Node(where * 2, time));
			}

			if (where - 1 >= 0 && !visited[where - 1]) {
				visited[where - 1] = true;
				q.add(new Node(where - 1, time + 1));
			}

			if (where + 1 <= 100000 && !visited[where + 1]) {
				visited[where + 1] = true;
				q.add(new Node(where + 1, time + 1));
			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		BFS();

		br.close();
	}

}
