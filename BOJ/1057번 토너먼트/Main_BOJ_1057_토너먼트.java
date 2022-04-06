package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  참가자의 번호는 순서대로 매겨지고 홀수인 경우 마지막 번호는 다음 라운드 진출.
 *  1,2 번이 싸워 이긴 사람이 다음라운드 1번 / 3,4번이 싸워 이긴 사람이 다음라운드 2번
 *	1번 참가자와 2번 참가자는 서로 만나기 전까지 항상 우승한다. 
 */

public class Main_BOJ_1057_토너먼트 {

	static int N, num1, num2; // 참가자의 수, 참가자1의 번호, 참가자2의 번호

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		num1 = Integer.parseInt(st.nextToken());
		num2 = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
		while (num1 != num2) {
			num1 = (num1 + 1) / 2;
			num2 = (num2 + 1) / 2;

			count++;
		}

		System.out.println(count);

		br.close();
	}

}
