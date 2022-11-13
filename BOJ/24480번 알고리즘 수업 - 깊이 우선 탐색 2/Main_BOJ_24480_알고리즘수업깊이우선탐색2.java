package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BOJ_24480_알고리즘수업깊이우선탐색2 {

	static int N, M, R; // 정점의 수, 간선의 수, 시작정점
	static int cnt;
	static int[] count;// 순서
	static boolean[] visited;
	static ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[100001];

	private static void DFS(int node) {
		
		visited[node] = true;
		count[node] = ++cnt;
		Collections.sort(graph[node], Collections.reverseOrder());

		for (int i = 0; i < graph[node].size(); i++) {
			int next = graph[node].get(i);
			if (!visited[next])
				DFS(next);
		}

	} // DFS end

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		count = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			graph[start].add(end);
			graph[end].add(start);
		}

		DFS(R);

		for (int i = 1; i <= N; i++)
			System.out.println(count[i]);

		br.close();
	}

}
