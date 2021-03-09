package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_BOJ_2210_숫자판점프 {

	static HashSet<String> ans = new HashSet<String>();

	public static void DFS(int sX, int sY, char[][] map, int cnt, String res) {
		if (cnt == 6) {
			ans.add(res);
			return;
		}
		// 상 하 좌 우
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		for (int i = 0; i < 4; i++) {
			int nY = sY + dy[i];
			int nX = sX + dx[i];
			if (nY >= 0 && nX >= 0 && nX <= 4 && nY <= 4)
				DFS(nX, nY, map, cnt + 1, res + map[sY][sX]);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[][] map = new char[5][5];

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++)
				map[i][j] = st.nextToken().charAt(0);
		}

		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 5; x++)
				DFS(x, y, map, 0, "");
		}
		bw.write(ans.size() + "\n");

		bw.flush();
		br.close();
		bw.close();
	}

}
