package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_14226_이모티콘 {

	static int S;
	static boolean[] visited;

	static class Node {
		int now;
		int clip;
		int time;

		Node(int now, int clip, int time) {
			this.now = now;
			this.clip = clip;
			this.time = time;
		}

	}

	private static void BFS() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(1, 0, 0));
		visited[1] = true;

		while (!q.isEmpty()) {
			Node top = q.poll();
			int now = top.now;
			int clip = top.clip;
			int time = top.time;
			
			if(now==S) {
				System.out.println(time);
				return;
			}

			if (now - 1 >= 0 && !visited[now - 1]) {
				visited[now - 1] = true;
				q.add(new Node(now - 1, clip, time + 1));
			}

			if (now + clip <= 2 * S && !visited[now + clip]) {
				visited[now + clip] = true;
				q.add(new Node(now + clip, 0, time + 1));
			}

			q.add(new Node(now, clip + now, time + 1));

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		visited = new boolean[2 * S + 1];
		
		BFS();

		br.close();
	}

}
