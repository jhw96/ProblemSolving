package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1219_길찾기 {

	static int answer = 0;

	public static void BFS(int[][] link) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[100];
		q.add(0);
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int top = q.poll();
			
			for(int i=0; i<100; i++) {
				if(link[top][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
			
		}

		

		if (visited[99] == true)
			answer = 1;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int t = Integer.parseInt(st.nextToken()); // 테스트케이스 번호
			int n = Integer.parseInt(st.nextToken()); // 길의 총 개수

			int[][] link = new int[100][100];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				// index 번 정점에서 저장한 값 번호의 정점으로 가는 것

				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				link[start][end] = 1;

			}

			BFS(link);

			StringBuilder sb = new StringBuilder().append("#").append(tc).append(" ").append(answer);
			System.out.println(sb.toString());
		}

		br.close();
	}

}
