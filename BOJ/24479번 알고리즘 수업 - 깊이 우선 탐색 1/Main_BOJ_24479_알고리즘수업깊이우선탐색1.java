package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BOJ_24479_알고리즘수업깊이우선탐색1 {

	static int N, M, R; // 정점, 간선, 시작정점
	static int cnt = 1;
	static boolean[] visited = new boolean[100001];
	static int[] order = new int[100001];
	

	static ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[100001];

	public static void DFS(int next) {
		visited[next] = true;
		order[next] = cnt++;

		for (int i = 0; i < graph[next].size(); i++) {
			int nextNode = graph[next].get(i);
			
			if(!visited[nextNode]) {
				DFS(nextNode);
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
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			graph[start].add(end);
			graph[end].add(start);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
		
		DFS(R);
		
		for(int i=1; i<=N; i++)
			System.out.println(order[i]);

		br.close();
	}

}
