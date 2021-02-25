package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1948_날짜계산기_D2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int[] count = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder().append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int answer = 0;

			int[][] date = new int[2][2];
			for (int i = 0; i < 2; i++)
				for (int j = 0; j < 2; j++)
					date[i][j] = Integer.parseInt(st.nextToken());

			if (date[0][0] == date[1][0]) {
				int diff = date[1][1] - date[0][1];
				answer += (diff + 1);
			} else {
				answer += (count[date[0][0]] - date[0][1] + 1);
				for (int i = date[0][0] + 1; i < date[1][0]; i++) {
					answer += count[i];
				}
				answer += (date[1][1]);
			}
			sb.append(answer);
			System.out.println(sb.toString());

		} // 테케 end

		br.close();
	} // main end

} // class end
