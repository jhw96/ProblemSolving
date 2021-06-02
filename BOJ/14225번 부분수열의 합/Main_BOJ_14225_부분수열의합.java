package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14225_부분수열의합 {

	static boolean[] num = new boolean[2000001];

	public static void subset(int[] arr, boolean[] used, int step, int N) { // 배열로 부분집합 만들기
		if (step == N) {

			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (used[i])
					sum += arr[i];
			}

			num[sum] = true;

			return;
		}

		used[step] = true;
		subset(arr, used, step + 1, N);

		used[step] = false;
		subset(arr, used, step + 1, N);

	} // subset end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		num[0] = true;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		subset(arr, new boolean[N], 0, N);
		
		for(int i=1; i<=2000000; i++) {
			if(!num[i]) {
				System.out.println(i);
				break;
			}
		}

		br.close();
	} // main end

} // class end
