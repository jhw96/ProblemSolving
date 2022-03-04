package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_12761_돌다리 {

	static int A, B; // 이동할 수 있는 힘
	static int N, M; // 시작점, 끝점
	static boolean[] visited = new boolean[100001];

	static class Node {
		int where;
		int cnt;

		Node(int where, int cnt) {
			this.where = where;
			this.cnt = cnt;
		}
	} // Node end

	private static void BFS() {
		Queue<Node> q = new LinkedList<Node>();

		q.add(new Node(N, 0));
		visited[N] = true;

		while (true) {
			Node top = q.poll();

			int where = top.where;

			int cnt = top.cnt;

			if (where == M) { // 목적지 도착시
				System.out.println(cnt);
				break;
			}

			if (where + 1 < 100001 && !visited[where + 1]) {
				q.add(new Node(where + 1, cnt + 1));
				visited[where + 1] = true;
			}
			if (where - 1 > 0 && !visited[where - 1]) {
				q.add(new Node(where - 1, cnt + 1));
				visited[where - 1] = true;
			}
			if (where + A < 100001 && !visited[where + A]) {
				q.add(new Node(where + A, cnt + 1));
				visited[where + A] = true;
			}
			if (where + B < 100001 && !visited[where + B]) {
				q.add(new Node(where + B, cnt + 1));
				visited[where + B] = true;
			}
			if (where - A > 0 && !visited[where - A]) {
				q.add(new Node(where - A, cnt + 1));
				visited[where - A] = true;
			}
			if (where - B > 0 && !visited[where - B]) {
				q.add(new Node(where - B, cnt + 1));
				visited[where - B] = true;
			}
			if (where * A < 100001 && !visited[where * A]) {
				q.add(new Node(where * A, cnt + 1));
				visited[where * A] = true;
			}
			if (where * B < 100001 && !visited[where * B]) {
				q.add(new Node(where * B, cnt + 1));
				visited[where * B] = true;
			}

		}

	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		BFS();

	} // main end

}
