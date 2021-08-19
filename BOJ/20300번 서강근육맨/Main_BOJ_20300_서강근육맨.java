package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_20300_서강근육맨 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[] sonsil = new long[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= N; i++)
			sonsil[i] = Long.parseLong(st.nextToken());

		Arrays.sort(sonsil);
		long answer = 0;

		if (N % 2 == 0) { // 짝수개일 경우

			for (int i = 1; i <= N / 2; i++) {
				long sum = sonsil[i] + sonsil[N - (i - 1)];
				if (sum > answer)
					answer = sum;
			}

		} else { // 홀수개일 경우
			for (int i = 1; i <= N / 2; i++) {
				long sum = sonsil[i] + sonsil[N - i];
				if (sum > answer)
					answer = sum;
			}
			answer = answer < sonsil[N] ? sonsil[N] : answer;

		}

		System.out.println(answer);

		br.close();
	}

}
