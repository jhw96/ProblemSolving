package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_BOJ_2447_별찍기10 {

	public static void star(int N, int startX, int startY, char[][] arr) {
		if (N == 1) { // 1까지 도달하면 별찍기
			arr[startY][startX] = '*';
			return;
		} else { // 아니면 9등분해서 계속 들어가기
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == 1 && j == 1)
						continue;
					star(N / 3, startX + j * (N / 3), startY + i * (N / 3), arr);
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];
		for (int i = 0; i < N; i++)
			Arrays.fill(arr[i], ' ');

		star(N, 0, 0, arr);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				bw.write(arr[i][j]);
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
