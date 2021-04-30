package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_14719_빗물 {

	static int H, W;
	static int[] height;
	static int[][] map;
	static boolean flag;

	public static void DFS(int x, int y) {

		int nX = x + 1; // 다음 위치

		if (nX <= W) {
			if (map[y][nX] == 1) { // 벽돌이면 return
				flag = true;
				return;
			}

			map[y][x] = 2; // 가로로 지나가면서 빗물 표시
			DFS(nX, y);

			if (!flag) // 벽돌을 만나지 못하면 맵을 벗어난 것
				map[y][x] = 0;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		H = Integer.parseInt(st.nextToken()); // 세로 높이
		W = Integer.parseInt(st.nextToken()); // 가로 높이

		height = new int[W + 1]; // x축이 해당 idx인 곳의 블록높이
		Arrays.fill(height, -1);
		map = new int[H + 1][W + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int x = 1; x <= W; x++) {
			int blockHeight = Integer.parseInt(st.nextToken()); // 블록 높이
			height[x] = blockHeight;
			for (int y = 1; y <= blockHeight; y++) {
				map[y][x] = 1;
			}
		}

		for (int x = 1; x <= W; x++) { // x축 돌면서 탐색
			for (int y = 1; y <= height[x]; y++) {
				flag = false;
				DFS(x, y);
			}
		}
		
		int answer = 0;
		for(int y=1; y<=H; y++)
			for(int x=1; x<=W; x++)
				if(map[y][x] == 2)
					answer++;
		
		System.out.println(answer);

		br.close();
	}

}
