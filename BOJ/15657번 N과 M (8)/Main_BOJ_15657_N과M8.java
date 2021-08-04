package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_15657_N과M8 {

	static int N, M; // N : 전체 수의 개수 , M : 수열의 길이
	static int[] nums;

	private static void DFS(int step, int[] res) {
		if (step == M + 1) {
			for (int i = 1; i <= M; i++)
				System.out.print(res[i] + " ");
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (step != 1 && res[step - 1] <= nums[i]) {
				res[step] = nums[i];
				DFS(step + 1, res);
			} else if(step==1){
				res[step] = nums[i];
				DFS(step+1,res);
			}

		}
	} // DFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= N; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(nums);

		DFS(1, new int[M + 1]);
		br.close();
	}

}
