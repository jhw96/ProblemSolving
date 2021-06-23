package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_15654_N과M5 {

	static int N, M;// N개 중에 M개 고른 수열
	static int[] arr;

	private static void DFS(int step, int[] res, boolean[] selected) {
		if (step == M) {
			for (int i = 0; i < M; i++)
				System.out.print(res[i] + " ");
			System.out.println();

			return;
		}

		for (int i = 0; i < N; i++) {
			if (!selected[i]) {
				selected[i] = true;
				res[step] = arr[i];
				DFS(step + 1, res, selected);
				selected[i] = false;
			}
		}
	} // DFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		DFS(0, new int[M], new boolean[N]);

		br.close();
	}

}
