package com.jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main_Jungol_2460_나는학급회장이다 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[][] count = new int[3][3]; // 3명의 후보가 각각의 점수 몇개씩 받았는지
		int[] sum = new int[3];
		int max = 0;
		int threeMax = 0, twoMax = 0;
		int index3 = 0, index2 = 0;
		boolean[] winner = new boolean[3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < 3; j++) { // 각 후보에 대한 점수받기
				int temp = Integer.parseInt(st.nextToken());
				count[j][temp - 1]++;
				sum[j] += temp;
				if (i == N - 1 && sum[j] > max)
					max = sum[j];

			}
		}

		for (int i = 0; i < 3; i++) // 최고점 후보들 체크하기
			if (max == sum[i])
				winner[i] = true;

		for (int i = 0; i < 3; i++) {
			if (winner[i] == true) {
				if (threeMax < count[i][2]) {
					threeMax = count[i][2];
				}
			}
		}

		int count3 = 0;
		for (int i = 0; i < 3; i++) {
			if (winner[i] == true) {
				if (threeMax == count[i][2]) {
					count3++;
					index3 = i;
				}
			}
		}

		if (count3 == 1) {
			bw.write((index3 + 1) + " " + max);
		} else if (count3 > 1) {
			int count2 = 0;

			for (int i = 0; i < 3; i++) {
				if (winner[i] == true) {
					if (twoMax < count[i][1]) {
						twoMax = count[i][1];
					}
				}
			}

			for (int i = 0; i < 3; i++) {
				if (winner[i] == true) {
					if (twoMax == count[i][1]) {
						count2++;
						index2 = i;
					}
				}
			}

			if (count2 == 1) {
				bw.write((index2 + 1) + " " + max);
			} else if (count2 > 1) {
				bw.write(0 + " " + max);
			}

		}

		bw.flush();
		bw.close();
		br.close();
	}

}
