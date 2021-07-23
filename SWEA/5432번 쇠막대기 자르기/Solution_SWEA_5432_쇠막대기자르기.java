package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_SWEA_5432_쇠막대기자르기 {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int answer = 0;
			Stack<Character> st = new Stack<Character>();
			
			String input = br.readLine();
			
			for(int i=0; i<input.length(); i++) {
				char now = input.charAt(i);
				if(now == '(') {
					st.push(now);
				} else {
					if(input.charAt(i-1) == '(') {
						st.pop();
						answer += st.size();
					} else {
						st.pop();
						answer++;
					}
				}
			}
			
			
			System.out.println("#" + tc+ " " + answer);
		}

		br.close();
	}

}
