package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_11899_괄호끼워넣기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		Stack<Character> st = new Stack<Character>();
		
		int answer = 0;
		
		for(int i=input.length()-1; i>=0; i-- ) {
			if(input.charAt(i) == ')')
				st.push(input.charAt(i));
			else {
				if(st.size()!=0)
					st.pop();
				else
					answer++;
			}
		}
		
		answer += st.size();
		
		System.out.println(answer);
		
		br.close();
	}

}
