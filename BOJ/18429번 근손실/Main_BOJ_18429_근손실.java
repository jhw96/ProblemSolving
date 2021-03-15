package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_18429_근손실 {

	static int count = 0;

	public static void findRoute(int[] muscle, boolean[] used, int lose, int cnt, int N, int sum) {
		if (cnt == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (used[i] == false) {
				if (sum + muscle[i] - lose >= 500) { // 득근과 근손실을 했을때 500 이상 유지되면
					used[i] = true;
					findRoute(muscle, used, lose, cnt + 1, N, sum + muscle[i] - lose);
					used[i] = false;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // N일 동안 , N개의 운동키트
		int K = Integer.parseInt(st.nextToken()); // 일일 근손실량

		int[] muscle = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			muscle[i] = Integer.parseInt(st.nextToken());

		findRoute(muscle, new boolean[N], K, 0, N, 500);
		
		System.out.println(count);
		br.close();
	}

}
