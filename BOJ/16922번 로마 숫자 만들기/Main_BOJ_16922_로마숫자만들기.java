package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_BOJ_16922_로마숫자만들기 {

	static int N;
	static int answer;
	static int[] RomaNum = new int[] {1,5,10,50};
	static Set<Integer> set = new HashSet<Integer>();

	private static void combi(int start, int sum, int step) {
		if (step == N) {
			if (!set.contains(sum)) {
				set.add(sum);
				answer++;
			}

			return;
		}

		for (int i = start; i < 4; i++) {
			combi(i, sum + RomaNum[i], step + 1);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		combi(0, 0, 0);
		
		System.out.println(answer);

		br.close();
	}

}
