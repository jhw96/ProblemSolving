package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_5014_스타트링크 {

	static int F; // 최대 층
	static int S, G; // 출발층, 도착층
	static int U, D; // 위로 올라가는 층 수, 아래로 내려가는 층 수
	static int answer = Integer.MAX_VALUE;
	static boolean[] visited;

	static class Node {
		int floor;
		int time;

		Node(int floor, int time) {
			this.floor = floor;
			this.time = time;
		}
	}

	private static void BFS() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(S, 0));
		visited[S] = true;

		while (!q.isEmpty()) {
			Node top = q.poll();
			int floor = top.floor;
			int time = top.time;

			if (floor == G) {
				answer = time;
				return;
			}

			if (floor + U <= F && !visited[floor + U]) {
				visited[floor + U] = true;
				q.add(new Node(floor + U, time + 1));
			}

			if (floor - D >= 1 && !visited[floor - D]) {
				visited[floor - D] = true;
				q.add(new Node(floor - D, time + 1));
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		visited = new boolean[F + 1];
		
		BFS();
		if(answer==Integer.MAX_VALUE) {
			System.out.println("use the stairs");
		} else {
			System.out.println(answer);
		}

		br.close();
	}

}
