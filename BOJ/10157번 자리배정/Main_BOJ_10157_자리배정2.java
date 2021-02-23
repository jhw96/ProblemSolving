package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 런타임 에러 Stack Overflow
public class Main_BOJ_10157_자리배정2 { // 1,1부터 시작해서 반시계로 돌아가야함

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");

		int C = Integer.parseInt(st.nextToken()); // 행사장 가로길이
		int R = Integer.parseInt(st.nextToken()); // 행사장 세로길이

		int num = Integer.parseInt(br.readLine()); // 대기번호

		int sX = 1, sY = 0, dir = 0, count = 0, limit = 0;
		int waiting = 0;
		
		if(num > C*R) {
			System.out.println(0);
			System.exit(0);
		}

		while (true) {
			if (waiting == num) {
				System.out.println(sX + " " + sY);
				break;
			}

			if (dir == 0) { // 아래
				count++;
				sY++;
				waiting++;
				if (count == R - 2 * limit) {
					count = 0;
					dir++;
				}

			} else if (dir == 1) { // 오른쪽
				sX++;
				count++;
				waiting++;
				if (count == C - 1 - 2 * limit) {
					count = 0;
					dir++;
				}

			} else if (dir == 2) { // 위쪽
				sY--;
				count++;
				waiting++;
				if (count == R - 1 - 2 * limit) {
					count = 0;
					dir++;
					limit++;
				}

			} else if (dir == 3) { // 왼쪽
				sX--;
				count++;
				waiting++;
				if (count == C - 2 * limit) {
					count = 0;
					dir = 0;
				}

			}

		}

		br.close();
	}

}
