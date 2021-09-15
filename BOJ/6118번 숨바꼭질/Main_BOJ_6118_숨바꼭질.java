/*
 * 1의 출발지에서 가장 먼 거리의 위치를 찾고
 * 그 위치에 해당하는 노드들 중 가장 번호가 낮은 것과 거리가 같은 노드들 개수를 구하는 문제
 * BFS로 해결되는 문제
 */
package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_6118_숨바꼭질 {

	static int N, M; // 헛간의 개수, 헛간이 이어져있는 길
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	static int answer; // 제일 먼 거리
	static int barnNum; // 헛간번호
	static int barnCnt; // 헛간개수

	static class Node {
		int where;
		int move;

		Node(int where, int move) {
			this.where = where;
			this.move = move;
		}
	}

	private static void BFS() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(1, 0));
		visited[1] = true;

		while (!q.isEmpty()) {
			Node top = q.poll();
			int where = top.where;
			int move = top.move;

			if (move > answer) { // 출발지로부터 가장 먼 헛간 발견 시
				barnCnt = 1;
				answer = move;
				barnNum = where;
			} else if (move == answer) { // 현재 답과 같은 거리의 헛간 발견시
				barnCnt++;
				barnNum = Math.min(barnNum, where);
			}

			for (int i = 0; i < graph[where].size(); i++) {
				int next = graph[where].get(i);
				if (!visited[next]) {
					visited[next] = true;
					q.add(new Node(next, move + 1));
				}
			}

		}

	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = (ArrayList<Integer>[]) new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<Integer>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}

		BFS();

		System.out.println(barnNum + " " + answer + " " + barnCnt);

		br.close();
	}

}
