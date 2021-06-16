package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_12852_1로만들기2 {

	static boolean[] visited = new boolean[1000001];

	static class Node {
		int num;
		int depth;
		String process;

		Node(int num, int depth, String process) {
			this.num = num;
			this.depth = depth;
			this.process = process;
		}
	}

	private static void BFS(int N) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(N, 0, String.valueOf(N)));

		while (!q.isEmpty()) {
			Node top = q.poll();
			int num = top.num;
			int depth = top.depth;
			String process = top.process;

			if (num == 1) {
				System.out.println(depth);
				System.out.println(process);

				return;
			}

			if (num % 3 == 0 && !visited[num / 3]) {
				visited[num / 3] = true;
				q.add(new Node(num / 3, depth + 1, process + " " + String.valueOf(num / 3)));
			}
			if (num % 2 == 0 && !visited[num / 2]) {
				visited[num / 2] = true;
				q.add(new Node(num / 2, depth + 1, process + " " + String.valueOf(num / 2)));
			}
			if (!visited[num - 1]) {
				visited[num - 1] = true;
				q.add(new Node(num - 1, depth + 1, process + " " + String.valueOf(num - 1)));
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		BFS(N);

		br.close();
	}

}
