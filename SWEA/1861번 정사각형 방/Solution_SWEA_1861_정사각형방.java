package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_1861_정사각형방 {

	static int max, maxIdx;
	
	private static void BFS(int x, int y, int N, int[][] map) {

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y });
		int cnt = 1;
		

		while (!q.isEmpty()) {
			int[] top = q.poll();

			for (int i = 0; i < 4; i++) {
				int nX = top[0] + dx[i];
				int nY = top[1] + dy[i];

				if (nX >= 1 && nX <= N && nY >= 1 && nY <= N) {
					if (map[top[1]][top[0]] + 1 == map[nY][nX]) {
						q.add(new int[] {nX,nY});
						cnt++;
					}
				}

			}
		}
		
		if(cnt > max) {
			max = cnt;
			maxIdx = map[y][x];
		} else if(cnt==max && map[y][x] < maxIdx) {
			maxIdx = map[y][x];
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[][] map = new int[N + 1][N + 1];

			for (int y = 1; y <= N; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int x = 1; x <= N; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			max = -9999;
			maxIdx = 0;
			for (int y = 1; y <= N; y++) {
				for (int x = 1; x <= N; x++) {
					BFS(x, y, N, map);
				}
			}
			
			System.out.println("#" + tc + " " + maxIdx + " " + max);

		}

		br.close();
	}

}
