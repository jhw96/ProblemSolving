package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_2922_즐거운단어 {

	static String str;

	private static long makeWord(int step, int end, int lCnt, int conCnt, int vowCnt) { // 몇번째 글자인지, L의 개수, 자음 개수, 모음개수
		if (conCnt >= 3 || vowCnt >= 3)
			return 0;
		
		if (step == end) {
			if (lCnt == 0)
				return 0;

			return 1;
		}
		long result = 0;
		char now = str.charAt(step);

		if (now == '_') {
			result += (5 * makeWord(step + 1, end, lCnt, conCnt + 1, 0));
			result += makeWord(step + 1, end, lCnt + 1, 0, vowCnt + 1);
			result += 20 * (makeWord(step + 1, end, lCnt, 0, vowCnt + 1));
		} else {
			if (now == 'A' || now == 'E' || now == 'I' || now == 'O' || now == 'U') { // 자음
				result += makeWord(step + 1, end, lCnt, conCnt + 1, 0);
			} else { // 모음
				if (now == 'L') {
					result += makeWord(step + 1, end, lCnt + 1, 0, vowCnt + 1);
				} else {
					result += makeWord(step + 1, end, lCnt, 0, vowCnt + 1);
				}
			}
		}
		
		return result;
	} // makeWord end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();

		System.out.println(makeWord(0, str.length(), 0, 0, 0));

		br.close();
	}

}
