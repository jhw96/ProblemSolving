/*
 * 에너지 드링크를 섞어마시는데 단 여기서 규칙이 있다.
 * 두가지를 섞을 때 하나는 반을 버리고 섞는다.
 * 양이 적은 것을 반으로 나누면서 더해가면 됨
 */

package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_20115_에너지드링크 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 에너지 드링크 개수
		int[] drink = new int[N]; // 에너지 드링크의 양

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			drink[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(drink);

		double sum = drink[N - 1];
		for (int i = 0; i < N - 1; i++)
			sum += (double) drink[i] / (double) 2;

		System.out.println(sum);

		br.close();
	}

}
