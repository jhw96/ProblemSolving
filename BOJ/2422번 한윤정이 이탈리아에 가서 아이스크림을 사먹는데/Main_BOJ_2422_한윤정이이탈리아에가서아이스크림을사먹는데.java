package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2422_한윤정이이탈리아에가서아이스크림을사먹는데 {

	static int N, M; // 아이스크림의 개수, 섞어먹으면 안되는 조합 개수

	static boolean[][] visited;
	static int answer = 0;

	private static void DFS(int value, int depth, int[] selected) {
		if (depth == 3) {
			if (visited[selected[0]][selected[1]] || visited[selected[1]][selected[2]]
					|| visited[selected[0]][selected[2]]) {// 섞이면 안되는 조합이 있는 경우
				return;
			}
			answer++;
			return;
		}

		if (value <= N) {
			selected[depth] = value;
			DFS(value + 1, depth + 1, selected); // 아이스크림 선택 O
			DFS(value + 1, depth, selected); // 아이스크림 선택 X
		}

	} // DFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());

			visited[to][from] = true;
			visited[from][to] = true;
			// 섞어먹으면 안되는 조합, 방문 표시
		}

		DFS(1, 0, new int[3]);

		System.out.println(answer);

		br.close();
	}

}
