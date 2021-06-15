package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_13908_비밀번호 {

	static int n, m; // 비밀번호의 길이, 비밀번호에 들어가는 수
	static int[] must; // 꼭 들어가야하는 수
	static int answer;

	private static void search(int step, int[] cnt, String res) {
		if (step == n) {
			for (int i = 0; i < m; i++) {
				if (cnt[must[i]] < 1)
					return;
			}

			answer++;

			return;
		}

		for (int i = 0; i < 10; i++) {
			cnt[i]+=1;
			search(step + 1, cnt, res + String.valueOf(i));
			cnt[i]-=1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			if (i == 0) {
				n = Integer.parseInt(st.nextToken());
				m = Integer.parseInt(st.nextToken());
				must = new int[m];
			} else {
				for (int j = 0; j < m; j++)
					must[j] = Integer.parseInt(st.nextToken());
			}
		}
		

		search(0, new int[10], "");
		System.out.println(answer);

		br.close();
	}

}
