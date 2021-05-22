package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_13565_침투 {

	static int M, N;
	static int[][] map;
	static boolean flag = false;

	public static void invade(int x) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, 1 });

		while (!q.isEmpty()) {
			int[] top = q.poll();
			
			if(top[1] == M) { // 끝에 닿으면
				flag = true;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nX = top[0] + dx[i];
				int nY = top[1] + dy[i];

				if (nX >= 1 && nX <= N && nY>=1 && nY <= M && map[nY][nX] == 0) { // 방문하지않은 빈칸일 경우
					map[nY][nX] = 1;
					q.add(new int[] { nX, nY });
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken()); // 가로길이
		N = Integer.parseInt(st.nextToken()); // 세로길이

		map = new int[M + 1][N + 1];

		for (int y = 1; y <= M; y++) {
			String input = br.readLine();
			for (int x = 1; x <= N; x++)
				map[y][x] = input.charAt(x - 1) - '0';
		}

		for (int x = 1; x <= N; x++) {
			if (map[1][x] == 0) {
				map[1][x] = 1;
				invade(x);
			}
		}
		

		if(flag)
			System.out.println("YES");
		else
			System.out.println("NO");
		
		br.close();
	}

}
