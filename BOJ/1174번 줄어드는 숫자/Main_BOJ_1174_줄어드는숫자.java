package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_1174_줄어드는숫자 {

	static int N; // 몇번째 수 인지
	static int totalCnt = 0;

	static class Node {
		String num;
		int before;
		int cnt;

		Node(String num, int before, int cnt) {
			this.num = num;
			this.before = before;
			this.cnt = cnt;
		}
	}

	// 9876543210
	private static void BFS() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node("", 10, 0));
		while (!q.isEmpty()) {
			Node top = q.poll();
			String num = top.num;
			int before = top.before;
			int cnt = top.cnt;

			if (cnt == N) {
				System.out.println(num);
				return;
			}

			for (int i = 0; i < 10; i++) {
				if (before > i) {
					totalCnt++;
					q.add(new Node(num + i, i, totalCnt));
				}
			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		if (N > 1023)
			System.out.println(-1);
		else
			BFS();

		br.close();
	}

}
