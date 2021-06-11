package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_1935_후위표기식2 {

	public static void main(String[] args) throws Exception { // A 65
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack1 = new Stack<Character>();
		Stack<Double> stack2 = new Stack<Double>();

		int[] value = new int[26];
		int N = Integer.parseInt(br.readLine()); // 피연산자 개수
		String input = br.readLine();

		for (int i = 0; i < N; i++) { // 영문자에 대응하는 값
			value[i] = Integer.parseInt(br.readLine());
		}

		for (int i = input.length() - 1; i >= 0; i--)
			stack1.push(input.charAt(i));

		while (stack1.size() != 0) {
			char data = stack1.pop();

			if (data >= 'A' && data <= 'Z') // 피연산자일 경우
				stack2.push((double) value[data - 'A']);
			else { // 연산자일 경우
				double num2 = stack2.pop();
				double num1 = stack2.pop();
				double result = 0;
				if (data == '+') {
					result = num1 + num2;
				} else if (data == '-') {
					result = num1 - num2;
				} else if (data == '*') {
					result = num1 * num2;
				} else {
					result = (double) num1 / num2;
				}

				stack2.push(result);

			}
		}

		System.out.printf("%.2f", stack2.pop());

		br.close();
	}

}
