package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int num;
	int depth;

	public Node(int num, int depth) {
		super();
		this.num = num;
		this.depth = depth;
	}

}

public class Main_BOJ_1389_케빈베이컨의6단계법칙 {

	static int min = Integer.MAX_VALUE;
	static int answer = 0;

	public static void BFS(int[][] graph, int start, int N) {

		Queue<Node> q = new LinkedList<Node>();
		boolean[] visited = new boolean[N + 1];

		int kevin = 0;
		q.add(new Node(start, 0));
		visited[start] = true;

		while (!q.isEmpty()) {
			Node top = q.poll();
			kevin += top.depth;

			for (int i = 1; i <= N; i++) {
				if (graph[top.num][i] == 1 && !visited[i]) { // 아직 방문하지 않은 곳
					visited[i] = true;
					q.add(new Node(i, top.depth + 1));
				}
			}
		}

		if (kevin < min) {
			min = kevin;
			answer = start;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 유저의 수
		int M = Integer.parseInt(st.nextToken()); // 친구관계의 수

		int[][] graph = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A][B] = 1;
			graph[B][A] = 1;
		}

		for (int i = 1; i <= N; i++)
			BFS(graph, i, N);

		System.out.println(answer);

		br.close();
	}

}
