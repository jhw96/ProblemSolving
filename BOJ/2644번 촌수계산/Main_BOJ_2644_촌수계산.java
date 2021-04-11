package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2644_촌수계산 {

	static boolean flag = false;

	public static void DFS(int[][] graph, boolean[][] visited, int pre, int end, int cnt) {
		System.out.println("cnt : " + cnt + " 현재 : " + pre);
		if (pre == end) {
			System.out.println(cnt);
			flag = true;
			return;
		}

		for (int i = 0; i < graph[pre].length; i++) {
			if (graph[pre][i] == 1 && !visited[pre][i]) {
				visited[pre][i] = true;
				visited[i][pre] = true;
				DFS(graph, visited, i, end, cnt + 1);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 전체사람 수
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine()); // 가족관계 수

		int[][] graph = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			graph[parent][child] = 1;
			graph[child][parent] = 1;
		}

		DFS(graph, new boolean[n + 1][n + 1], start, end, 0);

		if (!flag)
			System.out.println(-1);

		br.close();
	}

}
