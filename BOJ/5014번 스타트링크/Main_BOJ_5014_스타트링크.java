package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_5014_스타트링크 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int F = Integer.parseInt(st.nextToken()); // 아파트 총 길이
		int S = Integer.parseInt(st.nextToken()); // 시작 층
		int G = Integer.parseInt(st.nextToken()); // 목표 층
		int U = Integer.parseInt(st.nextToken()); // 올라가는 높이
		int D = Integer.parseInt(st.nextToken()); // 내려가는 높이

		int[] dp = new int[F + 1]; // 해당 층으로 가는데 누르는 최소 버튼 수
		Arrays.fill(dp, 999999999);
		dp[S] = 0;

		for (int i = S; i >= 1; i -= D) { // G보다 아래층 채우기
			if (D == 0)
				break;
			if (i == S)
				continue;
			if (i - D >= 1) {
				dp[i] = Math.min(dp[i], dp[i + D] + 1); // d를 눌러서 내려가는 것과 비교
			}
			System.out.println("아래층 채우기");
		}

		for (int i = 1; i <= F; i++) {
			if (i + U <= F) { // U버튼 눌렀을 때 빌딩보다 높으면
				dp[i + U] = Math.min(dp[i + U], dp[i] + 1);
			}
			if (i - D >= 1) { // D버튼 눌렀을 때 빌딩보다 낮으면
				dp[i - D] = Math.min(dp[i - D], dp[i] + 1);
			}
		}
		for (int i = 1; i <= F; i++) {
			if (dp[i] == 999999999) {
				if (i - U >= 1) {
					dp[i] = Math.min(dp[i - U] + 1, dp[i]);
				}
				if (i + D <= F) {
					dp[i] = Math.min(dp[i], dp[i + D] + 1);
				}
			}
		}

		if(dp[G] == 999999999)
			System.out.println("use the stairs");
		else
			System.out.println(dp[G]);

		br.close();
	}

}
