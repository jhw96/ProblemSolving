package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_10451_순열사이클 {

	static int N; // 순열의 길이
	static int[] arr; // 순열
	static boolean[] visited; // 체크여부

	private static void visit(int start) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(start); // 시작 인덱스
		visited[start] = true;

		while (!q.isEmpty()) {
			int top = q.poll();
			int next = arr[top];
			
			if(next==start)
				return;
			
			if(!visited[next]) {
				visited[next] = true;
				q.add(next);
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 1];
			visited = new boolean[N + 1];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int answer = 0;

			for (int i = 1; i <= N; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= N; i++) {
				if (!visited[i]) {
					visit(i);
					answer++;
				}
			}

			bw.write(answer + "\n");
			bw.flush();
		}

		bw.close();
		br.close();
	}

}
