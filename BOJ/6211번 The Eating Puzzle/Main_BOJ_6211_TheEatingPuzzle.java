package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_6211_TheEatingPuzzle {

	static int limit, N; // 최대 칼로리, 음식 갯수
	static int[] calories;
	static int answer;

	private static void DFS(int idx, int sum) {
		if (limit < sum)
			return;
		if (answer < sum)
			answer = sum;
		
		if(idx == N)
			return;

		DFS(idx + 1, sum + calories[idx]); // 현재 음식을 선택하거나
		DFS(idx + 1, sum); // 현재 음식을 선택하지 않거나

	} // DFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		limit = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		calories = new int[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			calories[i] = Integer.parseInt(st.nextToken());

		DFS(0, 0);

		System.out.println(answer);

		br.close();
	}

}
