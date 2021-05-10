package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_17952_과제는끝나지않아 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int answer = 0;
		Stack<int[]> stack = new Stack<int[]>();

		int N = Integer.parseInt(br.readLine());
		for (int minute = 1; minute <= N; minute++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			if (Integer.parseInt(st.nextToken()) == 1) { // 과제가 있다면
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());

				time -= 1; // 받자마자 과제함

				if (time <= 0) // 받자마자 끝나면
					answer += score;
				else // 끝나지 않으면
					stack.push(new int[] { score, time });
			} else { // 과제가 없다면
				int[] top = stack.pop();
				top[1] -= 1; // 과제하기

				if (top[1] <= 0) // 과제 끝냈으면
					answer += top[0];
				else
					stack.push(new int[] { top[0], top[1] });
			}
		}
		
		System.out.println(answer);

		br.close();
	}

}
