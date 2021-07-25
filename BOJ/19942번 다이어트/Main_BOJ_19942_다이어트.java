package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_19942_다이어트 {

	static int N; // 식재료의 개수
	static int[] condition = new int[4]; // 영양성분 최소만족
	static int minCost = Integer.MAX_VALUE;
	static int[][] foods;
	static ArrayList<Integer> answer = new ArrayList<Integer>();

	private static void DFS(int step, boolean[] used, int[] process, int sumCost) {
		if (sumCost > minCost)
			return;

		if (step == N + 1) {

			for (int i = 0; i < 4; i++) {
				if (process[i] < condition[i])
					return;
			}

			if (minCost >= sumCost) {
				if (minCost != sumCost) {
					minCost = sumCost;
					answer.clear();
					for (int i = 1; i <= N; i++)
						if (used[i])
							answer.add(i);
				} else if (minCost == sumCost) {
					String now = "";
					for (int i = 1; i <= N; i++)
						if (used[i])
							now += i;

					String compare = "";
					for (int i = 0; i < answer.size(); i++)
						compare += answer.get(i);
					
					if(now.compareTo(compare) < 0) {
						answer.clear();
						for (int i = 1; i <= N; i++)
							if (used[i])
								answer.add(i);
					}
				}
			}

			return;
		}

		int[] cal = new int[4];
		for (int i = 0; i < 4; i++) {
			cal[i] = process[i] + foods[step][i];
		}
		used[step] = true;
		DFS(step + 1, used, cal, sumCost + foods[step][4]);

		used[step] = false;
		DFS(step + 1, used, process, sumCost);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		foods = new int[N + 1][5];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) // 최소조건 입력하기
			condition[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) { // 음식 조건 입력하기
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				foods[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		DFS(1, new boolean[N + 1], new int[4], 0);

		if (minCost != Integer.MAX_VALUE) {
			System.out.println(minCost);
			for (int i = 0; i < answer.size(); i++)
				System.out.print(answer.get(i) + " ");
		} else
			System.out.println(-1);

		br.close();
	}

}
