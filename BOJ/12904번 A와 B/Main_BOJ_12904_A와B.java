package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_12904_A와B {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		String T = br.readLine();


		int until = S.length() - 1; // S의 문자열 길이
		int end = T.length() - 1; // T의 문자열 길이

		for (int i = end; i > until; i--) {
			if (T.charAt(i) == 'A') {
				T = T.substring(0, i);
			} else if (T.charAt(i) == 'B') {
				T = T.substring(0, i);
				T = reverse(T);
			}
		}


		if (S.equals(T))
			System.out.println(1);
		else
			System.out.println(0);

		br.close();
	}

	private static String reverse(String t) {
		String result = "";
		char[] change = t.toCharArray();
		int left = 0, right = t.length() - 1;

		while (left < right) {
			char temp = t.charAt(left);
			change[left] = t.charAt(right);
			change[right] = temp;
			left++;
			right--;
		}

		for (int i = 0; i < change.length; i++)
			result += change[i];

		return result;
	}

}
