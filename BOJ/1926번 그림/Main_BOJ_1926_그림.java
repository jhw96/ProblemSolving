package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1926_그림 {

	static int paintCnt = 0;
	static int maxArea = 0;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int n,m;
	static int callCnt;

	public static void DFS(int x, int y, int[][] map, boolean[][] visited) {
		visited[y][x] = true;
		callCnt++;
		if(callCnt > maxArea)
			maxArea = callCnt;

		for (int i = 0; i < 4; i++) {
			int nX = x + dx[i];
			int nY = y + dy[i];
			if (nX >= 1 && nY >= 1 && nX <= m && nY <= n) {
				if(map[nY][nX] == 1 && !visited[nY][nX]) {
					DFS(nX,nY,map,visited);
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken()); // 세로길이
		m = Integer.parseInt(st.nextToken()); // 가로길이

		int[][] map = new int[n + 1][m + 1];

		for (int y = 1; y <= n; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= m; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] visited = new boolean[n + 1][m + 1];

		for (int y = 1; y <= n; y++) {
			for (int x = 1; x <= m; x++) {
				if (map[y][x] == 1 && !visited[y][x]) {
					callCnt=0;
					paintCnt++;
					
					DFS(x, y, map, visited);
				}
			}
		}
		
		System.out.println(paintCnt);
		System.out.println(maxArea);

		br.close();
	}

}
