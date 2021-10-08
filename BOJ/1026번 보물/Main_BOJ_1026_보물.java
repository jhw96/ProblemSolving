/*
 * N개의 수열 2개를 입력받았을 때
 * S = A[0] x B[0] + ... + A[N-1] x B[N-1]의 최소값을 찾아라.
 * 그리디 알고리즘으로 간단하게 풀 수 있음
 */
package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1026_보물 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			A[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			B[i] = Integer.parseInt(st.nextToken());

		int S = 0;

		Arrays.sort(A);
		Arrays.sort(B);

		for (int i = 0; i < N; i++) { // 가장 작은 값과 가장 큰 값을 서로 곱해준다.
			S += (A[i] * B[N - i - 1]);
		}

		System.out.println(S);
		
		br.close();
	}

}
