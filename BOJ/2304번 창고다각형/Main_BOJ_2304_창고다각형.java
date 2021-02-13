package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_2304_창고다각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		Stack<int[]> left = new Stack<int[]>();
		Stack<int[]> right = new Stack<int[]>();

		int N = Integer.parseInt(br.readLine());
		int[][] pillar = new int[N][2]; // 0: 기둥위치, 1: 기둥높이

		int middleIndex = 0, middleHeight = 0, realIndex = 0; // 가장 중간 기둥위치와 높이

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pillar[i][0] = Integer.parseInt(st.nextToken());
			pillar[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(pillar, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		for (int i = 0; i < N; i++) { // 중간에 가장 높은 기둥 찾기
			if (middleHeight < pillar[i][1]) {
				middleIndex = pillar[i][0];
				middleHeight = pillar[i][1];
				realIndex = i;
			}
		}

		int before = 0;
		for (int i = 0; i < realIndex; i++) { // 왼쪽에서 중간으로 탐색
			if (before < pillar[i][1]) {
				before = pillar[i][1];
				left.push(new int[] { pillar[i][0], before });
			}
		}

		before = 0;
		for (int i = N - 1; i > realIndex; i--) { // 오른쪽에서 중간으로 탐색
			if (before < pillar[i][1]) {
				before = pillar[i][1];
				right.push(new int[] { pillar[i][0], before });
			}
		}

		int totalArea = (pillar[N - 1][0] + 1 - pillar[0][0]) * middleHeight;
		
		before = middleIndex;
		while (!left.isEmpty()) {
			int[] temp = left.pop();
			totalArea -= (before - temp[0]) * (middleHeight - temp[1]);
			before = temp[0];
		}

		before = middleIndex;
		while (!right.isEmpty()) {
			int[] temp = right.pop();
			totalArea -= (temp[0] - before) * (middleHeight - temp[1]);
			before = temp[0];
		}
		
		System.out.println(totalArea);

		br.close();

	} // main end
} // class end
