package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2491_수열_다른풀이 {
	/*
	 * 9 4 1 3 3 2 2 9 2 3
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] up = new int[N];
		int[] down = new int[N];

		Arrays.fill(up, 1);
		Arrays.fill(down, 1);

		int answer = 0;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N - 1; i++) {
			if (arr[i] <= arr[i + 1]) {
				up[i + 1] = up[i] + 1;
			}
			if(answer < up[i+1])
				answer = up[i+1];
		}
		
		for(int i=0; i<N-1; i++) {
			if(arr[i] >= arr[i+1]) {
				down[i+1] = down[i] + 1;
			}
			if(answer < down[i+1])
				answer = down[i+1];
		}
		
		System.out.println(answer);
		
		br.close();
	}

}
