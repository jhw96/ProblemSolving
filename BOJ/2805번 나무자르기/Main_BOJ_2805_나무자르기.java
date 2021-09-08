
/*
 * N개의 나무를 일렬로 세우고 H길이의 절단기로 자른다.
 * H길이로 자르고 남은 나무들의 길이 합을 M으로 만들어야함
 * 파라메트릭 서치로 빠르게 찾자 <- 최대값 최소값 찾는 최적화 문제를 결정 문제로 바꾸는 것
 * 제발 데이터 범위 어제도 틀렸잖아 제발
 */

package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2805_나무자르기 {

	static int N, M; // 나무의 수, 가져가야하는 나무의 총 길이
	static long[] trees; // 나무의 길이

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		long left = 0, right = 0;
		trees = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if (trees[i] > right)
				right = trees[i]; // 가장 긴 나무의 길이
		}

		long answer = 0;
		while (left <= right) {
			long result = 0;
			long mid = (left + right) / 2; // 절단기의 길이 설정

			for (int i = 1; i <= N; i++) {
				long cutted = (trees[i] - mid) < 0 ? 0 : trees[i] - mid;
				result += cutted;
			}
			
			if (result < M) { // 자른 결과물이 생각보다 적은 경우
				right = mid - 1;
			} else if (M <= result) { // 자른 결과물이 생각보다 많거나 같은 경우
				answer = mid;
				left = mid + 1;
			}

		}

		System.out.println(answer);

		br.close();
	}

}
