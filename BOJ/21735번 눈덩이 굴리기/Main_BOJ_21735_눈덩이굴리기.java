package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_21735_눈덩이굴리기 {

	static int N, M; // 앞마당의 길이, 대회의 기간
	static int[] snow;
	static int max;

	private static void DFS(int step, int sum, int time) {
		if (time == M) {
			if(max < sum)
				max = sum;
			return;
		}
		
		if(max < sum)
			max = sum;
		

		if (step + 1 <= N) {
			DFS(step + 1, sum + snow[step + 1], time + 1);
		}
		if (step + 2 <= N) {
			DFS(step + 2, sum / 2 + snow[step + 2], time + 1);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		snow = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= N; i++)
			snow[i] = Integer.parseInt(st.nextToken());

		DFS(0, 1, 0);
		System.out.println(max);
		br.close();
	}

}
