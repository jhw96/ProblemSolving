package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_12101_123더하기2 {

	static int n, k;
	static int turn; // 몇번째인지 확인

	private static void DFS(int step, int sum, String process) {
		if (turn >= k)
			return;

		if (sum == n) {
			turn++;
			if (turn == k)
				for (int i = 0; i < process.length(); i++) {
					if (i != process.length() - 1)
						System.out.print(process.charAt(i) + "+");
					else
						System.out.print(process.charAt(i));
				}
		}

		for (int num = 1; num <= 3; num++) {
			if (sum + num <= n)
				DFS(step + 1, sum + num, process + num);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		DFS(0, 0, "");

		if (turn != k)
			System.out.println(-1);

		br.close();
	}

}
