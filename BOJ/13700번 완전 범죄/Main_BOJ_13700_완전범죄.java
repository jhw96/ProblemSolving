package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_13700_완전범죄 {

	static int N, S, D, F, B, K; // 총 건물의 수 , 출발지, 도착지, 앞으로 이동칸 수, 뒤로 이동칸 수, 경찰서 개수
	static boolean[] visited;
	static boolean answer = false;

	static class Node {
		int where;
		int cnt;

		Node(int where, int cnt) {
			this.where = where;
			this.cnt = cnt;
		}
	} // Node end

	private static void BFS() {
		Queue<Node> q = new LinkedList<Node>();

		q.add(new Node(S, 0));
		visited[S] = true;

		while (!q.isEmpty()) {
			Node top = q.poll();

			int where = top.where;
			int cnt = top.cnt;

			if (where == D) {
				System.out.println(cnt);
				answer = true;
				break;
			}

			int nF = where + F; // 앞방향 좌표
			int nB = where - B; // 뒷방향 좌표

			if (nF <= N && !visited[nF]) {
				visited[nF] = true;
				q.add(new Node(nF, cnt + 1));
			}

			if (nB >= 1 && !visited[nB]) {
				visited[nB] = true;
				q.add(new Node(nB, cnt + 1));
			}

		}
	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];

		if (K > 0) { // 경찰서 정보가 있는 경우
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < K; i++) // 경찰서 방문체크
				visited[Integer.parseInt(st.nextToken())] = true;
		}
		
		BFS();

		if (!answer)
			System.out.println("BUG FOUND");

		br.close();
	} // main end

}
