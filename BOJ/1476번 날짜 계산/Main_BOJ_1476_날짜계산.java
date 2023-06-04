package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1476_날짜계산 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int e = 0, s = 0, m = 0;
		int ee = 0, ss = 0, mm = 0;

		for (int i = 0; i < 3; i++) {
			if (i == 0)
				ee = Integer.parseInt(st.nextToken());
			if (i == 1)
				ss = Integer.parseInt(st.nextToken());
			if (i == 2)
				mm = Integer.parseInt(st.nextToken());

		}

		int answer = 0;

		while (true) {
			if (e == ee && s == ss && m == mm)
				break;

			answer++;
			e++;
			s++;
			m++;

			if (e > 15)
				e = 1;
			if (s > 28)
				s = 1;
			if (m > 19)
				m = 1;

		}

		System.out.println(answer);

	}

}
