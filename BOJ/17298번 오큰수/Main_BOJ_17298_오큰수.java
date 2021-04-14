package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BOJ_17298_오큰수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer> stack = new Stack<Integer>();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int[] NGE = new int[N]; // 오큰수 배열

		for (int i = N - 1; i >= 0; i--) {

			int num = arr[i];

			while (!stack.isEmpty()) {
				int top = stack.pop();

				if (top > num) { // 현재 비교하는 수보다 큰 수면
					stack.push(top);
					NGE[i] = top;
					break;
				}
			}
			stack.push(num);

			if (NGE[i] == 0)
				NGE[i] = -1;

		}

		for (int i = 0; i < N; i++)
			bw.write(NGE[i] + " ");

		bw.flush();
		bw.close();
		br.close();
	}

}
