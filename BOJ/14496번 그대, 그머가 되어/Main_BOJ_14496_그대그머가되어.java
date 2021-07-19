package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_14496_그대그머가되어 {

	static int start, end, N;
	static boolean[] visited = new boolean[1001];
	static ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[1001];

	static class Node {
		int data;
		int time;

		Node(int data, int time) {
			this.data = data;
			this.time = time;
		}
	}

	private static void BFS() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(start, 0));
		visited[start] = true;

		while (!q.isEmpty()) {
			Node top = q.poll();
			int data = top.data;
			int time = top.time;

			if (data == end) {
				System.out.println(time);
				return;
			}

			for (int i = 0; i < graph[data].size(); i++) {
				int next = graph[data].get(i);
				if (!visited[next]) {
					visited[next] = true;
					q.add(new Node(next, time + 1));
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken()); // 전체 문자의 수
		int M = Integer.parseInt(st.nextToken()); // 치환가능한 문자쌍의 수
		
		for(int i=1; i<=N; i++)
			graph[i] = new ArrayList<Integer>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			graph[to].add(from);
			graph[from].add(to);
		}
		
		BFS();
		
		if(!visited[end])
			System.out.println(-1);

		br.close();
	}

}
