package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main_BOJ_12919_A와B2 {

	static String S, T;
	static Set<String> set = new HashSet<String>();
	static boolean flag;

	private static void BFS() {
		Queue<String> q = new LinkedList<String>();
		q.add(T);

		while (!q.isEmpty()) {
			String top = q.poll();
			int length = top.length();

			if (top.length() == S.length()) {
				if (top.equals(S)) {
					flag = true;
					System.out.println("1");
					return;
				}
				continue;
			}

			if (top.charAt(length - 1) == 'A') {
				String next = top.substring(0, length - 1);
				q.add(next);
			}

			if (top.charAt(0) == 'B') {
				String next = top.substring(1, top.length());
				StringBuilder sb = new StringBuilder();
				
				System.out.println(top);
				System.out.println(next);
				System.out.println();
				
				for (int i = next.length() - 1; i >= 0; i--)
					sb.append(next.charAt(i));
				
				q.add(sb.toString());

			}

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine();
		T = br.readLine();

		BFS();

		if (!flag)
			System.out.println(0);

		br.close();
	}

}
