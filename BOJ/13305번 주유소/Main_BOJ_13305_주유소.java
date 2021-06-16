package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_13305_주유소 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] distance = new int[N - 1];
		int[] cost = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N - 1; i++)
			distance[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			cost[i] = Integer.parseInt(st.nextToken());

		long sum = 0;
		int standard = cost[0];
		int sIdx = 0;
		for (int i = 1; i < N; i++) {
			if (standard > cost[i]) { // 앞에 도시보다 기름값이 싼 곳을 발견한다면
				long dist = 0;
				for (int s = sIdx; s < i; s++) { // 앞에 도시부터 여기까지 거리 계산하기
					dist += distance[s];
				}
				sum += (standard * dist);
				standard = cost[i];
				sIdx = i;
			}
		}
		if (sIdx != N - 1) {
			long dist = 0;
			for (int i = sIdx; i < N-1; i++) {
				dist += distance[i];
			}
			sum += (standard * dist);
		}

		System.out.println(sum);
		br.close();
	}

}
