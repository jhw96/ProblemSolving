package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_5972_택배배송 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int m = Integer.parseInt(st.nextToken()); // 간선의 개수

		ArrayList<int[]>[] graph = (ArrayList<int[]>[]) new ArrayList[N + 1]; // 가중치 그래프

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		int[] dist = new int[N + 1]; // 시작정점에서 해당 정점까지의 최소가중치
		boolean[] visited = new boolean[N + 1];
		int start = 1, end = N;

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[to].add(new int[] { from, weight });
			graph[from].add(new int[] { to, weight });
		}

		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		queue.add(new int[] { start, 0 }); // 시작점과 그 정점까지 가는데의 최소가중치 값

		while (!queue.isEmpty()) {

			// 최소 가중치인 간선 선택하기
			int[] top = queue.poll();
			int minIdx = top[0];
			int min = top[1];

			visited[minIdx] = true;

			for (int j = 0; j < graph[minIdx].size(); j++) {
				int next = graph[minIdx].get(j)[0];
				if (!visited[next] && dist[next] > dist[minIdx] + graph[minIdx].get(j)[1]) { 
					// 방문하지 않은 정점들 중 현재 정점을 경유해서 가는 곳이 더 빠르면
					dist[next] = dist[minIdx] + graph[minIdx].get(j)[1];
					queue.add(new int[] { next, dist[next] });
				}
			}

		}

		System.out.println(dist[N]);

		br.close();
	}

}
