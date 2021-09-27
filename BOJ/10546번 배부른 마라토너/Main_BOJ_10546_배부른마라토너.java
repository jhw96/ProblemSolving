package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_BOJ_10546_배부른마라토너 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Map<String, Integer> participant = new HashMap<String, Integer>(); // 참여자

		for (int i = 0; i < N; i++) { // 마라톤에 참여한 인원
			String name = br.readLine();
			int cnt = participant.getOrDefault(name, 0);
			participant.put(name, cnt + 1);
		}

		for (int i = 0; i < N - 1; i++) { // 완주한 인원 (동명이인 존재 가능)
			String name = br.readLine();
			int cnt = participant.get(name);
			participant.put(name, cnt - 1);
		}

		for (String name : participant.keySet()) { // 완주한 인원으로 체크 안된 친구 찾기
			if (participant.get(name) != 0) {
				System.out.println(name);
				break;
			}
		}

		br.close();
	}

}
