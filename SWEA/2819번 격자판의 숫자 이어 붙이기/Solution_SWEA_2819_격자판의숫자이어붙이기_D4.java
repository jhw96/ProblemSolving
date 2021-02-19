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

		str += map[x][y];
		if (x > 0)
			DFS(str, x - 1, y);
		if (y > 0)
			DFS(str, x, y - 1);
		if (y < 3)
			DFS(str, x, y + 1);
		if (x < 3)
			DFS(str, x + 1, y);

		str = str.substring(0, str.length() - 1);

		return;
	}
}