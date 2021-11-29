package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BOJ_13414_수강신청 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int K = Integer.parseInt(st.nextToken()); // 수강 가능 인원
		int L = Integer.parseInt(st.nextToken()); // 대기 목록의 길이

		Map<String, Integer> check = new HashMap<>(); // 중복체크용

		String[] waiting = new String[L];
		boolean[] fair = new boolean[L];

		for (int i = 0; i < L; i++) {
			String stdNo = br.readLine(); // 학번
			if (!check.containsKey(stdNo)) { // 처음 신청이면
				check.put(stdNo, i);
			} else { // 이미 신청했었으면
				int idx = check.get(stdNo);
				check.put(stdNo, i);
				fair[idx] = false;
			}

			waiting[i] = stdNo;
			fair[i] = true;
		}

		int cnt = 0;
		for (int i = 0; i < L; i++) {
			if (fair[i]) {
				System.out.println(waiting[i]);
				cnt++;
			}
			if (cnt == K)
				break;
		}

		br.close();
	}

}
