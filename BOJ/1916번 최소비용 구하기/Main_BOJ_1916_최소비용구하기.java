
package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1916_최소비용구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 도시 개수
		int M = Integer.parseInt(br.readLine()); // 버스 개수

		int[][] graph = new int[N + 1][N + 1]; // 가중치 방향 그래프
		boolean[] visited = new boolean[N + 1]; // 방문 여부 확인

		for (int[] arr : graph)
			Arrays.fill(arr, -1);

		StringTokenizer st = null;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if (graph[to][from] == -1)
				graph[to][from] = weight;

			else
				graph[to][from] = Math.min(graph[to][from], weight);
		}

		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken()); // 시작 정점
		int end = Integer.parseInt(st.nextToken()); // 끝 정점

		long[] cost = new long[N + 1]; // 시작정점에서 index 정점까지 가는데 드는 최소비용 저장한 배열

		for (int i = 0; i <= N; i++) {
			cost[i] = Integer.MAX_VALUE;
		}

		cost[start] = 0;

		long min = 0;
		int current = 0;
		for (int i = 0; i < N; i++) {
			min = Integer.MAX_VALUE;

			for (int v = 1; v <= N; v++) {
				if (visited[v] == false && min > cost[v]) {
					min = cost[v];
					current = v;
				}
			}

			visited[current] = true;

			for (int v = 1; v <= N; v++) {
				if (visited[v] == false && graph[current][v] != -1 && cost[current] != Integer.MAX_VALUE) { // 현재 정점에서 인접해있고 방문하지 않았으면
					cost[v] = Math.min(cost[v], cost[current] + graph[current][v]);
				}
			}

		}

		System.out.println(cost[end]);

		br.close();
	}

}
