package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main_BOJ_5052_전화번호목록 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			String[] strings = new String[n];
			Set<String> set = new HashSet<String>();

			for (int i = 0; i < n; i++) {
				String input = br.readLine();
				strings[i] = input;
			}

			Arrays.sort(strings, new Comparator<String>() {
				public int compare(String o1, String o2) {
					if (o1.length() != o2.length())
						return o1.length() - o2.length();
					return o1.compareTo(o2);
				}
			});

			boolean flag = true;

			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < strings[i].length(); j++) {
					sb.append(strings[i].charAt(j));

					if (set.contains(sb.toString())) {
						System.out.println("NO");
						flag = false;
						break;
					}
				}

				if (!flag)
					break;
				else
					set.add(sb.toString());
			}

			if (flag)
				System.out.println("YES");

		}

		br.close();
	}

}
