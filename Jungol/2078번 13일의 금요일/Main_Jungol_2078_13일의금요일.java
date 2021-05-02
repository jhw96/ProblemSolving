package com.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_Jungol_2078_13일의금요일 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		// 1900년 1월 1일을 시작으로 N년동안 매 달 13번째 날의 요일을 계산 (1900 + N-1 년 까지)
		// 월 ~ 일요일까지 몇번 나오는지 카운트
		int[] answer = new int[7]; // 0: 월 ~ 6 : 일
		int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int before = 5; // 1900년 1월 13일은 토요일

		answer[before] += 1;

		for (int year = 1900; year <= 1900 + N - 1; year++) { // N년 반복
			boolean flag = false;

			if (year % 4 == 0) {
				if (year % 100 != 0 || year % 400 == 0) {
					flag = true;
				}
			}
			if (flag) // 윤년
				days[2] = 29;
			else // 평년
				days[2] = 28;

			for (int month = 1; month <= 12; month++) {
				if (year == 1900 && month == 1) // 첫해는 위에서 계산했으므로 패스
					continue;

				int dayDiff = 0;

				if (month == 1)
					dayDiff = days[12];
				else
					dayDiff = days[month - 1]; // 지난달의 날짜만큼 차이남

				dayDiff %= 7;

				// 지난 달 13일 요일에서 현재 요일 계산하기
				before += dayDiff;
				before %= 7;
				answer[before]++;
			}

		}

		for (int day = 0; day < 7; day++)
			System.out.print(answer[day] + " ");

		br.close();
	}

}
