package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2564_경비원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 블록의 가로길이
		int M = Integer.parseInt(st.nextToken()); // 블록의 세로길이
		int n = Integer.parseInt(br.readLine()); // 상점의 개수
		int[][] shop = new int[n][2]; // 맨 마지막은 동근이 위치
		int[] dong = new int[2];

		for (int i = 0; i < n; i++) { // 1: 북쪽 2: 남쪽 (왼쪽 경계로부터의 거리) 3: 서쪽 4: 동쪽 (위쪽 경계로부터의 거리)
			st = new StringTokenizer(br.readLine(), " ");
			shop[i][0] = Integer.parseInt(st.nextToken());
			shop[i][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " "); // 동근이의 위치
		dong[0] = Integer.parseInt(st.nextToken());
		dong[1] = Integer.parseInt(st.nextToken());

		int answer = 0, diff = 0;
		// 반대방향일때만 특별한 계산해주면 될 듯
		if (dong[0] == 1) { // 동근이가 북쪽
			for (int i = 0; i < n; i++) {
				switch (shop[i][0]) {
				case 1: // 북쪽
					diff = shop[i][1] - dong[1];
					answer += Math.abs(diff);
					break;
				case 2: // 남쪽
					int left = shop[i][1] + dong[1] + M;
					int right = N - shop[i][1] + N - dong[1] + M;
					answer += left > right ? right : left; // 더 작은애 넣어주기
					break;
				case 3: // 서쪽
					answer += dong[1];
					answer += shop[i][1];

					break;
				case 4: // 동쪽
					answer += N - dong[1];
					answer += shop[i][1];

					break;
				}
			}
		} else if (dong[0] == 2) { // 동근이가 남쪽
			for (int i = 0; i < n; i++) {
				switch (shop[i][0]) {
				case 1: // 북쪽
					int left = dong[1] + M + shop[i][1];
					int right = N - dong[1] + N - shop[i][1] + M;

					answer += left > right ? right : left;

					break;
				case 2: // 남쪽
					diff = shop[i][1] - dong[1];
					answer += Math.abs(diff);

					break;
				case 3: // 서쪽
					answer += dong[1];
					answer += (M - shop[i][1]);

					break;
				case 4: // 동쪽
					answer += (N - dong[1]);
					answer += (M - shop[i][1]);

					break;
				}
			}

		} else if (dong[0] == 3) { // 동근이가 서쪽
			for (int i = 0; i < n; i++) {
				switch (shop[i][0]) {
				case 1: // 북쪽
					answer += dong[1];
					answer += shop[i][1];

					break;
				case 2: // 남쪽
					answer += (M-dong[1]);
					answer += shop[i][1];

					break;
				case 3: // 서쪽
					diff = shop[i][1] - dong[1];
					answer += Math.abs(diff);
					
					break;
				case 4: // 동쪽
					int up = dong[1] + shop[i][1] + N;
					int down = M - dong[1] + M - shop[i][1] + N;
					
					answer += up > down ? down : up;

					break;
				}
			}

		} else { // 동근이가 동쪽
			for (int i = 0; i < n; i++) {
				switch (shop[i][0]) {
				case 1: // 북쪽
					answer += dong[1];
					answer += (N - shop[i][1]);

					break;
				case 2: // 남쪽
					answer += (M - dong[1]);
					answer += (N - shop[i][1]);

					break;
				case 3: // 서쪽
					int up = dong[1] + shop[i][1] + N;
					int down = M - dong[1] + M - shop[i][1] + N;

					answer += up > down ? down : up;

					break;
				case 4: // 동쪽
					diff = shop[i][1] - dong[1];
					answer += Math.abs(diff);

					break;
				}
			}

		}
		
		System.out.println(answer);

		br.close();
	} // main end
} // class end
