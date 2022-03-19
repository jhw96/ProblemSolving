package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_7568_덩치 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] size = new int[N + 1][2]; // 0 : 몸무게, 1 : 키
		int[] rank = new int[N + 1]; // 덩치 순위

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			size[i][0] = Integer.parseInt(st.nextToken());
			size[i][1] = Integer.parseInt(st.nextToken());

			rank[i] = 1;
		}

		// 덩치 비교 시작
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;
				if (size[i][0] < size[j][0] && size[i][1] < size[j][1])	// 현재 대상보다 덩치가 더 큰 상대가 있는 경우 랭크 상승 
					rank[i]++;
			}
		}

		for (int i = 1; i <= N; i++)
			System.out.print(rank[i] + " ");

		br.close();
	}

}
