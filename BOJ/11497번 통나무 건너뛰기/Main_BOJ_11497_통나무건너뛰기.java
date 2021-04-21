package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_11497_통나무건너뛰기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[] trees = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int[] setting = new int[N + 1]; // 통나무 세팅하기

			for (int i = 0; i < N; i++)
				trees[i] = Integer.parseInt(st.nextToken());

			Arrays.sort(trees);

			int left = 0, right = N - 1;

			for (int i = 0; i < N; i++) {
				if (i % 2 == 0) {
					setting[left++] = trees[i];
				} else {
					setting[right--] = trees[i];
				}
			}
			setting[N] = setting[0];

			int answer = 0;
			for (int i = 0; i < N; i++) {
				int diff = Math.abs(setting[i + 1] - setting[i]);
				if (diff > answer)
					answer = diff;
			}

			System.out.println(answer);

		}

		br.close();
	}

}
