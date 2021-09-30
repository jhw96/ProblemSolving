package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_15655_N과M6 {

	static int N, M; // N개의 자연수, M개를 고른 수열
	static int[] nums;

	private static void DFS(int before, int step, boolean[] used, int[] res) {
		if (step == M) {
			for(int i=0; i<M; i++)
				System.out.print(res[i] + " ");
			System.out.println();
				
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!used[i] && (before < nums[i])) { // 선택되지 않았고 더 큰 애라면
				res[step] = nums[i];
				used[i] = true;
				DFS(nums[i], step + 1, used, res);
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(nums);

		DFS(0, 0, new boolean[N], new int[M]);

		br.close();
	}

}
