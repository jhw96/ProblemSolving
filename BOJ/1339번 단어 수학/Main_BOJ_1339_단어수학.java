package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1339_단어수학 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		String[] word = new String[N];
		int[] sum = new int[26];
		// 각 알파벳이 가지고 있는 값 ex) ABCDE + CDE -> (10000A + 1000B + 100C + 10D + 1E) + (100C
		// + 10D + 1E)

		for (int idx = 0; idx < N; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			word[idx] = st.nextToken();
			int length = word[idx].length();

			for (int j = 0; j < word[idx].length(); j++) {
				int now = word[idx].charAt(j) - 'A'; // 현재 알파벳을 숫자로 변경
				sum[now] += Math.pow(10, --length);
			}
		}
		Arrays.sort(sum); // 오름차순 정렬

		int answer = 0;
		int score = 9;
		for (int i = 25; i >= 0; i--) { // 오름차순이라 맨 뒤부터
			if (sum[i] == 0)
				break;
			answer += (sum[i] * (score--));
		}

		System.out.println(answer);

		br.close();
	}

}
