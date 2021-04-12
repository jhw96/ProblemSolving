package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16198_에너지모으기 {

	static int answer = 0;

	public static void collect(int[] energy, int sum, int N, int cnt) {
		if (cnt == N - 2) {
			if (answer < sum)
				answer = sum;

			return;
		}

		for (int i = 1; i <= N - 2; i++) {
			if (energy[i] != -1) {
				int temp = energy[i];
				energy[i] = -1;
				int left = 0, right = 0;

				for (int j = i - 1; j >= 0; j--) { // 좌로 탐색
					if (energy[j] != -1) {
						left = energy[j];
						break;
					}
				}

				for (int j = i + 1; j <= N - 1; j++) { // 우로 탐색
					if (energy[j] != -1) {
						right = energy[j];
						break;
					}
				}
				collect(energy, sum + (left * right), N, cnt + 1);
				energy[i] = temp;
			}
		}

	} // collect end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] energy = new int[N]; // 구슬 에너지

		for (int i = 0; i < N; i++)
			energy[i] = Integer.parseInt(st.nextToken());
		
		collect(energy, 0, N, 0);
		System.out.println(answer);
		br.close();
	}

}
