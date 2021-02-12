package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1105_팔 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		String num1 = st.nextToken();
		String num2 = st.nextToken();

		int answer = 0;

		if (num1.length() != num2.length()) // 자릿수가 다르면 무조건 0
			System.out.println(answer);
		else {
			boolean flag = false;
			for(int i=0; i<num1.length(); i++) {
				if(num1.charAt(i) != num2.charAt(i))
					flag = true;
				if(flag)
					break;
				if(num1.charAt(i) == '8' && num2.charAt(i) == '8')
					answer++;
			}
			
			System.out.println(answer);
		}

		br.close();
	}
}
