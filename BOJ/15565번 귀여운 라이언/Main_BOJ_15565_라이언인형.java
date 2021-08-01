package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_15565_라이언인형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 라이언 인형 최소 개수

		int[] dolls = new int[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) // 라이언인형 1, 어피치인형 2
			dolls[i] = Integer.parseInt(st.nextToken());

		int left = 0, right = 0;

		int answer = Integer.MAX_VALUE;
		int size = 1;
		int cnt = dolls[0] == 1 ? 1 : 0;

		while (left <= right) {
			if (cnt < K) {
				right++;
				size++;
				if (right >= N)
					break;
				if (dolls[right] == 1)
					cnt++;
			} else {
				left++;
				size--;
				if (left > right)
					break;
				if (dolls[left - 1] == 1)
					cnt--;
			}

			if (cnt >= K && size < answer)
				answer = size;
		}

		if (answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);

		br.close();
	}

}
