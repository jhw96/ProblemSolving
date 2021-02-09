package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1182_부분수열의합 {

	private static int N, S, count = 0;
	private static int[] sequence;

	private static void subset(int cnt, int sum) {
		if (cnt == N) {
			if (sum == S) {
				count++;
			}
			return;
		}

		subset(cnt + 1, sum + sequence[cnt]);
		subset(cnt + 1, sum);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 수열 원소 개수
		S = Integer.parseInt(st.nextToken()); // 원하는 합
		sequence = new int[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			sequence[i] = Integer.parseInt(st.nextToken());

		subset(0, 0);
		
		if (S == 0) // 공집합 제외시켜주기
			count -= 1;
		
		System.out.println(count);

		br.close();

	} // main end
} // class end
