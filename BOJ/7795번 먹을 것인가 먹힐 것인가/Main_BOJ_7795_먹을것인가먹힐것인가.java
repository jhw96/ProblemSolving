package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_7795_먹을것인가먹힐것인가 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 먹는 A의 수
			int M = Integer.parseInt(st.nextToken()); // 먹히는 B의 수

			int[] A = new int[N];
			int[] B = new int[M];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; i++)
				A[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++)
				B[i] = Integer.parseInt(st.nextToken());

			System.out.println(Arrays.toString(A));

			Arrays.sort(B);
			System.out.println(Arrays.toString(B));

			int answer = 0;
			for (int i = 0; i < N; i++) { // 각 A들에 대해 먹을 수 있는 B의 쌍 구하기
				System.out.println("========" + A[i] + " 의 차례");
				int left = 0, right = M - 1;
				int result = 0;
				while (left <= right) {
					int mid = (left + right) / 2;
					if (B[mid] < A[i]) {
						System.out.println(A[i] + " 가 " + B[mid] + " 를 먹을 수 있다.");
						result = mid + 1;
						left = mid + 1;
					} else if (B[mid] >= A[i]) {
						right = mid - 1;
					}
				}
				answer += result;
			}

			System.out.println(answer);

		}

		br.close();
	}

}
