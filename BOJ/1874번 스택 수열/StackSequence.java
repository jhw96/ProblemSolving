package com.baekjoon;

import java.util.Scanner;
import java.util.Stack;

//1874번 스택 수열
public class StackSequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int max = 0;
		int top = 0;
		boolean stop = false;

		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			if (num < top) 
				stop = true;
	
			if(stop)
				continue;

			for (int j = max + 1; j <= num; j++) {
//				System.out.println(j + "를 쌓는다.");
				stack.push(j);
				sb.append("+\n");
			}
			max = Math.max(max, stack.peek()); // 최고값 갱신
//			System.out.println(stack.peek() + "를 뺀다.");
			sb.append("-\n");
			stack.pop();
//			for(int j=0; j<stack.size(); j++)
//				System.out.println(stack.get(j));
			if(stack.size() != 0)
				top = stack.peek();

		}
		
		if(stop)
			System.out.println("NO");
		else
			System.out.print(sb.toString());
	}
}
