package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_24445_알고리즘수업너비우선탐색2 {

	static int N, M, R; // 정점의 수, 간선의 수, 시작정점
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	static int[] order; // 방문순서

	private static void BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		int cnt = 0;

		q.add(R);
		visited[R] = true;
		order[R] = ++cnt;

		while (!q.isEmpty()) {
			int top = q.poll();

			for (int i = 0; i < graph[top].size(); i++) {
				int next = graph[top].get(i);
				if (!visited[next]) {
					visited[next] = true;
					order[next] = ++cnt;
					q.add(next);
				}
			}

		}

	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		order = new int[N + 1];

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i], Collections.reverseOrder());
		}

		BFS();

		for (int i = 1; i <= N; i++)
			System.out.println(order[i]);

		br.close();
	} // main end

}
