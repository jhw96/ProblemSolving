package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_11660_구간합구하기5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 표의 크기
		int M = Integer.parseInt(st.nextToken()); // 합을 구해야하는 횟수

		int[][] map = new int[N + 1][N + 1];

		for (int y = 0; y <= N; y++)
			map[y][0] = 0;

		for (int x = 0; x <= N; x++)
			map[0][x] = 0;

		int[][] sum = new int[N + 1][N + 1]; // 누적합을 저장한 배열

		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= N; x++) {
				sum[y][x] = sum[y][x-1] + sum[y-1][x] - sum[y-1][x-1] + map[y][x];
			}
		}
		System.out.println();
		for(int y=1; y<=N; y++)
			System.out.println(Arrays.toString(sum[y]));

		for (int i = 0; i < M; i++) { // 행 열 행 열 순으로 입력
			st = new StringTokenizer(br.readLine(), " ");

			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			if (y1 > N || x1 > N || y2 > N || x2 > N) // 범위를 벗어나면 skip
				continue;
			int answer = 0;

			answer = sum[y2][x2] - sum[y2][x1-1] - sum[y1-1][x2] + sum[y1-1][x1-1];

			bw.write(answer + "\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}

}
