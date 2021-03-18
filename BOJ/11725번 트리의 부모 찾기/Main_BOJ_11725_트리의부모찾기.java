package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_11725_트리의부모찾기 {

	static int[] answers;

	public static void BFS(LinkedList<Integer>[] vertex, boolean[] visited, int N) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(1);
		visited[1] = true;

		while (!q.isEmpty()) {
			int top = q.poll();
			int size = vertex[top].size();

			for (int i = 0; i < size; i++) {
				int next = vertex[top].get(i);
				if (visited[next] == false) {
					answers[next] = top;
					visited[next] = true;
					q.add(next);
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		LinkedList<Integer>[] vertex = new LinkedList[N + 1];

		answers = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++)
			vertex[i] = new LinkedList<Integer>();

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			vertex[num1].add(num2);
			vertex[num2].add(num1);
		}
		
		BFS(vertex,visited,N);
		
		for(int i=2; i<=N; i++)
			System.out.println(answers[i]);

		br.close();
	}

}
