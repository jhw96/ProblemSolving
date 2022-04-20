package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2548_대표자연수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N]; // 숫자들
		int[] res = new int[N]; // 차이값

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) { // 차이값 계산하기
			for (int j = 0; j < N; j++) {
				if (i == j)
					continue;
				res[i] += Math.abs(num[i] - num[j]);
			}
		}

		int min = res[0];
		int idx = 0;


		for (int i = 1; i < N; i++) {
			if (min >= res[i]) {
				if (min == res[i]) {	// 차이값이 같은 경우
					if (num[idx] > num[i]) {
						min = res[i];
						idx = i;
					}
				} else {	// 차이값이 다른 경우
					min = res[i];
					idx = i;
				}
			}
		}

		System.out.println(num[idx]);

		br.close();
	}

}
