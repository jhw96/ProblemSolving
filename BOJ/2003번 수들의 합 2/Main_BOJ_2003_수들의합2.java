package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2003_수들의합2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int answer = 0;
		int sum = arr[0];
		int left = 0, right = 0;

		while (left <= right) {
			if (sum <= M) {
				if (sum == M)
					answer++;
				if (right + 1 < N)
					sum += arr[++right];
				else
					break;
			} else if (sum > M) {
				if (left < right) // 정렬이 되어있는 것이 아니기 때문에 왼쪽애가 오른쪽에 나올 애보다 큰 경우일 수 있음
					sum -= arr[left++];
				else {
					if (right + 1 < N)
						sum += arr[++right];
					else
						break;
				}
			}
		}

		System.out.println(answer);

		br.close();
	}

}
