package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_12851_숨바꼭질2 {

	static int minTime = 0;
	static int minCnt = 0;
	static boolean[] visited = new boolean[100001];

	static class Node {
		int time;
		int where;

		Node(int time, int where) {
			this.time = time;
			this.where = where;
		}
	}

	public static void search(int N, int K) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0, N));
		boolean first = true;

		while (!q.isEmpty()) {
			Node top = q.poll();
			int nowTime = top.time;
			int nowWhere = top.where;
			visited[nowWhere] = true;

			if (first && nowWhere == K) { // 동생을 처음찾은 경우
				minTime = nowTime;
				minCnt++;
				first = false;
			} else if (!first && nowWhere == K && minTime == nowTime) { // 동생을 이미 찾은 경우
				minCnt++;
			}

			if (!first && nowTime >= minTime) {
				continue;
			}

			if (nowWhere - 1 >= 0 && !visited[nowWhere - 1]) {
				q.add(new Node(nowTime + 1, nowWhere - 1));
			}
			if (nowWhere + 1 <= 100000 && !visited[nowWhere + 1]) {
				q.add(new Node(nowTime + 1, nowWhere + 1));
			}
			if (2 * nowWhere <= 100000 && !visited[2 * nowWhere]) {
				q.add(new Node(nowTime + 1, 2 * nowWhere));
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
		int K = Integer.parseInt(st.nextToken()); // 동생의 위치

		// 1초 후에 x-1 또는 x+1, 2x로 이동 가능

		search(N, K);

		System.out.println(minTime);
		System.out.println(minCnt);

		br.close();
	}

}
