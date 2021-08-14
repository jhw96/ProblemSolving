package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BOJ_15729_나무자르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N][2];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			input[i][0] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			input[i][1] = Integer.parseInt(st.nextToken());

		ArrayList<int[]> trees = new ArrayList<int[]>();

		for (int i = 0; i < N; i++)
			trees.add(input[i]);

		Collections.sort(trees, new Comparator<int[]>() { // 자라는 속도별로 정렬하기
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		long answer = 0;

		for (int i = 0; i < N; i++) {
			int height = trees.get(i)[0];
			int speed = trees.get(i)[1];
			answer += (height + speed * i);
		}

		System.out.println(answer);

		br.close();

	}

}
