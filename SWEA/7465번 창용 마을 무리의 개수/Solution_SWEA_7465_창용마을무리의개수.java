package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_7465_창용마을무리의개수 {

	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	private static void BFS(int who) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(who);
		visited[who] = true;

		while (!q.isEmpty()) {
			int top = q.poll();

			for (int i = 0; i < graph[top].size(); i++) {
				int next = graph[top].get(i);
				if (!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 사람의 수
			int M = Integer.parseInt(st.nextToken()); // 관계의 개수

			graph = (ArrayList<Integer>[]) new ArrayList[N + 1];
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

			int answer = 0;
			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					answer++;
					BFS(i);
				}
			}
			System.out.println("#" + tc + " " + answer);
		}

		br.close();
	}

}
