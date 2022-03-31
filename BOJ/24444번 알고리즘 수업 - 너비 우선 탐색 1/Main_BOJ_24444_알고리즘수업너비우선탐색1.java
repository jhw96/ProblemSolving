package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_24444_알고리즘수업너비우선탐색1 {

	static int N, M, R; // 정점의 수, 간선의 수, 시작 정점
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int[] order; // 방문순서

	private static void BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		int cnt = 0;

		q.add(R);
		order[R] = ++cnt;
		visited[R] = true;

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

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		order = new int[N + 1];
		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<Integer>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());

			graph[to].add(from);
			graph[from].add(to);
		}

		for (int i = 1; i <= N; i++)
			Collections.sort(graph[i]);

		BFS();
		
		for(int i=1; i<=N; i++)
			System.out.println(order[i]);

		br.close();
	}

}
