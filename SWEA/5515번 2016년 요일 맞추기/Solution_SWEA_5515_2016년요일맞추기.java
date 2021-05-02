package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5515_2016년요일맞추기 {

	public static void main(String[] args) throws Exception {

		// 1월 : 31, 2월 : 29일 , 3월 : 31일, 4월 : 30 , 5: 31, 6: 30, 7: 31, 8: 31, 9:30, 10:
		// 31, 11: 30 , 12:31
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 각
		int[] days = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		// 1월 1일은 금요일
		// 월 : 0 / 화 : 1 / 수 : 2 / 목 : 3 / 금 : 4 / 토 : 5 / 일 : 6
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int month = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());
			int answer = 0;

			int mDiff = month - 1; // 월 차이

			int sum = -1; // 1월1일부터 차이나는 총 날짜(단 1월 1일은 제외)

			for (int i = 0; i < mDiff; i++) { // 해당 달 전까지 총 차이나는 날짜 더하기
				sum += days[i];
			}

			sum += day; // 해당 달의 날짜만큼 더해주기

			sum %= 7;

			if (sum == 0)
				answer = 4;
			else if (sum == 1)
				answer = 5;
			else if (sum == 2)
				answer = 6;
			else if (sum == 3)
				answer = 0;
			else if (sum == 4)
				answer = 1;
			else if (sum == 5)
				answer = 2;
			else if (sum == 6)
				answer = 3;

			System.out.println("#" + tc + " " + answer);
		}

		br.close();
	}

}
