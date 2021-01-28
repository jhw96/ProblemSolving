package com.baekjoon;

import java.util.*;
import java.io.*;

//1972번 놀라운 문자열
public class SurprisingString {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);

		while (true) {
			String word = scan.next();
			if (word.equals("*"))
				break;
			boolean flag = true;

			for (int i = 0; i < word.length() - 1; i++) { // 만들 수 있는 문자열 거리 횟수
				List<String> list = new ArrayList<String>();
				HashSet<String> set = new HashSet<String>();

				for (int j = 0; j < word.length() - i - 1; j++) { // 거리당 만들 수 있는 문자열 개수
					String pair_string = "" + word.charAt(j) + word.charAt(j + i + 1); // 거리만큼 멀어진 인덱스
					list.add(pair_string);
					set.add(pair_string);
				}

				if (list.size() != set.size()) {
					flag = false;
					break;
				}

				list.clear();
				set.clear();

			}

			if (flag)
				System.out.println(word + " is surprising.");
			else
				System.out.println(word + " is NOT surprising.");
		}
	}// main end
} // class end
			