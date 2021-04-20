package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2470_두용액 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 용액의 개수
		int[] ph = new int[N]; // 용액 산성도

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			ph[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(ph);

		int left = 0, right = N - 1;
		int min = Integer.MAX_VALUE;
		int mLeft = 0, mRight = 0;

		while (left < right) {
			int diff = ph[right] + ph[left];
			if (Math.abs(diff) < min) {
				min = Math.abs(diff);
				mLeft = left;
				mRight = right;
			}

			if (diff > 0) {
				
				right--;
				
			}
			else if (diff < 0) {
				
				left++;
			}
			else
				break;

		}

		System.out.println(ph[mLeft] + " " + ph[mRight]);

		br.close();
	}

}
