package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_10799_쇠막대기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		Stack<Character> st = new Stack<Character>();
		int answer = 0;
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) == ')') { // 닫는 괄호면
				char tmp = st.pop();
				if(input.charAt(i-1) == '(') // 레이져면
					answer += st.size();
				else // 막대기가 끝나는 곳이면 그냥 꽁다리 +1
					answer++;
				
			} else { // 여는 괄호면
				st.push(input.charAt(i));
			}
		}
		
		System.out.println(answer);
		
		
		
		br.close();
	}

}
