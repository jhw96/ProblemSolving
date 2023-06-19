package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2303_숫자게임 {

	static int[][] input = new int[1001][6];
	static boolean[][] visited = new boolean[1001][6];
	static int[] score = new int[1001]; // N번째 사람의 최대값 기록
	static int max = -1; // 최대값
	static int N;

	private static void countMax(int n, int idx, int sum) {
		if (idx == 3) { // 다 골랐으면 돌아가기
			int result = (sum %= 10);

			if (result > score[n]) // 최대값이면 값넣기
				score[n] = result;
			
			if (result > max)
				max = result;
			return;
		}

		for (int i = 0; i < 5; i++) {
			if (!visited[n][i]) { // 아직 고르지 않은 거면 고르기
				visited[n][i] = true;
				countMax(n, idx + 1, sum + input[n][i]);
				visited[n][i] = false;
			}

		}

	} // DFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			countMax(i, 0, 0);
		}

		int answer = 0;

		for (int i = 0; i < N; i++) {
			if (score[i] == max) // 같은 최대값이면 번호가 큰 사람이 이김
				answer = i + 1;
		}
		System.out.println(answer);

		br.close();
	} // main end

}
