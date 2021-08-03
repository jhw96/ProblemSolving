package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_18232_텔레포트정거장 {

	static int N, M; // 최대길이 , 텔레포트 연결정보 개수
	static boolean[] visited;
	static ArrayList<Integer>[] Teleport;
	static int S, E; // 시작점, 끝점

	static class Node {
		int where;
		int time;

		Node(int where, int time) {
			this.where = where;
			this.time = time;
		}
	}

	private static void BFS() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(S, 0));
		visited[S] = true;

		while (!q.isEmpty()) {
			Node top = q.poll();
			int where = top.where;
			int time = top.time;

			if (where == E) {
				System.out.println(time);
				return;
			}

			for (int i = 0; i < Teleport[where].size(); i++) {
				int next = Teleport[where].get(i);
				if (next <= N && next >= 1 && !visited[next]) {
					visited[next] = true;
					q.add(new Node(next, time + 1));
				}
			}

			{
				int next = where + 1;
				if (next <= N && !visited[next]) {
					visited[next] = true;
					q.add(new Node(next, time + 1));

				}
			}
			{
				int next = where - 1;
				if (next >= 1 && !visited[next]) {
					visited[next] = true;
					q.add(new Node(next, time + 1));

				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Teleport = (ArrayList<Integer>[]) new ArrayList[N + 1];

		for (int i = 1; i <= N; i++)
			Teleport[i] = new ArrayList<Integer>();
		visited = new boolean[N + 1];

		st = new StringTokenizer(br.readLine(), " ");
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			Teleport[start].add(end);
			Teleport[end].add(start);
		}

		BFS();

		br.close();
	}

}
