package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main_BOJ_1302_베스트셀러 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<String> list = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < N; i++) {
			String book = br.readLine();

			if (map.containsKey(book)) {
				int cnt = map.get(book);
				map.put(book, cnt + 1);
			} else {
				map.put(book, 1);
				list.add(book);
			}
		}

		int max = 0;
		String answer = "";
		for (int i = 0; i < list.size(); i++) {
			int cnt = map.get(list.get(i));
			if (cnt > max) {
				max = cnt;
				answer = list.get(i);
			} else if (cnt == max) {
				if (answer.compareTo(list.get(i)) > 0) {
					answer = list.get(i);
				}
			}
		}
		
		System.out.println(answer);

		br.close();
	}

}
