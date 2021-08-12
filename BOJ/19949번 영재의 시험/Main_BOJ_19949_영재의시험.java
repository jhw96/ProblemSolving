package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_19949_영재의시험 {

	static int[] answers = new int[11];
	static int answer;

	private static void DFS(int sum, int step, int before, int conti) {
		if (step == 11) {
			if (sum >= 5)
				answer++;
			return;
		}

		for (int pick = 1; pick <= 5; pick++) {
			if (before == pick) { // 이전 답과 같은 경우
				if (conti < 2) { // 아니라면
					if (answers[step] == pick)
						DFS(sum + 1, step + 1, pick, conti + 1);
					else
						DFS(sum, step + 1, pick, conti + 1);
				} else { // 이미 2번 찍었다면
					continue;
				}

			} else { // 다른 경우
				if (answers[step] == pick)
					DFS(sum + 1, step + 1, pick, 1);
				else
					DFS(sum, step + 1, pick, 1);

			}
		}
	} // DFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= 10; i++)
			answers[i] = Integer.parseInt(st.nextToken());

		DFS(0, 1, 0, 0);

		System.out.println(answer);

		br.close();
	}

}
