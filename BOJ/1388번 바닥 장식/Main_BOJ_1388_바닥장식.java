package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_1388_바닥장식 {

	static int N, M; // 세로크기, 가로크기
	static boolean[][] visited;
	static char[][] map;
	static int answer;

	static int[] dx = { 1, 0 }; // 우 하
	static int[] dy = { 0, 1 }; // 우 하

	private static void countingBoard(int x, int y, int dir, int cnt) {

		int nX = x + dx[dir];
		int nY = y + dy[dir];

		if (nX <= M && nY <= N && !visited[nY][nX]) {
			if ((dir == 0 && map[nY][nX] == '-') || (dir == 1 && map[nY][nX] == '|')) {// 다음 판자 세기
				visited[nY][nX] = true;
				countingBoard(nX, nY, dir, cnt + 1);
			} else // 다음 판자 불가능할 경우, 끝내기
				answer++;
		} else {
			answer++;
		}
	} // end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1][M + 1];
		map = new char[N + 1][M + 1];

		for (int y = 1; y <= N; y++) {
			String input = br.readLine();
			for (int x = 1; x <= M; x++)
				map[y][x] = input.charAt(x - 1);
		}

		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= M; x++) {
				if (!visited[y][x]) {
					visited[y][x] = true;
					System.out.println("x : " + x + " y : " + y + " 모양 : " + map[y][x]);
					if (map[y][x] == '-')
						countingBoard(x, y, 0, 1);
					else
						countingBoard(x, y, 1, 1);
				}
			}
		}

		System.out.println(answer);

		br.close();
	}

}
