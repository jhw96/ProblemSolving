package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_18126_너구리구구 {

	static int N; // 방의 개수
	static ArrayList<Node>[] graph;
	static boolean[] visited;
	static long answer;

	static class Node {
		int roomNo; // 방번호
		int dist; // 거리

		Node(int roomNo, int dist) {
			this.roomNo = roomNo;
			this.dist = dist;
		}
	} // Node end

	private static void DFS(int now, long dist) {
		if (dist > answer)
			answer = dist;

		for (int i = 0; i < graph[now].size(); i++) {
			int roomNo = graph[now].get(i).roomNo;
			int nowDist = graph[now].get(i).dist;

			if (!visited[roomNo]) {
				visited[roomNo] = true;
				DFS(roomNo, dist + nowDist);
			}
		}

	} // DFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		visited[1] = true;

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<Node>();

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			graph[to].add(new Node(from, dist));
			graph[from].add(new Node(to, dist));
		}

		DFS(1, 0);
		
		System.out.println(answer);

		br.close();
	} // main end

}
