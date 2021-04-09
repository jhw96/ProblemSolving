package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_16953_AB {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());

		int answer = 1;

		while (B > A) {
			if (B % 10 == 1) {
				B /= 10;
			} else if (B % 2 == 0) {
				B /= 2;
			} else {
				break;
			}
			answer++;
		}

		if (A == B)
			System.out.println(answer);
		else
			System.out.println(-1);
		br.close();
	}

}
