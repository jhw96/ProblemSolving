package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_21317_징검다리건너기 {

	static int N, K; // 돌의 개수, 2개의 돌을 건너띄는데 쓰이는 에너지(1번 사용가능)
	static int[][] energy;
	static int answer = Integer.MAX_VALUE;

	private static void jump(int step, boolean used, int sum) {
		if (sum > answer)
			return;

		if (step == N) {
			if (sum < answer)
				answer = sum;
			return;
		}

		if (step + 1 <= N)
			jump(step + 1, used, sum + energy[step][0]);

		if (step + 2 <= N)
			jump(step + 2, used, sum + energy[step][1]);

		if (step + 3 <= N && !used) {
			jump(step + 3, true, sum + K);
		}
	} // jump end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		energy = new int[N][2];

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++)
				energy[i][j] = Integer.parseInt(st.nextToken());
		}
		
		K = Integer.parseInt(br.readLine());

		jump(1, false, 0);
		System.out.println(answer);

		br.close();
	} // main end

}
