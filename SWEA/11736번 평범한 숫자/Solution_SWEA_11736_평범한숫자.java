package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_11736_평범한숫자 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N]; // 수열
			int answer = 0;

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			for (int i = 1; i < N - 1; i++) {
				boolean leftSmall = false;
				boolean leftBig = false;

				boolean rightSmall = false;
				boolean rightBig = false;

				// 왼쪽 수 비교
				if (arr[i - 1] < arr[i])
					leftSmall = true;
				else if (arr[i - 1] > arr[i])
					leftBig = true;

				if (arr[i + 1] < arr[i])
					rightSmall = true;
				else if (arr[i + 1] > arr[i])
					rightBig = true;
				
				if(leftSmall && rightBig)
					answer++;
				else if(leftBig && rightSmall)
					answer++;
			}

			System.out.println("#" + tc + " " + answer);
		}

		br.close();
	}

}
