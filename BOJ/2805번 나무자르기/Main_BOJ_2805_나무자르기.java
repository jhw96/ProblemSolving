package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2805_나무자르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		long[] trees = new long[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(trees);

		long left = 0, right = trees[N - 1], result = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			for (int i = 0; i < N; i++) {
				if (trees[i] > mid)
					sum += (trees[i] - mid);
			}

			if (sum >= M) { // 실제 자른 나무들이 잘라야할 나무보다 많다면
				left = mid + 1;
				result = mid;
			} else if (sum < M) {
				right = mid - 1;
			}
		}
		
		System.out.println(result);

		br.close();
	}

}
