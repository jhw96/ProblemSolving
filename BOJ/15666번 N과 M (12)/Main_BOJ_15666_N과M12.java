package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BOJ_15666_N과M12 {

	static int N, M; // N개의 수열, M개 뽑기
	static int[] arr;
	static Set<String> set = new HashSet<String>();

	private static void DFS(int step, int before, String process) {
		if (step == M + 1) {
			if (!set.contains(process)) {
				set.add(process);
				System.out.println(process);
			}

			return;
		}

		for (int i = 1; i <= N; i++) {
			if (arr[i] >= before) {
				if (step == 1)
					DFS(step + 1, arr[i], String.valueOf(arr[i]));
				else
					DFS(step + 1, arr[i], process + " " + arr[i]);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		DFS(1,0, "");

		br.close();
	}

}
