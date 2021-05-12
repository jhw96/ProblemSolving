package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1963_소수경로 {

	static class Node {
		int num;
		int cnt;

		public Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	static boolean[] prime = new boolean[10000];
	static int answer;

	public static boolean isPrime(int n) {
		if (n == 1)
			return false;
		if (n % 2 == 0) {
			if (n == 2)
				return true;
			return false;
		}
		for (int i = 3; i < n; i++)
			if (n % i == 0)
				return false;

		return true;
	}

	public static void BFS(int from, int to) {
		boolean[] visited = new boolean[10000];

		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(from, 0));
		visited[from] = true;

		while (!q.isEmpty()) {
			Node top = q.poll();

			if (top.num == to) {
				answer = top.cnt;
				return;
			}

			for (int idx = 0; idx < 4; idx++) { // 0번째 자리부터 3번째 자리수까지 체크
				for (int num = 0; num <= 9; num++) {
					if (idx == 0 && num == 0) // 맨 앞자리는 0 불가능
						continue;
					StringBuilder sb = new StringBuilder();
					sb.append(top.num);
					int tmp = change(sb, idx, num);
//					System.out.println(tmp);
					if (prime[tmp] && !visited[tmp]) {

						visited[tmp] = true;
						q.add(new Node(tmp, top.cnt + 1));

					}
				}
			}

		}

	}

	private static int change(StringBuilder sb, int idx, int num) {
		sb.setCharAt(idx, Character.forDigit(num, 10));
		int result = Integer.parseInt(sb.toString());
		return result;
	}

	public static void main(String[] args) throws Exception {
//		StringBuilder sb = new StringBuilder();
//		sb.append(10);
//		System.out.println(Integer.parseInt(sb.toString()));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1000; i < 10000; i++) // 소수 계산하기
			prime[i] = isPrime(i);

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			answer = -1;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			BFS(from, to);

			if (answer == -1)
				System.out.println("Impossible");
			else
				System.out.println(answer);

		}

		br.close();
	}

}
