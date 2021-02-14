package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_SWEA_7699_수지의수지맞는여행_D4 {
	// 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static char[][] map;
	static boolean[][] visit;
	static int max, R, C;
	static HashMap<Character, Integer> check = new HashMap<Character, Integer>();

	public static void DFS(int beforeX, int beforeY, int cnt) {
		check.put(map[beforeY][beforeX], 1);

		if (cnt > max)
			max = cnt;

		for (int i = 0; i < 4; i++) {
			int nextX = beforeX + dx[i];
			int nextY = beforeY + dy[i];

			if (nextX >= 1 && nextX <= C && nextY >= 1 && nextY <= R)
				if (!check.containsKey(map[nextY][nextX]))
					DFS(nextX, nextY, cnt + 1);
		}
		check.remove(map[beforeY][beforeX]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder().append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken()); // 행크기
			C = Integer.parseInt(st.nextToken()); // 열크기
			max = 0;
			map = new char[R + 1][C + 1];
			for (int i = 1; i <= R; i++) {
				String input = br.readLine();
				for (int j = 1; j <= C; j++)
					map[i][j] = input.charAt(j - 1);
			}

			DFS(1, 1, 1); // 1행 1열에서 count 1 시작
			check.clear();
			sb.append(max);
			System.out.println(sb);
		}

		br.close();
	} // main end

} // class end
