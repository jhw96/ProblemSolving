package com.jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_Jungol_1328_빌딩 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int[] buildings = new int[N + 1]; // 빌딩 높이

		Stack<int[]> stack = new Stack<int[]>(); // 빌딩 순서와 빌딩 높이 입력
		Stack<Integer> result = new Stack<Integer>();

		for (int i = 1; i <= N; i++) {
			buildings[i] = Integer.parseInt(br.readLine());
		}

		for (int i = N; i >= 1; i--) {
			boolean flag = true;
			int[] compare = {i,buildings[i]}; // 현재 비교할 빌딩
			
			while (!stack.isEmpty()) {
				int[] top = stack.pop();
				
				if (top[1] > compare[1]) { // 오른쪽의 빌딩이 비교할 빌딩보다 크다면
					stack.push(top);
					result.push(top[0]); // 몇번째 빌딩인지
					flag = false;
					break;
				} 
				// 작으면 그냥 버림
			}
			
			if(flag) // 위에서 더 큰 빌딩 못찾으면 그냥 0
				result.push(0);
			
			stack.push(compare);
		}
		
		while(!result.isEmpty())
			bw.write(result.pop()+"\n");
		bw.flush();
		
		bw.close();
		br.close();
	}

}
