package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BOJ_15665_N과M11 {

	static int N, M; // N개의 수를 입력받고 M 길이의 수열을 만들어야함
	static int[] num;
	static Set<Integer> set = new HashSet<Integer>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	private static void DFS(int step, int[] res) throws Exception {
		if (step == M) {
			int sum = 0;
			for (int i = 0; i < step; i++) {
				sum += (res[i] * Math.pow(10, i + 1));
			}

			if (!set.contains(sum)) {
				set.add(sum);
				for (int i = 0; i < step; i++)
					bw.write(res[i] + " ");
				bw.write("\n");
			}
			return;
		}

		for (int i = 1; i <= N; i++) {
			res[step] = num[i];
			DFS(step + 1, res);
		}
	} // DFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		num = new int[N + 1];

		for (int i = 1; i <= N; i++)
			num[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(num);

		DFS(0, new int[M]);
		
		bw.flush();

		br.close();
		bw.close();
	}

}
