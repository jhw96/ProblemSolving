package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2529_부등호 {

	static int k; // 부등호의 개수
	static char[] sign;
	static boolean[] used = new boolean[10];
	static String max = "0";
	static String min = "9";

	private static void makeOrder(int step, int before, StringBuilder sb) {
		if (step == k) {
			if (max.compareTo(sb.toString()) < 0)
				max = sb.toString();
			if (min.compareTo(sb.toString()) > 0)
				min = sb.toString();
			return;
		}

		char now = sign[step];

		for (int i = 0; i < 10; i++) {
			if (used[i])
				continue;
			if (now == '<') {
				if (before < i) {
					used[i] = true;
					sb.append(i);
					makeOrder(step + 1, i, sb);
					sb.deleteCharAt(step + 1);
					used[i] = false;
				}
			} else {
				if (before > i) {
					used[i] = true;
					sb.append(i);
					makeOrder(step + 1, i, sb);
					sb.deleteCharAt(step + 1);
					used[i] = false;
				}
			}
		}
	} // makedOrder end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		sign = new char[k];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < k; i++)
			sign[i] = st.nextToken().charAt(0);

		for (int num = 0; num < 10; num++) {
			used[num] = true;
			makeOrder(0, num, new StringBuilder().append(num));
			used[num] = false;
		}
		
		System.out.println(max);
		System.out.println(min);

		br.close();
	}

}
