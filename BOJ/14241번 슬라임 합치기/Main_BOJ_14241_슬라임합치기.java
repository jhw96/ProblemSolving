package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BOJ_14241_슬라임합치기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> slime = new ArrayList<Integer>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			slime.add(Integer.parseInt(st.nextToken()));

		int size = slime.size();
		int score = 0;

		while (size != 1) {
			
			Collections.sort(slime);
			
			int min = slime.get(0);
			int max = slime.get(size - 1);

			slime.remove(size - 1);
			slime.remove(0);

			int newSize = min + max;
			score += min * max;
			slime.add(newSize);
			size = slime.size();
		}

		System.out.println(score);
		br.close();
	}

}
