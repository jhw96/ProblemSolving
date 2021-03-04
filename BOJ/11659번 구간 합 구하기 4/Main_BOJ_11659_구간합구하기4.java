package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11659_구간합구하기4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] numbers = new int[100001];
		int[] sum = new int[100001];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= N; i++)
			numbers[i] = Integer.parseInt(st.nextToken());

		sum[1] = numbers[1];
		for (int i = 2; i <= N; i++)
			sum[i] = sum[i - 1] + numbers[i];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			int result = sum[e] - sum[s-1];
			System.out.println(result);
			
		}
		
		

		br.close();
	}

}
