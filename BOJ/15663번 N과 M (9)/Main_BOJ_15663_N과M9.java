package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BOJ_15663_N과M9 {

	static int N;
	static int M;
	static int[] nums;
	static Set<String> set = new HashSet<String>();

	private static void DFS(int step, boolean[] used, String process) {
		if (step == M) {
			if (!set.contains(process)) {
				set.add(process);
				System.out.println(process);
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (step == 0 && !used[i]) {
				used[i] = true;
				DFS(step + 1, used, process + nums[i]);
				used[i] = false;
			} else {
				if (!used[i]) {
					used[i] = true;
					DFS(step + 1, used, process + " " + nums[i]);
					used[i] = false;
				}
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

		DFS(0, new boolean[N], "");

		br.close();
	}

}
