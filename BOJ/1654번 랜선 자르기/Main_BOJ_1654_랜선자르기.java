/*
 * 이미 가지고 있는 랜선 K개, 필요한 랜선의 개수 N개를 입력받는다.
 * k개의 랜선을 자르면서 N개를 만들어야함
 * 잘라야할 길이를 이분탐색으로 찾아가보자 (파라메트릭 서치) 
 * p.s. 데이터 범위 확인 좀 잘하자!! 맨날 int형 범위 넘어가서 틀린다.
 */

package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1654_랜선자르기 {

	static int K, N; // 가지고 있는 랜선 수, 필요한 랜선의 수
	static int[] lengths; // 랜선들의 길이

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		lengths = new int[K + 1];

		long left = 1, right = 0;

		for (int i = 1; i <= K; i++) {
			lengths[i] = Integer.parseInt(br.readLine());
			if (right < lengths[i])
				right = lengths[i];
		}

		long result = K;
		long answer = 0;

		while (left <= right) {
			long mid = (left + right) / 2; // 현재 자를 랜선의 길이

			result = 0; // mid로 잘라서 나온 랜선의 개수

			for (int i = 1; i <= K; i++) {
				result += (lengths[i] / mid);
			}

			if (result < N) // 결과로 나온 랜선 개수가 적으면
				right = mid - 1;
			else if (N <= result) { // 결과로 나온 랜선 개수가 많으면
				answer = mid;
				left = mid + 1;
			}

		}
		System.out.println(answer);

		br.close();
	}

}
