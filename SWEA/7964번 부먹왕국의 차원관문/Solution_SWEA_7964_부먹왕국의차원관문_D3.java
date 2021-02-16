package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
3
6 2
1 0 0 0 0 1
10 2
0 0 1 0 1 0 0 0 0 1
10 1
0 0 0 0 0 0 0 0 0 0
*/

public class Solution_SWEA_7964_부먹왕국의차원관문_D3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 도시의 수
			int D = Integer.parseInt(st.nextToken()); // 이동제한거리
			int[] cities = new int[N + 1];
			int answer = 0;

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 1; i <= N; i++) {
				cities[i] = Integer.parseInt(st.nextToken());
			}
			
			// 0번째와 N+1 번째에는 차원문이 설치되어있음
			int check = 0;
			for (int i = 1; i <= N; i++) { // 도시탐색
				check++;
				if (cities[i] == 1) {
					check = 0;
				}
				if (check % D == 0 && cities[i] == 0) {
					check = 0;
					cities[i] = 1;
					answer++;
				}
			}
			System.out.println("#" + tc + " " + answer);

		} // 테케 end

		br.close();
	} // main end
} // class end
