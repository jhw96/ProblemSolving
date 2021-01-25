package com.swea;

import java.util.*;

public class LawnMower {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] map = new int[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int[] mMax = new int[N];
			int[] nMax = new int[M];

			for (int i = 0; i < N; i++) { // 행에서 가장 큰 값
				for (int j = 0; j < M; j++) {
					mMax[i] = Math.max(mMax[i], map[i][j]);
				}
			}

			for (int i = 0; i < M; i++) { // 열에서 가장 큰 값
				for (int j = 0; j < N; j++) {
					nMax[i] = Math.max(nMax[i], map[j][i]);
				}
			}

			boolean answer = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if ((map[i][j] == mMax[i]) || (map[i][j] == nMax[j])) {
						continue;
					} else {
						answer = true;
						break;
					}
				}
				if(answer)
					break;
			}

			System.out.println("#" + tc + (answer ? " NO" : " YES"));
		}

	}// Main end

}// Class end
