package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16439_치킨치킨치킨 {

	static int N, M; // 고리 회원 수, 치킨 종류 수
	static int[][] score; // 치킨 선호도 점수
	static int[] picked; // 고른 치킨
	static int answer; // 최대값

	private static void combi(int start, int step, int[] res) { // 치킨 세가지 고르기
		if (step == 3) {

			int sum = 0;
			for (int i = 1; i <= N; i++) {
				int max = 0;
				for (int j = 0; j < 3; j++) {
					int chickenNum = res[j];
					max = Math.max(max, score[i][chickenNum]);
				}
				picked[i] = max;
			}

			for (int i = 1; i <= N; i++)
				sum += picked[i];

			answer = Math.max(answer, sum);

			return;
		}
		for (int i = start; i <= M; i++) {
			res[step] = i;
			combi(i + 1, step + 1, res);
		}

	} // combi end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		score = new int[N + 1][M + 1];
		picked = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++)
				score[i][j] = Integer.parseInt(st.nextToken());
		}

		combi(1, 0, new int[3]);
		System.out.println(answer);

		br.close();
	}

}
