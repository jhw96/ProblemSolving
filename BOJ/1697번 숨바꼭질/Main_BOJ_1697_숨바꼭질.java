package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1697_숨바꼭질 {

	static class Pointer {
		int num;
		int depth;

		public Pointer(int num, int depth) {
			this.num = num;
			this.depth = depth;
		}
	}

	public static void BFS(int N, int K) {

		Queue<Pointer> queue = new LinkedList<Pointer>();
		boolean[] visited = new boolean[100001];
		queue.add(new Pointer(N, 0));

		while (!queue.isEmpty()) {
			Pointer top = queue.poll();

			if (top.num == K) {
				System.out.println(top.depth);
				return;
			}

			if (top.num + 1 >= 0 && top.num + 1 <= 100000 && !visited[top.num + 1]) {
				queue.add(new Pointer(top.num + 1, top.depth + 1));
				visited[top.num + 1] = true;
			}
			if (top.num - 1 >= 0 && top.num - 1 <= 100000 && !visited[top.num - 1]) {
				queue.add(new Pointer(top.num - 1, top.depth + 1));
				visited[top.num - 1] = true;
			}
			if ((top.num * 2) >= 0 && (top.num * 2) <= 100000 && !visited[top.num * 2]) {
				queue.add(new Pointer(top.num * 2, top.depth + 1));
				visited[top.num * 2] = true;
			}
		} // while end

	} // BFS end

	// BFS로 풀어보자
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 선빈이 위치
		int K = Integer.parseInt(st.nextToken()); // 동생 위치

		BFS(N, K);

		br.close();
	} // main end

} // class end