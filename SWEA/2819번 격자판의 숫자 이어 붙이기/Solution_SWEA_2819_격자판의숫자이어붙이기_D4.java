package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_SWEA_2819_격자판의숫자이어붙이기_D4 {
	static char[][] map = new char[4][4];
	static HashSet<String> hash = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}

			for (int y = 0; y < 4; y++) {
				for (int x = 0; x < 4; x++) {
					DFS("", x, y);
				}
			}
			System.out.println("#" + tc + " " + hash.size());
			hash.clear();
		}
	}

	public static void DFS(String str, int x, int y) {
		if (str.length() == 7) {
			hash.add(str);
			return;
		}
		// 상하좌우
		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };

		for (int i = 0; i < 4; i++) {
			int nY = y + dy[i];
			int nX = x + dx[i];
			if (nY >= 0 && nX >= 0 && nY < 4 && nX < 4)
				DFS(str + map[nY][nX], nX, nY);
		}

		return;
	}
}