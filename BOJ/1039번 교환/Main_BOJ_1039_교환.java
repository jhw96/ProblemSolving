package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1039_교환 {

	static int max;
	static int length; // 입력받은 수의 자릿수
	static boolean[][] visited = new boolean[1000001][11];

	static class Node {
		int num;
		int k;

		public Node(int num, int k) {
			super();
			this.num = num;
			this.k = k;
		}

	}

	public static int swap(int idx, int idx2, int num) {
		StringBuilder sb = new StringBuilder(Integer.toString(num));
		
		char tmp = sb.charAt(idx);
		sb.setCharAt(idx, sb.charAt(idx2));
		sb.setCharAt(idx2, tmp);
		
		if(sb.charAt(0) == '0')
			return -1;

		return Integer.parseInt(sb.toString());
	}

	public static void BFS(int N, int K) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(N, K));

		while (!q.isEmpty()) {
			Node top = q.poll();
			if (max < top.num && top.k == 0) // K번 연산을 했을 때 최대값을 찾아야함
				max = top.num;

			if (top.k == 0) // 연산끝난 애들은 skip
				continue;

			for (int i = 0; i < length; i++) { // 숫자 자리별로 바꾸기
				for (int j = 0; j < length; j++) {
					if (i == j) // 같은 위치면 pass
						continue;

					int next = swap(i, j, top.num);

					if (next != -1 && !visited[next][top.k - 1]) { // 이번 연산에서 아직 나오지 않은 숫자면
						visited[next][top.k - 1] = true;
						q.add(new Node(next, top.k - 1)); // 연산하기
					}

				}
			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 원래 숫자
		int K = Integer.parseInt(st.nextToken()); // 자리 바꿀 수 있는 수

		length = Integer.toString(N).length();

		BFS(N, K);

		if (max != 0)
			System.out.println(max);
		else
			System.out.println(-1);

		br.close();
	}

}
