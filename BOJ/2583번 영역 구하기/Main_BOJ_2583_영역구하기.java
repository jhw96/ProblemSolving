package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2583_영역구하기 {

	static int M, N;
	static int[][] map;
	static boolean[][] visited;
	static int cnt = 0;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	private static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] top = q.poll();

			for (int i = 0; i < 4; i++) {
				int nX = top[0] + dx[i];
				int nY = top[1] + dy[i];

				if (nX >= 0 && nY >= 0 && nX < N && nY < M) {
					if (map[nY][nX] == 0 && !visited[nY][nX]) {
						cnt++;
						visited[nY][nX] = true;
						q.add(new int[] { nX, nY });
					}
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 세로 길이
		N = Integer.parseInt(st.nextToken()); // 가로 길이
		int K = Integer.parseInt(st.nextToken()); // 사각형의 개수

		map = new int[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < K; i++) { // 사각형 좌표 입력받기
			st = new StringTokenizer(br.readLine(), " ");

			int sX = Integer.parseInt(st.nextToken()); // 시작 좌표
			int sY = Integer.parseInt(st.nextToken());
			int eX = Integer.parseInt(st.nextToken()); // 끝 좌표
			int eY = Integer.parseInt(st.nextToken());

			for (int x = sX; x < eX; x++) {
				for (int y = sY; y < eY; y++) {
					map[y][x] = 1;
				}
			}
		}

		int squareCnt = 0;
		ArrayList<Integer> area = new ArrayList<Integer>(); // 사각형 넓이 저장 arraylist

		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				if (map[y][x] == 0 && !visited[y][x]) {
					cnt = 1;
					visited[y][x] = true;
					BFS(x, y);
					squareCnt++;
					area.add(cnt);
				}
			}
		}

		Collections.sort(area);

		for (int y = 0; y < M; y++)
			System.out.println(Arrays.toString(map[y]));

		System.out.println(squareCnt);
		for(int i=0; i<area.size(); i++)
			System.out.print(area.get(i) + " ");

		br.close();
	}

}
