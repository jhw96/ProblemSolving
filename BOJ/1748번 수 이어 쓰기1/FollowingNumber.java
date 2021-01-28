package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 백준 1748 수 이어쓰기1
public class FollowingNumber {
	
	public static int calSize(int n) {
		int result = 0;
		while(n >= 1) {
			n/=10;
			result++;
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long answer = 0;

		for (int i = 1; i <= N; i++) {
			answer += calSize(i);
		}
		System.out.println(answer);
	}

}
