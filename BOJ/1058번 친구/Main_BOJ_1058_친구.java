package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_1058_친구 {

	static int answer = 0;
	static int max = -1;
	static int N;

	static ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[51];
	static boolean[] visited = new boolean[51];

	private static void BFS(int now) {
		Queue<Node> q = new LinkedList<Node>();

		visited[now] = true;
		q.add(new Node(now, 0));

		while (!q.isEmpty()) {
			Node top = q.poll();

			int tNum = top.num;
			int tCnt = top.cnt;

			for (int i = 0; i < graph[tNum].size(); i++) {
				int next = graph[tNum].get(i);

				if (!visited[next] && tCnt < 2) { // 아직 세지 않았고 2-친구 이하인 경우에
					answer++;
					visited[next] = true;
					q.add(new Node(next, tCnt + 1));
				}
			}

		}

		
		if (answer > max)
			max = answer;

	} // BFS end

	static class Node {
		int num;
		int cnt;

		Node() {

		}

		Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= N; i++) { // N줄 입력받기

			String input = br.readLine();
			char[] tmp = input.toCharArray();

			for (int j = 1; j <= N; j++) {
				if (tmp[j - 1] == 'Y') {
					graph[i].add(j);
				}
			}

		}

		for (int i = 1; i <= N; i++) { // 모든 정점에서 출발하기
			answer = 0;
			visited = new boolean[N + 1];
			BFS(i);

		}

		System.out.println(max);

		br.close();
	} // main end

}
