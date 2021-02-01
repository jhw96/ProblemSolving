package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2630 색종이 만들기
public class Main_BOJ_2630 {
	// 상 하 좌 우 좌상 우상 좌하 우하
	static int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 };
	
	static int bCount = 0; // 파란색 갯수
	static int wCount = 0; // 흰색 갯수

	static boolean search(int[][] map, int size, int startX, int startY, int cut) { // 맵, 맵크기, 탐색시작점, 자르는 크기

		for (int i = startY; i < startY + cut - 1; i++) { // 행
			for (int j = startX; j < startX + cut - 1; j++) { // 열
				for (int k = 0; k < 8; k++) {
					int x = j + dx[k];
					int y = i + dy[k];
					if (x >= startX && y >= startY && x <= startX + cut - 1 && y <= startY + cut - 1) { // 탐색범위가 맵 범위 안에
																										// 들어가면
						if (map[i][j] != map[y][x]) // 현재 비교하는 위치와 근접한 종이가 색이 다를때
							return false;
					}
				}
			}
		}

		return true;
	}

	static void counting(int[][] map, int size, int startX, int startY, int cut) { // 맵, 맵크기, 탐색시작점, 자르는 크기
		if (!search(map, size, startX, startY, cut)) { // 자르기 전 색종이 색깔이 각각 다르다면
			cut /= 2;
			int[] newStartX = { startX, startX + cut, startX, startX + cut }; // 자르고 난 뒤에 시작점들
			int[] newStartY = { startY, startY, startY + cut, startY + cut };

			for (int i = 0; i < 4; i++)  // 자르고 탐색 시작
				counting(map, size, newStartX[i], newStartY[i], cut);
		} else {
			if(map[startY][startX] == 1)
				bCount++;
			else
				wCount++;
			return;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		StringTokenizer st = null;

		for (int i = 0; i < N; i++) { // 색종이 배치시키기
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int size = N; // 맵 전체 크기
		int cut = N; // 자르는 사이즈
		int start = 0;
		counting(map, size, start, start, cut);
		
		System.out.println(wCount);
		System.out.println(bCount);
		
		br.close();
	} // main end
} // class end
