package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_8568_3으로나눈순열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int answer = 0;

			int[] arr = new int[N + 1]; // 순열

			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				int idx = i % 3;
				idx = idx == 0 ? 3 : idx; // 0이면 3
				arr[i] = arr[i] % 3 == 0 ? 3 : arr[i] % 3;
			}

			for (int i = 1; i < N; i++) {
				int realIdx = i % 3 == 0 ? 3 : i % 3;
				if (arr[i] != realIdx) {// 자기가 있어야할 자리가 아니라면
					boolean flag = false;
					int change = 0;
					for (int j = i + 1; j <= N; j++) {
						int realJdx = j % 3 == 0 ? 3 : j % 3;
						if (realJdx != realIdx) { // 서로 다른 자리이면
							if (arr[i] == realJdx && arr[j] == realIdx) { // 현재 비교하는 i와 j가 같다면(서로 바꾸면 딱 맞는 경우)
								answer++;
								swap(i, j, arr);
								flag = true;
								break;
							}

							if (arr[j] == realIdx && arr[i] != realJdx) { // 현재 비교하는 i와는 j가 숫자가 같지만 i는 j와 다르다면
								change = j;
							}

						}

					}
					if (!flag) { // 서로 같은 자리를 찾지못한 경우
						swap(i, change,arr);
						answer++;
					}

				}
			}

			System.out.println("#" + tc + " " + answer);

		}

		br.close();
	}

	private static void swap(int i, int j,int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
