package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_1325_효율적인해킹 {

	static ArrayList<Integer>[] computer = (ArrayList<Integer>[]) new ArrayList[10001];
	static int N, M, maxCnt;
	static int[] visit = new int[10001];
	static int[] answer = new int[10001];

	static void DFS(int num) {
		visit[num] = 1;
		for (int next : computer[num]) {
			if (visit[next] == 1)
				continue;
			answer[next]++;
			DFS(next);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++)
			computer[i] = new ArrayList<>();

		for (int i = 1; i <= M; i++) { // x가 y를 신뢰한다. -> y를 해킹하면 x도 해킹할 수 있다. 
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			computer[x].add(y);
		}
		
			
		maxCnt = 0;

		for (int i = 1; i <= N; i++) {
			Arrays.fill(visit, 0);
			DFS(i);
		}
		
		for (int i = 1; i <= N; i++)
			maxCnt = Math.max(maxCnt, answer[i]);

		for (int i = 1; i <= N; i++) {
			if (answer[i] == maxCnt)
				System.out.print(i + " ");
		}
	}

}
