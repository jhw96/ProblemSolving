package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1189_컴백홈 {

	static int R, C, K; // 세로, 가로, 거리
	static char[][] map;
	static int answer;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static void DFS(int step, int x, int y) {
		if (x == C && y == 1 && step == K) {
			answer++;
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nX = x+dx[i];
			int nY = y + dy[i];
			if(nX>=1 && nY>=1 && nX<=C && nY<=R) {
				if(!visited[nY][nX]&&map[nY][nX] != 'T') {
					visited[nY][nX] = true;
					DFS(step+1,nX,nY);
					visited[nY][nX] = false;
					
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];
		visited = new boolean[R + 1][C + 1];

		for (int y = 1; y <= R; y++) {
			String input = br.readLine();
			for (int x = 1; x <= C; x++) {
				map[y][x] = input.charAt(x - 1);
			}
		}

		DFS(1, 1, R);
		System.out.println(answer);

		br.close();
	}

}
