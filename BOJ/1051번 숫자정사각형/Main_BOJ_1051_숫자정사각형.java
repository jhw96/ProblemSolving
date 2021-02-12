package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1051_숫자정사각형 {

	public static void main(String[] args) throws IOException {
		// 오른쪽 꼭지점, 왼쪽아래 꼭지점, 오른쪽 아래 꼭지점
		int[] dx = { 1, 0, 1 };
		int[] dy = { 0, 1, 1 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 행 크기
		int M = Integer.parseInt(st.nextToken()); // 열 크기
		int[][] square = new int[N][M];

		for (int i = 0; i < N; i++) { // N x M 크기 직사각형 입력
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				square[i][j] = input.charAt(j) - '0';
			}
		}

		int max = 0;
		for (int y = 0; y < N; y++) { // 행 검사
			for (int x = 0; x < M; x++) { // 열 검사
				int scale = 1;
				loop: while (true) {
					int count = 0;
					for (int i = 0; i < 3; i++) {
						int nextX = x + dx[i] * scale;
						int nextY = y + dy[i] * scale;
						if (nextX < M && nextY < N) {
							if (square[y][x] == square[nextY][nextX])
								count++;
						} else {
							break loop;
						}
					}
					if (count == 3) { // 4개의 꼭지점이 같다면
						if (scale > max)
							max = scale;
					}
					scale++;
				}
			}
		}

		System.out.println((max+1)*(max+1));

		br.close();
	} // main end

} // class end
