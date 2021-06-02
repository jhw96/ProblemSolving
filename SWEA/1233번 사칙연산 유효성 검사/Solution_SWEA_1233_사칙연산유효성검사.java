package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1233_사칙연산유효성검사 {

	static class Node {
		char data; // 정점이 가지고 있는 데이터
		int left;
		int right;

		public Node(char data) {
			this.data = data;
			this.left = 0;
			this.right = 0;
		}

		public Node(char data, int left) {
			this.data = data;
			this.left = left;
		}

		public Node(char data, int left, int right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}

	static boolean flag;
	static Node[] graph = new Node[201];

	private static void BFS() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(graph[1]);

		while (!q.isEmpty()) {
			Node top = q.poll();

			if (top.left != 0) { // 단일노드가 아니면
				if (graph[top.left].left == 0 || graph[top.right].left == 0) {
					if (top.data >= '1' && top.data <= '9') { // 자식이 단일노드인데 본인이 숫자면 실패
						flag = false;
						break;
					}
				}

				q.add(graph[top.left]);
				q.add(graph[top.right]);

			} else { // 단일노드라면
				if (top.data >= '1' && top.data <= '9') { // 숫자라면 pass
					continue;
				} else { // 연산자면 실패
					flag = false;
					break;
				}
			}

		}

	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine()); // 정점의 개수

			flag = true;

			for (int n = 1; n <= N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");

				int num = Integer.parseInt(st.nextToken());
				char data = st.nextToken().charAt(0);

				if (st.hasMoreTokens()) {
					int left = Integer.parseInt(st.nextToken());

					if (st.hasMoreTokens()) {
						int right = Integer.parseInt(st.nextToken());
						graph[num] = new Node(data, left, right);

					} else {
						graph[num] = new Node(data, left);
					}
				} else {
					graph[num] = new Node(data);
				}
			}

			BFS();

			if (flag)
				System.out.println("#" + tc + " " + 1);
			else
				System.out.println("#" + tc + " " + 0);

		}

		br.close();
	}

}
