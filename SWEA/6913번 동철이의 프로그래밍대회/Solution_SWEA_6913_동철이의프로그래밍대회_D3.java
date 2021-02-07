package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_6913_동철이의프로그래밍대회_D3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char result = ' ';

			int max = 0;
			int winCount = 0;
			
			for (int i = 0; i < N; i++) {
				int count = 0;
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					result = st.nextToken().charAt(0);
					if (result == '1')
						count++;
				}
				if(count > max) {
					max = count;
					winCount = 1;
				} else if(count == max) {
					winCount++;
				}
			}

			System.out.println("#" + tc + " " + winCount + " " + max);

		}

		br.close();
	}

}
