package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_26169_세번이내에사과를먹자 {

	static int[][] map = new int[5][5];
	static boolean[][] visited = new boolean[5][5];

	static int r, c; // r : 행번호 , c : 열번호
	static boolean findApple;

	static int[] dx = { 0, 0, -1, 1 }; // 상 하 좌 우
	static int[] dy = { -1, 1, 0, 0 }; // 상 하 좌 우

	private static void DFS(int x, int y, int cnt, int apple) {
		visited[y][x] = true;
		
		if (cnt <= 3 && apple >=2 ) {
			findApple = true;
			return;
		}

		if(cnt >= 3 && apple < 2) {
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nX = x + dx[d];
			int nY = y + dy[d];

			if (nX >= 0 && nX < 5 && nY >= 0 && nY < 5) {
				if (!visited[nY][nX] && map[nY][nX] != -1) {

					if (map[nY][nX] == 0)
						DFS(nX, nY, cnt + 1, apple);
					else if (map[nY][nX] == 1)
						DFS(nX, nY, cnt + 1, apple + 1);

					visited[nY][nX] = false;
				}
			}

		}

	} // DFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		for (int y = 0; y < 5; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 0; x < 5; x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		if (map[r][c] == 1) // 사과 있는 칸이면
			DFS(c, r, 0, 1);
		else // 사과 없는 칸이면
			DFS(c, r, 0, 0);

		if (findApple)
			System.out.println(1);
		else
			System.out.println(0);

		br.close();
	} // main end

}
