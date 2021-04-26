package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1965_상자넣기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] boxes = new int[n]; // 박스 크기 입력된 배열
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++)
			boxes[i] = Integer.parseInt(st.nextToken());

		int[] dp = new int[n]; // 현재 idx번째 박스안에 박스를 꼭 넣은 최적해
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (dp[i] == 0)
				dp[i] = 1;
			for (int j = 0; j <= i - 1; j++) {
				if (boxes[i] > boxes[j]) {// 현재 박스가 더 크면
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			if(max < dp[i])
				max = dp[i];
		}

		System.out.println(max);

		br.close();
	}

}
