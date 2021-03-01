package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10819_차이를최대로 {

	static int N, max;

	public static void perm(int[] nums, int[] res, boolean[] used, int cnt) {
		if (cnt == N) {

			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				sum += (int) Math.abs(res[i] - res[i + 1]);
			}

			if (sum > max)
				max = sum;

			return;
		}

		for (int i = 0; i < N; i++) {
			if (used[i] == false) {
				used[i] = true;
				res[cnt] = nums[i];
				perm(nums, res, used, cnt + 1);
				used[i] = false;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] numbers = new int[N];

		for (int i = 0; i < N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());

		max = 0;
		perm(numbers, new int[N], new boolean[N], 0);
		System.out.println(max);

		br.close();
	}

}
