/*
 * 돌 위에 적혀있는 숫자만큼 왼쪽이나 오른쪽으로 점프가능
 * 출발점을 받아서 시작하는 BFS 문제풀이
 */

package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_14248_점프점프 {

	static int n; // 돌의 개수
	static int[] jump; // 점프가능 돌의 개수
	static boolean[] visited;
	static int start; // 출발 돌의 위치
	static int answer;

	private static void BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = true;
		answer = 1;

		while (!q.isEmpty()) {
			int top = q.poll();
			int jumpNum = jump[top]; // 스킵가능한 돌의 수

			if (top + jumpNum <= n) { // 오른쪽으로 점프했을 때
				int next = top + jumpNum;
				if (!visited[next]) { // 아직 밟지않은 돌이면
					q.add(next);
					visited[next] = true;
					answer++;
				}

			}

			if (top - jumpNum >= 1) { // 왼쪽으로 점프했을 때
				int next = top - jumpNum;
				if (!visited[next]) { // 아직 밟지않은 돌이면
					q.add(next);
					visited[next] = true;
					answer++;
				}
			}
		}

	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		jump = new int[n + 1];
		visited = new boolean[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++)
			jump[i] = Integer.parseInt(st.nextToken());

		start = Integer.parseInt(br.readLine());

		BFS();

		System.out.println(answer);
		br.close();
	}

}
