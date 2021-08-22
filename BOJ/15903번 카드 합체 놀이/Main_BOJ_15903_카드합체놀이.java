package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_15903_카드합체놀이 {

	static int n, m; // 카드 개수, 합체 횟수
	static long[] cards;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		cards = new long[n];
		st = new StringTokenizer(br.readLine(), " ");

		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			pq.add(cards[i]);
		}

		for (int i = 0; i < m; i++) {
			long top1 = pq.poll();
			long top2 = pq.poll();

			long result = top1 + top2;
			pq.add(result);
			pq.add(result);
		}

		long answer = 0;
		while (!pq.isEmpty()) {
			answer += pq.poll();
		}
		System.out.println(answer);

		br.close();
	}

}
