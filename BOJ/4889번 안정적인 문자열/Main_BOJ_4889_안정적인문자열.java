package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_4889_안정적인문자열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack<Character>();

		int idx = 1;
		String input = "";
		while (true) {
			int answer = 0;

			input = br.readLine();
			if (input.contains("-"))
				break;

			st.clear();

			for (int i = 0; i < input.length(); i++) {
				char now = input.charAt(i);
				if (now == '{') {
					st.push(now);
				} else {
					if (st.size() != 0) {
						st.pop();
					} else {
						answer++;
						st.push('{');
					}
				}

			}
			answer += (st.size() / 2);

			System.out.println((idx++) + ". " + answer);
		}

		br.close();
	} // main end

} // class end
