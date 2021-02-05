package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_1860_진기의최고급붕어빵_D3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();

			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // N 명의 손님
			int M = Integer.parseInt(st.nextToken()); // M초마다
			int K = Integer.parseInt(st.nextToken()); // K개의 붕어빵을 만듬
			int flowTime = 0; // 시간 흐름
			int fishBread = 0;
			int[] people = new int[N];
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; i++) { // 손님 오는 시간
				people[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(people);
			int index = 0;

			while (true) {
				if ((flowTime % M == 0) && flowTime != 0) {// M초마다 K개 붕어빵 만들기
					System.out.println(M+"초 마다 만들기로 했는데 현재 " + flowTime);
					System.out.println(K + " 개의 붕어빵만들기");
					fishBread += K;
				}

				if (flowTime == people[index]) { // 손님오는 시간이면
					int count = 1;

					while (true) { // 같은 시간에 오는 손님 세기
						if (index >= N - 1)
							break;
						if (people[index] != people[index + 1]) 
							break;
						
						index++;
						count++;
					}
					System.out.println("시간의 흐름 "+ flowTime);
					System.out.println("붕어빵 : "+fishBread + " - "  + count );
					fishBread -= count;
					if (fishBread < 0) { // 손님에게 줄수없으면
						sb.append("Impossible");
						break;
					}

					index++;
				} // if end
				if (index >= N) {
					sb.append("Possible");
					break;
				}
				flowTime++;
			} // while end

			System.out.println(sb);
			System.out.println("===============");
		} // test case end

		br.close();
	} // main end
} // class end
