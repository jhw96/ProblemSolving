package com.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_SWEA_8567_약수의개수가많은수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int[] count = new int[10001]; // 약수의 개수

		for (int i = 1; i <= 10000; i++) {
			for (int j = 1; j <= 10000 / i; j++) {
				count[i * j]++;
			}
		}

		int[] dp = new int[10001]; // 가장 큰 약수의 개수를 가진 수
		int max = 0, maxIdx = 0;
		for (int i = 1; i <= 10000; i++) {
			if (max <= count[i]) { // 여태까지 max보다 크거나 같으면
				max = count[i]; // 가장 많은 약수의 개수
				maxIdx = i; // 해당 약수의 개수를 가진 수
			}
			dp[i] = maxIdx;
		}
		System.out.println(dp[10000]);
		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder().append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N] + "\n");
			bw.write(sb.toString());
			bw.flush();
		}

		bw.close();
		br.close();
	}

}
