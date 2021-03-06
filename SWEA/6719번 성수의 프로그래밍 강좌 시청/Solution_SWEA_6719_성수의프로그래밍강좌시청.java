package com.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_6719_성수의프로그래밍강좌시청 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder().append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 강좌의 개수
			int K = Integer.parseInt(st.nextToken());

			int[] choice = new int[K]; // 들을 강좌 선택하기

			int[] lectures = new int[N]; // 강좌
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; i++)
				lectures[i] = Integer.parseInt(st.nextToken());

			for (int i = 0; i < K; i++) {
				int maxValue = 0, maxIdx = 0;
				for (int j = 0; j < N; j++) {
					if (maxValue < lectures[j]) {
						maxValue = lectures[j];
						maxIdx = j;
					}
				}
				choice[i] = maxValue;
				lectures[maxIdx] = -1;
			}

			double result = 0;

			for (int i = K - 1; i >= 0; i--) {
				result = (result + choice[i]) / 2;
			}

			sb.append(result);
			bw.write(sb.toString() + "\n");
			bw.flush();

		}

		br.close();
	}

}
