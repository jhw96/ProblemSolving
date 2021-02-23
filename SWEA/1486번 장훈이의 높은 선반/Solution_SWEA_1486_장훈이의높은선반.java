package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1486_장훈이의높은선반 {
	static int Jang, min;

	public static void subset(int cnt, int[] height, int sum, int N) {
		if (cnt == N) {
			if (Jang <= sum) {
				int result = sum - Jang;
				if (result < min)
					min = result;
			}
			return;
		}

		subset(cnt + 1, height, sum + height[cnt], N); // cnt번째 점원 선택
		subset(cnt + 1, height, sum, N); // cnt번째 점원 비선택

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder().append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");

			int N = Integer.parseInt(st.nextToken()); // 점원 수
			Jang = Integer.parseInt(st.nextToken()); // 장훈이 키
			min = 9999;

			st = new StringTokenizer(br.readLine(), " ");
			int[] height = new int[N]; // 점원들 키
			for (int i = 0; i < N; i++)
				height[i] = Integer.parseInt(st.nextToken());

			subset(0, height, 0, N);
			sb.append(min);
			System.out.println(sb);

		}

		br.close();
	}

}
