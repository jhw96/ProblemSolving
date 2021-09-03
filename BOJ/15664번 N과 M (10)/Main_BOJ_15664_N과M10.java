/*
 * 주어진 수열로 비내림차순 수열을 만드는 문제
 * 백트래킹으로 조건에 만족하는 경우에 쭉 가기
 */

package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BOJ_15664_N과M10 {

	static int N, M; // N개의 주어지는 수열, M개의 수열만들어야함
	static int[] arr;
	static Set<String> set = new HashSet<String>();

	private static void DFS(int step,int before, boolean[] used, String res) {
		if (step == M) {
			if (!set.contains(res)) {
				set.add(res);
				System.out.println(res);
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!used[i] && before<=arr[i]) {
				used[i] = true;
				if (step != 0)
					DFS(step + 1, arr[i], used, res + " " + arr[i]);
				else
					DFS(step + 1,arr[i], used, res + arr[i]);
				used[i] = false;
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
		DFS(0, 0, new boolean[N], "");

		br.close();
	} // main end

}
