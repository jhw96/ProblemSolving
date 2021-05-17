package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_5567_결혼식 {

	static ArrayList<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[501]; // 친구 관계
	static int answer;
	static boolean[] visited = new boolean[501];
	static ArrayList<Integer> friends = new ArrayList<Integer>();

	public static void CountFriend() {
		visited[1] = true;

		for (int i = 0; i < graph[1].size(); i++) {
			int friend = graph[1].get(i);
			if (!visited[friend]) {
				System.out.println(friend);
				answer++;
				visited[friend] = true;
				friends.add(friend);
			}
		}

		for (int i = 0; i < friends.size(); i++) {
			int friend = friends.get(i);
			for (int j = 0; j < graph[friend].size(); j++) {
				int who = graph[friend].get(j);
				if (!visited[who]) {
					System.out.println(who);
					visited[who] = true;
					answer++;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 상근이의 동기 수
		int m = Integer.parseInt(br.readLine()); // 리스트의 수

		for (int i = 1; i <= n; i++)
			graph[i] = new ArrayList<Integer>();

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}

		CountFriend();
		System.out.println(answer);

		br.close();
	}

}
