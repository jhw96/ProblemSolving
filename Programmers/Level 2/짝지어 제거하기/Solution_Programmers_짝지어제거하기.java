package com.programmers;

import java.util.Stack;

public class Solution_Programmers_짝지어제거하기 {

	public static void main(String[] args) {
//		String s = "baabaa";
		String s = "cdcd";

		Stack<Character> st = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			if(!st.isEmpty()) {
				if(st.peek() == s.charAt(i)) {
					st.pop();
				} else {
					st.push(s.charAt(i));
				}
			} else {
				st.push(s.charAt(i));
			}
			
		}
		
		int answer = 0;
		
		if(st.isEmpty())
			answer = 1;
		
		System.out.println(answer);

	}

}
