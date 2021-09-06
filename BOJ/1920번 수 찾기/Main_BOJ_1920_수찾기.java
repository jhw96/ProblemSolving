package com.baekjoon;

/*
 * M개의 수들이 N개의 수열 안에 존재하는지 찾는 문제
 * 이분탐색을 통해 빠르게 찾을 수 있다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1920_수찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(br.readLine());
		int[] find = new int[M];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < M; i++)
			find[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr); // 이분탐색을 위해 정렬해야한다.

		for (int i = 0; i < M; i++) {
			System.out.println(binarySearch(0, N - 1, arr, find[i]));
		}

		br.close();
	} // main end

	private static int binarySearch(int start, int end, int[] arr, int find) {
		if (start > end) {
			return 0;
		}
		int mid = (start + end) / 2;
		if (find == arr[mid]) // 같은 값을 찾은 경우
			return 1;
		else if (find > arr[mid]) // 찾는 값이 중앙보다 크면
			return binarySearch(mid + 1, end, arr, find);
		else // 찾는 값이 중앙보다 작으면
			return binarySearch(start, mid - 1, arr, find);

	} // binarySearch end

}
