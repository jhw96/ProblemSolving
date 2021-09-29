/*
 * X번의 작업을 수행하기 위해 선행 작업의 개수를 구해야한다.
 * 그래프 탐색으로 X의 부모노드의 개수를 찾으면 된다.
*/
package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_21937_작업 {

	static int N, M;// 작업의 개수, 정보의 개수
	static int X; // 확인해야할 작업
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	static int answer = 0;

	private static void BFS(int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(num);
		visited[num] = true;

		while (!q.isEmpty()) {
			int top = q.poll();

			for (int i = 0; i < graph[top].size(); i++) {
				int next = graph[top].get(i);
				if (!visited[next]) {
					visited[next] = true;
					q.add(next);
					answer++;
				}
			}
		}

	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = (ArrayList<Integer>[]) new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) { // 단방향 그래프 ( 자식에서 부모 기억하기 )
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph[to].add(from);
		}

		X = Integer.parseInt(br.readLine());

		BFS(X);

		System.out.println(answer);
		
		br.close();
	}

}
