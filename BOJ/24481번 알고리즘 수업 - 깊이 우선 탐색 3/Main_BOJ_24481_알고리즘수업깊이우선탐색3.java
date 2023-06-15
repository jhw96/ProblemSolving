package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BOJ_24481_알고리즘수업깊이우선탐색3 {

	static int N, M, R; // 정점, 간선, 시작정점
	static int cnt = 1;
	static boolean[] visited = new boolean[100001];
	static int[] order = new int[100001];

	static ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[100001];

	private static void DFS(int start, int cnt) {
		visited[start] = true;
		order[start] = cnt;

		for (int i = 0; i < graph[start].size(); i++) {
			int next = graph[start].get(i);
			if (!visited[next]) { // 방문하지 않은 노드라면
				DFS(next, cnt + 1);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<Integer>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			graph[start].add(end);
			graph[end].add(start);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
			order[i] = -1; // 방문순서 초기화
		}

		DFS(R, 0);

		for (int i = 1; i <= N; i++)
			System.out.println(order[i]);

	}

}
