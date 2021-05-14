package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_BOJ_16964_DFS스페셜저지 {

	static ArrayList<Integer>[] graph; // 양방향 그래프
	static boolean[] visited;
	static int[] check; // 확인해야할 DFS 방문 순서
	static int cnt = 1;
	static int N;

	public static void DFS(int node) {
		if (cnt <= N) {

			HashSet<Integer> set = new HashSet<Integer>(); // 현재 노드의 다음 노드들
			for (int i = 0; i < graph[node].size(); i++) {
				set.add(graph[node].get(i));
			}

			for (int i = 0; i < graph[node].size(); i++) {
				if (cnt <= N) {
					if (set.contains(check[cnt]) && !visited[check[cnt]]) { // 다음 방문 노드를 가지고 있고
						visited[check[cnt]] = true;
						DFS(check[cnt++]);
					}
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		graph = (ArrayList<Integer>[]) new ArrayList[N + 1];
		visited = new boolean[N + 1];
		check = new int[N + 1];

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<Integer>();

		StringTokenizer st = null;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());

			graph[parent].add(child);
			graph[child].add(parent);
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++)
			check[i] = Integer.parseInt(st.nextToken());

		if (check[1] == 1) {// 시작노드가 루트노드
			cnt++;
			visited[1] = true;
			DFS(1);
		}

		if (cnt == N + 1)
			System.out.println(1);
		else
			System.out.println(0);

		br.close();
	}

}
