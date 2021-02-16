package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		boolean flag = false;

		for (int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);

			if (temp == '<') {
				while (!stack.isEmpty())
					sb.append(stack.pop());
				flag = true;
			}
			if (temp == '>') {
				sb.append(temp);
				flag = false;
			}
			if (flag) {
				sb.append(temp);
			} else {
				if(temp == ' ') {
					while(!stack.isEmpty())
						sb.append(stack.pop());
					sb.append(' ');
					continue;
				}
				if (temp != '>')
					stack.push(temp);
			}
		}

		while (!stack.isEmpty())
			sb.append(stack.pop());

		System.out.println(sb);

		br.close();
	}

}
