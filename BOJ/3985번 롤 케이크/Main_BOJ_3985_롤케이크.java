package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_3985_롤케이크 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int L = Integer.parseInt(br.readLine()); // 롤케이크 길이
		int[] cake = new int[L + 1];
		int N = Integer.parseInt(br.readLine()); // 방청객의 수
		int[][] guest = new int[N + 1][2]; // 방청객이 제출한 케잌 번호

		int max = -1;
		int expectIndex = 0;
		
		int maxCount = -1;
		int realIndex = 0;

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			guest[i][0] = Integer.parseInt(st.nextToken());
			guest[i][1] = Integer.parseInt(st.nextToken());
			if (max < guest[i][1] - guest[i][0]) {
				max = guest[i][1] - guest[i][0];
				expectIndex = i;
			}
			int count = 0;
			for (int j = guest[i][0]; j <= guest[i][1]; j++) {
				if (cake[j] == 0) {
					cake[j] = i;
					count++;
				}
			}
			
			if(maxCount < count) {
				maxCount = count;
				realIndex = i;
			}
		}
		System.out.println(expectIndex);
		System.out.println(realIndex);

		br.close();
	}

}
