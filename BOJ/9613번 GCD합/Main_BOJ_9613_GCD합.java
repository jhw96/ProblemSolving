package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_9613_GCD합 {

	public static int GDC(int i, int j) {
		if (i < j) {
			int remainder = j % i;
			if (remainder == 0)
				return i;
			return GDC(i, remainder);

		} else {
			int remainder = i % j;
			if (remainder == 0)
				return j;

			return GDC(j, remainder);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];

			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			long answer = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					answer += GDC(arr[i], arr[j]);
				}
			}

			System.out.println(answer);

		}

		br.close();
	} // main end

} // class end
