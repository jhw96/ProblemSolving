package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_10815_숫자카드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[] myCards = new int[N]; // 상근이 카드패
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			myCards[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(myCards); // 상근이 카드 패 정렬하기

		int M = Integer.parseInt(br.readLine());
		int[] cards = new int[M]; // 가지고 있는지 없는지 맞춰야할 카드 M개
		int[] answer = new int[M];
		st = new StringTokenizer(br.readLine(), " ");


		// 1 2 3 4 5 6 7 8
		for (int i = 0; i < M; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			int left = 0;
			int right = N-1;
			while (left <= right) {
				System.out.println("left : " + left + " right : " + right);
				int mid = (left + right) / 2;
				System.out.println("mid : " + mid);
				if (myCards[mid] == cards[i]) {
					answer[i] = 1;
					break;
				} else if (myCards[mid] < cards[i]) {
					left = mid + 1;
				} else if (myCards[mid] > cards[i]) {
					right = mid-1;
				}
			}
		}
		System.out.println(Arrays.toString(myCards));
		System.out.println(Arrays.toString(cards));
		
		for(int i=0; i<M; i++)
			System.out.print(answer[i] + " ");
		System.out.println();

		br.close();
	}

}
