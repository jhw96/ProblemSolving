package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2023_신기한소수 {

	public static boolean isPrime(int n) {
		if (n == 1)
			return false;
		if (n % 2 == 0) {
			if (n == 2)
				return true;
			else
				return false;
		} else {
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0)
					return false;
			}
		}

		return true;
	}

	public static void search(String res, int cnt, int N) {
		if (cnt == N) {
			System.out.println(res);
			return;
		}
		int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		for (int i = 0; i < 9; i++) {
			String temp = res + Integer.toString(num[i]);
			if (isPrime(Integer.parseInt(temp))) {
				search(temp, cnt + 1, N);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N의 자리 수 찾아야함

		search("", 0, N);
		br.close();
	}

}
