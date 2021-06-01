package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1629_곱셈 {

	static long A, B, C;

	public static long solve(long n) {
		if (n == 1)
			return A % C;

		long tmp = solve(n / 2);

		if (n % 2 == 1)
			return (tmp * tmp % C) * A % C;

		return tmp * tmp % C;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		System.out.println(solve(B));
		br.close();
	}

}
