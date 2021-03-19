package com.programmers;

public class Solution_Programmers_NQueen {

	static int answer = 0;

	public static boolean isPossible(int[] chess, int currentRow) {
		for (int i = 1; i <= currentRow - 1; i++) {
			if (chess[i] == chess[currentRow]) { // 같은 열이면
				return false;
			}
			int diff = currentRow - i;
			// 대각선에 위치하면
			if (chess[i] + diff == chess[currentRow])
				return false;

			if (chess[i] - diff == chess[currentRow])
				return false;
		}

		return true;
	}

	public static void DFS(int[] chess, int cnt, int n) {
		if (cnt == n+1) {
			answer++;
			return;
		}

		for (int i = 1; i <= n; i++) {
			chess[cnt] = i;
			if (isPossible(chess, cnt)) {
				DFS(chess, cnt + 1, n);
			}
		}
	}

	public static void main(String[] args) {
		int n = 7;
		int[] chess = new int[n + 1];
		DFS(chess,1,n);
		System.out.println(answer);

	}

}
