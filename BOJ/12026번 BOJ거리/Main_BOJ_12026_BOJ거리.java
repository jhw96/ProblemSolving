package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_12026_BOJ거리 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[] boj = new char[N];
		String input = br.readLine();
		int[] dp = new int[N]; // 해당 idx까지 가는데 필요한 최소 에너지 저장 배열

		for (int i = 0; i < N; i++)
			boj[i] = input.charAt(i);

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 0; i < N; i++) {
			if (i != 0 && dp[i] == Integer.MAX_VALUE) // 시작이 아닌데 0 이면 밟지 않은 곳
				continue;
			for (int j = i + 1; j < N; j++) {
				if (boj[i] == 'B') {
					if (boj[j] == 'O') {
						int diff = j - i;
						dp[j] = (int) Math.min(dp[j], dp[i] + Math.pow(diff, 2));
					}

				} else if (boj[i] == 'O') {
					if (boj[j] == 'J') {
						int diff = j - i;
						dp[j] = (int) Math.min(dp[j], dp[i] + Math.pow(diff, 2));
					}

				} else if (boj[i] == 'J') {
					if (boj[j] == 'B') {
						int diff = j - i;
						dp[j] = (int) Math.min(dp[j], dp[i] + Math.pow(diff, 2));
					}
				}

			}
		}
		if(dp[N-1] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[N-1]);

		br.close();
	}

}
