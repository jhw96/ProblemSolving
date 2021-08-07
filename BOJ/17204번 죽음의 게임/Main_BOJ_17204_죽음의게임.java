package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17204_죽음의게임 {

	static int N, K; // 참여하는 사람 수, 보성이 번호
	static int[] appoint; // 지목하는 사람 번호
	static boolean[] visited;

	private static boolean BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		int answer = 0;
		q.add(0);
		visited[0] = true;

		while (!q.isEmpty()) {
			int top = q.poll();

			if (top == K) {
				System.out.println(answer);
				return true;
			}

			int next = appoint[top];
			if (!visited[next]) {
				q.add(next);
				visited[next] = true;
				answer++;
			}

		}

		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		appoint = new int[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++)
			appoint[i] = Integer.parseInt(br.readLine());

		if (!BFS())
			System.out.println(-1);

		br.close();
	}

}
