package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_16401_과자나눠주기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int M = Integer.parseInt(st.nextToken()); // 조카의 수
		int N = Integer.parseInt(st.nextToken()); // 과자 개수
		int max = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] snack = new int[N];

		for (int i = 0; i < N; i++) {
			snack[i] = Integer.parseInt(st.nextToken());
			if(snack[i] > max)
				max = snack[i];
		}


		int left = 0, right = max; // 줄 수 있는 가장 작은 길이와 가장 큰 길이
		int result = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			int count = 0;

			for (int i = 0; i < N; i++) { // 부술 수 있는 과자개수 세기
				if (snack[i] / mid > 0) {
					count += (snack[i] / mid);
				}
			}
//			System.out.println("과자 길이 : " + mid);
//			System.out.println("줄 수 있는 개수 : " + count);
			if (count >= M) { // 과자 개수를 조카에게 다 나눠줄 수 있거나 넘치면
				result = mid;
				left = mid + 1;
			} else { // 과자 개수가 조카에게 다 나눠줄 수 없으면
				right = mid - 1;
			}

		}

		bw.write(result+"\n");
		bw.flush();
		br.close();
	}

}
