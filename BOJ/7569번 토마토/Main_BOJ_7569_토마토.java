package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_7569_토마토 {

	static int M, N, H; // 가로칸, 세로칸, 상자 높이
	static int[][][] box;
	static boolean[][][] visited;
	static ArrayList<int[]> tomato = new ArrayList<int[]>();
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static int[] updown = { -1, 1 };

	static int rottenCnt = 0; // 썩은 개수

	private static void spread() {

		Queue<int[]> q = new LinkedList<int[]>();

		for (int i = 0; i < tomato.size(); i++) {
			q.add(tomato.get(i));
		}

		tomato.clear();

		while (!q.isEmpty()) {
			int[] top = q.poll();
			int h = top[0];
			int x = top[1];
			int y = top[2];

			for (int i = 0; i < 4; i++) {
				int nX = x + dx[i];
				int nY = y + dy[i];
				if (nX >= 1 && nY >= 1 && nX <= M && nY <= N) {
					if (!visited[h][nY][nX] && box[h][nY][nX] == 0) {
						box[h][nY][nX] = 1;
						tomato.add(new int[] { h, nX, nY });
						rottenCnt++;
					}
				}
			}

			for (int i = 0; i < 2; i++) {
				int nH = h + updown[i];
				if (nH >= 1 && nH <= H) {
					if (!visited[nH][y][x] && box[nH][y][x] == 0) {
						box[nH][y][x] = 1;
						tomato.add(new int[] { nH, x, y });
						rottenCnt++;
					}
				}
			}

		}

	} // spread end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		box = new int[H + 1][N + 1][M + 1];
		visited = new boolean[H + 1][N + 1][M + 1];

		int normalCnt = 0;

		for (int h = 1; h <= H; h++) {
			for (int y = 1; y <= N; y++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int x = 1; x <= M; x++) {
					box[h][y][x] = Integer.parseInt(st.nextToken());
					if (box[h][y][x] == 1) {
						tomato.add(new int[] { h, x, y });
					} else if (box[h][y][x] == 0)
						normalCnt++;	
				}
			}
		}

		int size = tomato.size();
		int days = 0;

		while (true) {
			if(rottenCnt == normalCnt) {
				System.out.println(days);
				return;
			}
			days++;
			spread();
			size = tomato.size();
//			for(int h=1; h<=H; h++) {
//				for(int y=1; y<=N; y++) 
//					System.out.println(Arrays.toString(box[h][y]));
//			}
//			System.out.println();
			if (size == 0)
				break;
		}

//		if (normalCnt == rottenCnt)
//			System.out.println(days);
//		else
			System.out.println(-1);

		br.close();
	}

}
