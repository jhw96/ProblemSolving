package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_5525_IOIOI {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		char[] str = br.readLine().toCharArray();

		int answer = 0;
		int patternCnt = 0; // 연속된 패턴의 갯수
		for (int i = 1; i < str.length - 1; i++) {
			
			if (str[i - 1] == 'I' && str[i] == 'O' && str[i + 1] == 'I') { // 패턴이 맞으면
				patternCnt++;
				if (patternCnt == N) {
					answer++;
					patternCnt--;
				}
				i++;
			} else // 패턴이 깨지면
				patternCnt = 0;

		}

		System.out.println(answer);

		br.close();
	}

}
