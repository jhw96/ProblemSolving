package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_SWEA_1223_계산기2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int tc=1; tc<=10; tc++) {
			int answer = 0;
			Stack<Integer> stack = new Stack<Integer>();
			
			int n = Integer.parseInt(br.readLine());
			
			String input = br.readLine();
			
			for(int i=0; i<n; i++) {
				if(input.charAt(i) >= '0' && input.charAt(i) <= '9') {
					stack.push(input.charAt(i) - '0');
				} else if(input.charAt(i) == '*') {
					int num1 = stack.pop();
					int num2 = input.charAt(i+1) - '0';
					int result = num1*num2;
					stack.push(result);
					i++;
				}
				
			}
			int size = stack.size();
			for(int i=0; i<size; i++) 
				answer += stack.pop();
			
			
			System.out.println("#" + tc + " " + answer);
		}
		
		
		br.close();
	}

}
