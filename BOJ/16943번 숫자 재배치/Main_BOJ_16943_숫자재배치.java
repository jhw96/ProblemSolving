package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16943_숫자재배치 {

	static String A;
	static int B;
	static int max = -1;

	public static void permutation(char[] res, boolean[] selected, int step, int size) {
		if (step == size) {

			String tmp = "";
			for (int i = 0; i < size; i++)
				tmp += res[i];

			int change = Integer.parseInt(tmp);
			System.out.println(change);
			if (B >= change && max < change) {
				max = change;
			}
			return;
		}

		for (int i = 0; i < size; i++) {
			if (A.charAt(i) == '0' && step == 0) {
				continue;
			}
			if (!selected[i]) {
				selected[i] = true;
				res[step] = A.charAt(i);
				permutation(res, selected, step + 1, size);
				selected[i] = false;
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		A = st.nextToken();
		B = Integer.parseInt(st.nextToken());

		permutation(new char[A.length()], new boolean[A.length()], 0, A.length());
		System.out.println(max);
		br.close();
	}

}
