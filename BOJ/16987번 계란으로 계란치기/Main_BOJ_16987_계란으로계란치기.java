package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16987_계란으로계란치기 {

	static int N;
	static int[][] eggs;
	static int max;

	private static void destroyEgg(int step) {
		int cnt = 0;
		for (int i = 1; i <= N; i++)
			if (eggs[i][0] <= 0) // 깨진 계란이면
				cnt++;

		if (cnt > max)
			max = cnt;

		if (step <= N) {
			if (eggs[step][0] <= 0) { // 집은 계란이 깨진 계란이면 다음 계란 집기
				destroyEgg(step + 1);
			} else { // 집은 계란이 깨지지 않았다면

				for (int i = 1; i <= N; i++) {
					if (i == step) // 같은 계란이면
						continue;

					if (eggs[i][0] > 0) { // 깨지지 않은 계란이면 현재 가진 계란으로 쳐보기

						// 서로 부딫혀서 무게만큼 내구도 깎기
						eggs[step][0] -= eggs[i][1];
						eggs[i][0] -= eggs[step][1];

						destroyEgg(step + 1);

						// 원상복구
						eggs[step][0] += eggs[i][1];
						eggs[i][0] += eggs[step][1];

					}

				}
			}
		}

	} // destroyEgg end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 계란의 개수
		eggs = new int[N + 1][2]; // 내구도와 무게
		// 계란끼리 치면 서로의 내구도에서 무게만큼 뺀다

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			eggs[i][0] = Integer.parseInt(st.nextToken());
			eggs[i][1] = Integer.parseInt(st.nextToken());
		}

		destroyEgg(1);

		System.out.println(max);
		br.close();
	}

}
