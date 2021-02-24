package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 윈도우 슬라이드로 풀면 될 듯함
public class Main_BOJ_2559번_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (i <= K - 1) 
				sum += arr[i];
		}
		

		int max = sum;
		int start = 0;
		for(int i=K; i<N; i++) {
			sum -= arr[start++];
			sum += arr[i];
			System.out.println(i+"번째 보는중 : " + sum);
			if(max < sum)
				max = sum;
		}
		
		System.out.println(max);
		

		br.close();
	}

}
