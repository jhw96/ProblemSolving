package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2947_나무조각 {

	public static void swap(int[] arr, int pre, int aft) {
		int temp = arr[pre];
		arr[pre] = arr[aft];
		arr[aft] = temp;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[5];

		for (int i = 0; i < 5; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		boolean flag = false;
		while (true) {
			
			if(flag)
				break;
			
			flag = true;
			
			for (int i = 0; i < 4; i++) {
				
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
					flag = false;
					for (int j = 0; j < 5; j++)
						System.out.print(arr[j] + " ");
					System.out.println();
				}
			}
			
		}

	}

}
