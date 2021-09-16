package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_15656_N과M7 {

	static int N, M; // N개의 수열, M개 뽑기
	static int[] arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static void DFS(int step, int[] res) throws Exception {
		if (step == M) {

			for (int i = 0; i < step; i++) {
				bw.write(res[i] + " ");
			}
			bw.write("\n");

			return;
		}

		for (int i = 0; i < N; i++) {
			res[step] = arr[i];
			DFS(step + 1, res);
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

		DFS(0, new int[M]);
		bw.flush();
		
		br.close();
		bw.close();
	}

}
