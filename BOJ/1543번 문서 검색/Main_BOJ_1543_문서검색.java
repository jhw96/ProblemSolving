package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_1543_문서검색 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String compare = br.readLine();

		int lastIdx = -1; // 탐색한 마지막 인덱스
		int middleIdx = compare.length() % 2 == 0 ? compare.length() / 2 - 1 : compare.length() / 2; // 비교할 문자의 중간문자
		int tailLength = compare.length() % 2 == 0 ? middleIdx + 1 : middleIdx;
		int answer = 0;

		if (compare.length() <= input.length()) {
			for (int i = 0; i < input.length(); i++) {
				if (i + tailLength >= input.length())
					break;

				if (input.charAt(i) == compare.charAt(middleIdx)) { // 중간 문자와 같은 문자를 찾으면
					if (lastIdx < i - middleIdx) {
						// 마지막 탐색한 곳의 위치가 탐색 시작할 위치보다 앞에 있으면 가능
						boolean flag = true;
						int startIdx = i - middleIdx; // 탐색 시작할 인덱스

						for (int j = startIdx, k = 0; j < startIdx + compare.length(); j++, k++) {
							if (input.charAt(j) != compare.charAt(k)) {
								flag = false;
								break;
							}
						}

						if (flag) {
							answer++;
							lastIdx = startIdx + compare.length() - 1;
						}

					}
				}
			}
		}
		System.out.println(answer);

		br.close();
	}

}
