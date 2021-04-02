package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_10974_모든순열 {

	public static void subset(int[] res, int N, int cnt, boolean[] used) {
		if (cnt == N) {
			for(int i=0; i<cnt; i++)
				System.out.print(res[i] + " ");
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (used[i-1] == false) {
				used[i-1] = true;
				res[cnt] = i;
				subset(res, N, cnt + 1, used);
				used[i-1] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		subset(new int[N],N,0,new boolean[N]);
		br.close();
	}

}
