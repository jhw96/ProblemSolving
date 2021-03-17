package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_11724_연결요소의개수 {

	static int count = 0;

	public static void BFS(LinkedList<Integer>[] vertex, boolean[] visited, int v, int N) {
		Queue<Integer> queue = new LinkedList<Integer>();
		count++;
		queue.add(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int top = queue.poll();
			
			int size = vertex[top].size();
			
			for(int i=0; i<size; i++) {
				int next = vertex[top].get(i);
				if(visited[next] == false) {
					visited[next] = true;
					queue.add(next);
				}
			}
			
			
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		LinkedList<Integer>[] vertex = new LinkedList[N + 1];
		boolean[] visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++)
			vertex[i] = new LinkedList<Integer>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			vertex[from].add(to);
			vertex[to].add(from);
		}

		for (int i = 1; i <= N; i++) {
			if(visited[i] == false)
				BFS(vertex, visited, i, N);
			
		}

		System.out.println(count);

	}

}
