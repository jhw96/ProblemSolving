package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3347_올림픽종목투표 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 올림픽 종목 개수
			int M = Integer.parseInt(st.nextToken()); // 조직위원회 사람 수

			int[] olympic = new int[N];
			int[] people = new int[M];
			int[] count = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++)
				olympic[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<M; i++)
				people[i] = Integer.parseInt(st.nextToken());
			

			for (int i = 0; i < people.length; i++) {

				for (int j = 0; j < olympic.length; j++) {
					if (people[i] >= olympic[j]) {
						count[j]++;
						break;
					}
				}
			}

			int max = -1;
			int maxIndex = 0;
			for (int i = 0; i < count.length; i++) {
				if (count[i] > max) {
					max = count[i];
					maxIndex = i;
				}
			}
			
			System.out.println("#"+tc+" " + (maxIndex+1));

		} // 테케 end

		br.close();
	} // main end

} // class end
