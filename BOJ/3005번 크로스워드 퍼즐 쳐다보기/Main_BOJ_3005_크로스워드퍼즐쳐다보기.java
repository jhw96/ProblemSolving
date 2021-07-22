package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BOJ_3005_크로스워드퍼즐쳐다보기 {

	static int R, C; // 세로, 가로
	static char[][] map;
	static ArrayList<String> words = new ArrayList<String>();
	static boolean[][][] visited;
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };

	private static void DFS(int x, int y, int read, String res) {
		if (read == 0) {
			visited[0][y][x] = true;
		} else {
			visited[1][y][x] = true;
		}
		int nX = x + dx[read];
		int nY = y + dy[read];

		if (nX >= 1 && nY >= 1 && nX <= C && nY <= R) {
			if (!visited[read][nY][nX] && map[nY][nX] != '#') {
				visited[read][nY][nX] = true;
				DFS(nX, nY, read, res + map[y][x]);
			} else if (map[nY][nX] == '#') {
				String now = res + map[y][x];
				if (now.length() >= 2) {
					words.add(now);
				}

			}
		} else {
			String now = res + map[y][x];
			if (now.length() >= 2) {
				words.add(now);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];
		visited = new boolean[2][R + 1][C + 1];

		for (int y = 1; y <= R; y++) {
			String input = br.readLine();
			for (int x = 1; x <= C; x++)
				map[y][x] = input.charAt(x - 1);
		}

		for (int y = 1; y <= R; y++) { // 세로로 단어 읽어보기
			for (int x = 1; x <= C; x++) {
				if (!visited[0][y][x] && map[y][x] != '#') {
					DFS(x, y, 0, "");
				}
			}
		}

		for (int x = 1; x <= C; x++) {
			for (int y = 1; y <= R; y++) {
				if (!visited[1][y][x] && map[y][x] != '#') {
					DFS(x, y, 1, "");
				}
			}
		}

		Collections.sort(words);
		System.out.println(words.get(0));

		br.close();
	}

}
