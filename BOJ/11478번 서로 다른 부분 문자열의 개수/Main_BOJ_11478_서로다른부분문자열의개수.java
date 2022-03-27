package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_BOJ_11478_서로다른부분문자열의개수 {

	private static Set<String> set = new HashSet<String>();
	private static String input;

	private static void cntStr(String str, int idx, int end) {
		set.add(str);

		if (idx < end) {
			cntStr(str + input.charAt(idx), idx + 1, end);
		}
	} // cntStr end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		input = br.readLine();

		for (int i = 0; i < input.length(); i++) {
			cntStr(String.valueOf(input.charAt(i)), i + 1, input.length());
		}

		System.out.println(set.size());

		br.close();
	} // main end

}
