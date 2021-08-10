package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BOJ_2plus1세일 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 유제품 개수

		int[] prices = new int[N];

		for (int i = 0; i < N; i++)
			prices[i] = Integer.parseInt(br.readLine());

		Arrays.sort(prices);
		
		int idx = 0;
		int answer = 0;
		for(int i=N-1; i>=0; i--) {
			idx++;
			if(idx % 3 == 0) {
				idx = 0;
				continue;
			}
			answer += prices[i];
		}
		
		System.out.println(answer);
		

		br.close();
	}

}
