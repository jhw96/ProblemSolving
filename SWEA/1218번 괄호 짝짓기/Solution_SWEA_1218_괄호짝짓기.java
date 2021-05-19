package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_SWEA_1218_괄호짝짓기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			Stack<Character> st = new Stack<Character>();

			boolean flag = true;
			for (int i = 0; i < N; i++) {
				char now = input.charAt(i);

				if (now == '(' || now == '[' || now == '{' || now == '<')
					st.push(now);
				else {
					char top = st.pop();
					if (now == ')') {
						if (top == '(')
							continue;
						else {
							flag = false;
							break;
						}
					} else if (now == ']') {
						if(top == '[')
							continue;
						else {
							flag = false;
							break;
						}
					} else if(now =='}') {
						if(top=='{')
							continue;
						else {
							flag = false;
							break;
						}
					} else if(now == '>') {
						if(top =='<')
							continue;
						else {
							flag = false;
							break;
						}
					}
				}
			}
			
			if(flag)
				System.out.println("#" + tc + " " + 1);
			else
				System.out.println("#" + tc + " " + 0);

		}

		br.close();
	}

}
