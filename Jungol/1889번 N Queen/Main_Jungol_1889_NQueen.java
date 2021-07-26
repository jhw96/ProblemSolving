package com.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_Jungol_1889_NQueen {

	static int N; // 체스판 크기
	static int answer;
	static int[] place;

	private static boolean isAvaliable(int idx, int step) {
		for (int i = 1; i <= step - 1; i++) {
			int diff = step - i;
			int down = place[i] - diff;
			if (down >= 1 && down == idx)
				return false;
			int up = place[i] + diff;
			if (up <= N && up == idx)
				return false;
		}

		return true;
	}

	private static void DFS(int step,boolean[] row, int end) {
		if (step == N + 1) {
			answer++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!row[i] && isAvaliable(i, step)) {
				row[i] = true;
				place[step] = i;
				DFS(step + 1,row, end);
				row[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		place = new int[N + 1];

		DFS(1,new boolean[N+1], N);

		System.out.println(answer);

		br.close();
	}

}
