package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BOJ_2810_컵홀더 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		ArrayList<Character> seat = new ArrayList<Character>();

		boolean flag = false;
		for (int i = 0; i < N; i++) { // 좌석 정보 입력받으면서 왼쪽 컵홀더 개수 세기
			if (input[i] == 'S') {
				seat.add('*');
				seat.add('S');
			} else {
				if (flag == false) {
					seat.add('*');
					seat.add('L');
					flag = true;
				} else {
					seat.add('L');
					flag = false;
				}
			}
		}
		seat.add('*');

		boolean[] used = new boolean[seat.size()]; // 사용중 체크
		int answer = 0;
		for (int i = 0; i < seat.size(); i++) {
			if (seat.get(i) == 'S') {
				if (used[i - 1] == false) { // 왼쪽 컵홀더 비어있으면
					used[i - 1] = true;
					answer++;
				} else { // 오른쪽 컵홀더 비어있으면
					used[i + 1] = true;
					answer++;
				}
			} else if (seat.get(i) == 'L') {
				if (seat.get(i - 1) == '*' && used[i - 1] == false) {
					used[i - 1] = true;
					answer++;
				} else if (seat.get(i + 1) == '*' && used[i + 1] == false) {
					used[i + 1] = true;
					answer++;
				}
			}
		}

		System.out.println(answer);

	}

}
