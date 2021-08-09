package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_20310_타노스 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		char[] result = new char[input.length()];

		int zeroCnt = 0;
		int oneCnt = 0;

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '0') {
				result[i] = '0';
				zeroCnt++;
			} else {
				result[i] = '1';
				oneCnt++;
			}
		}

		zeroCnt /= 2;
		oneCnt /= 2;

		for (int i = input.length() - 1; i >= 0; i--) {
			if (zeroCnt == 0)
				break;
			if (input.charAt(i) == '0') {
				result[i] = 'x';
				zeroCnt--;
			}
		}

		for (int i = 0; i < input.length(); i++) {
			if (oneCnt == 0)
				break;
			if (input.charAt(i) == '1') {
				result[i] = 'x';
				oneCnt--;
			}
		}

		for (int i = 0; i < input.length(); i++) {
			if (result[i] == 'x')
				continue;
			System.out.print(result[i]);
		}

		br.close();
	}

}
