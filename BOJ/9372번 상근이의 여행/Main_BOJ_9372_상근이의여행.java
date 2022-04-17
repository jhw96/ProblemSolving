package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_9372_상근이의여행 {

	static int N, M, answer; // 국가의 수, 비행기 종류
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	private static void BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visited[1] = true;
		answer = 0;

		while (!q.isEmpty()) {
			int top = q.poll();

			for (int i = 0; i < graph[top].size(); i++) {
				int next = graph[top].get(i);

				if (!visited[next]) {
					answer++;
					visited[next] = true;
					q.add(next);
				}

			}

		}

	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

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

			BFS();
			System.out.println(answer);
		}

		br.close();
	} // main end

}
