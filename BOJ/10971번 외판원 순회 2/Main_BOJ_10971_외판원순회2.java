package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10971_외판원순회2 {

	static int N;
	static int[][] graph;
	static int answer;
	static boolean[] visited;

	private static void DFS(int start, int where, int sum, int step) {
		if (sum > answer)
			return;

		if (step == N) {
			if(where == start) {
				if(answer > sum)
					answer = sum;
			}
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && graph[where][i] != 0) {
				visited[i] = true;
				DFS(start, i, sum + graph[where][i], step + 1);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		graph = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++)
				graph[i][j] = Integer.parseInt(st.nextToken());
		}

		answer = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			DFS(i, i, 0, 0);
		}
		
		System.out.println(answer);

		br.close();
	}

}
