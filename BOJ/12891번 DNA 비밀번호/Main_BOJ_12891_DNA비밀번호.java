package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_12891_DNA비밀번호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int S = Integer.parseInt(st.nextToken()); // 전체 문자열 길이
		int P = Integer.parseInt(st.nextToken()); // 사용할 부분문자열 길이

		int[] need = new int[4]; // 순서대로 A C G T
		int[] status = new int[4]; // A C G T 현재 상황
		int answer = 0;

		String DNA = br.readLine();

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < 4; i++)
			need[i] = Integer.parseInt(st.nextToken());

		int left = 0, right = P - 1;

		for (int i = 0; i < P; i++) {
			char now = DNA.charAt(i);
			if (now == 'A')
				status[0]++;
			else if (now == 'C')
				status[1]++;
			else if (now == 'G')
				status[2]++;
			else
				status[3]++;
		}

		while (true) {
			System.out.println(Arrays.toString(status));
			
			boolean flag = true;
			for (int i = 0; i < 4; i++)
				if (status[i] < need[i]) {
					flag = false;
					break;
				}

			if (flag)
				answer++;

			right++;
			if (right == S)
				break;

			char next = DNA.charAt(right);

			if (next == 'A')
				status[0]++;
			else if (next == 'C')
				status[1]++;
			else if (next == 'G')
				status[2]++;
			else
				status[3]++;
			
			char before = DNA.charAt(left++);
			
			if (before == 'A')
				status[0]--;
			else if (before == 'C')
				status[1]--;
			else if (before == 'G')
				status[2]--;
			else
				status[3]--;
		}
		
		System.out.println(answer);
		
		br.close();
	}

}
