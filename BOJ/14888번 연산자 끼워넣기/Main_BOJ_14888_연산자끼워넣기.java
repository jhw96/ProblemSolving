package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14888_연산자끼워넣기 {

	static int max, min;

	public static void permutaition(int[] num, int[] count, int N, int cnt, int sum) {
		if (cnt == N) {
			if (sum > max) {
				max = sum;
			}
			if (sum < min) {
				min = sum;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (count[i] > 0) {
				count[i]--;
				if (i == 0) { // +
					permutaition(num, count, N, cnt + 1, sum + num[cnt]);
				} else if (i == 1) { // -
					permutaition(num, count, N, cnt + 1, sum - num[cnt]);
				} else if (i == 2) { // *
					permutaition(num, count, N, cnt + 1, sum * num[cnt]);
				} else { // /
					permutaition(num, count, N, cnt + 1, sum / num[cnt]);
				}
				count[i]++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) // 숫자 입력받기
			num[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		int[] count = new int[4];

		for (int i = 0; i < 4; i++) // 연산자 횟수 입력받기
			count[i] = Integer.parseInt(st.nextToken());


		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		permutaition(num, count, N, 1, num[0]);
		
		System.out.println(max);
		System.out.println(min);

		br.close();
	}

}
