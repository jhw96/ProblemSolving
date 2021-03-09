package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_1535_안녕 {

	static int max = 0;

	public static void subset(int[][] arr, int cnt, int length, int sum, int hp) {
		if (hp <= 0)
			return;
		if (cnt == length) {
			if(sum > max)
				max = sum;
			return;
		}

		subset(arr, cnt + 1, length, sum + arr[cnt][1], hp - arr[cnt][0]);
		subset(arr, cnt + 1, length, sum, hp);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[][] score = new int[N][2]; // 0: 잃는 체력 , 1: 얻는 기쁨

		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				score[j][i] = Integer.parseInt(st.nextToken());
			}
		}

		subset(score, 0, N, 0, 100);
		bw.write(max+"\n");
		bw.flush();
		br.close();
		bw.close();
	}

}
