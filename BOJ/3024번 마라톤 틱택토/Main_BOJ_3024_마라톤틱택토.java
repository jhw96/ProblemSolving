package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_3024_마라톤틱택토 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];

		// 하 우하 우 좌상
		int dx[] = { 0, 1, 1, 1 };
		int dy[] = { 1, 1, 0, -1 };

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++)
				map[i][j] = input.charAt(j);
		}
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (map[y][x] != '.') { // 빈칸이 아니면
					for (int dir = 0; dir < 4; dir++) { // 방향 탐색
						int cnt = 0;
						for (int i = 1; i < 3; i++) {
							int nY = y + i * dy[dir];
							int nX = x + i * dx[dir];
							if (nY >= 0 && nX >= 0 && nY < N && nX < N && map[y][x] == map[nY][nX]) { // 범위 안이면
								cnt++;
							}
						}
						if (cnt == 2) {
							System.out.println(map[y][x]);
							return;
						}
					}
				} // if end
			}
		}

	
		System.out.println("ongoing");

		br.close();
	}

}
