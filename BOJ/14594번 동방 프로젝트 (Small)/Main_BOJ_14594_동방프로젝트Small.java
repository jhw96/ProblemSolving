package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14594_동방프로젝트Small {

	static int N; // 동방의 개수
	static int[] rooms;

	private static void makeSet() { // 분리집합 초기화
		for (int i = 1; i <= N; i++)
			rooms[i] = i;
	} // makeSet end

	private static int find(int x) { // 루트 노드 찾기
		if (rooms[x] == x)
			return x;
		return rooms[x] = find(rooms[x]);
	} // find end

	private static void union(int x, int y) { // 두 개의 집합 합치기
		int rootX = find(x);
		int rootY = find(y);

		if (rootX == rootY)
			return;

		rooms[rootY] = rootX;

	} // union end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		rooms = new int[N + 1];

		makeSet();

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			for (int j = start; j <= end - 1; j++)
				union(j, j + 1);

		}

		int answer = 0;
		boolean[] visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++)
			find(i);
		
		for(int i=1; i<=N; i++) {
			if(!visited[rooms[i]]) {
				answer++;
				visited[rooms[i]] = true;
			}
		}

		System.out.println(answer);
		br.close();
	}

}
