package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BOJ_7507_올림픽게임 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			int m = Integer.parseInt(br.readLine());
			int answer = 1;

			int[][] games = new int[m][3]; // 0: 경기의 날짜 , 1: 시작시간 , 2: 종료시간

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < 3; k++)
					games[j][k] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(games, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[0] != o2[0]) { // 경기의 날짜가 다르면
						return o1[0] - o2[0];
					} else { // 경기의 날짜가 같으면
						if (o1[2] != o2[2]) { // 경기의 종료시간이 다르면
							return o1[2] - o2[2];
						} else // 경기 종료시간이 같으면
							return o1[1] - o2[1];
					}
				}
			});

			// 첫번째 날 초반 설정
			int day = games[0][0];
			int end = games[0][2];

			// 현재 게임들 빠른 날짜, 빨리 종료되는 순으로 정리되어있음
			for (int j = 1; j < m; j++) {
//				System.out.println(Arrays.toString(games[j]));
				if (day == games[j][0]) { // 이전 게임과 같은 날짜면
					if (end <= games[j][1]) { // 이전 게임 종료시간과 같거나 크면
						answer++;
						end = games[j][2];
					} else
						continue;

				} else { // 이전 게임과 다른 날짜면
					day = games[j][0];
					end = games[j][2];
					answer++;
				}

			}

			System.out.println("Scenario #" + i + ":");
			System.out.println(answer);
		}

		br.close();
	}
}
