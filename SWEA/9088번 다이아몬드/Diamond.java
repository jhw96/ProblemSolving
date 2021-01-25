package com.swea;

import java.util.*;

// 투 포인터
public class Diamond {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int[] diamond = new int[N];
			for (int i = 0; i < N; i++)
				diamond[i] = sc.nextInt();

			int left = 0;
			int right = 0;
			int diff = diamond[right] - diamond[left];
			int max = 0;
			int count = 0;

			Arrays.sort(diamond);

			while (true) {
				if (diff <= K) { // 차가 k보다 작으면
					count++;
					right++;
					if (max < count)
						max = count;
				} else if (diff > K) { // 차가 k보다 크면
					count--;
					left++;
				}
				
				if (right == N)
					break;
				
				diff = diamond[right] - diamond[left];
			}

			System.out.println("#" + tc + " " + max);

		}

	}// main end
}// class end
