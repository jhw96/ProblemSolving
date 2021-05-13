package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2670_연속부분최대곱 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		double[] arr = new double[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}

		double max = 0; // 초기설정


		for (int i = 0; i < N; i++) {
			double sum = 1;
			for (int j = i; j < N; j++) {
				sum *= arr[j];
				max = Math.max(max, sum);
			}
		}

		System.out.println(String.format("%.3f", max));

	}

}
