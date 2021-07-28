package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_15558_점프게임 {

	static int N, K; // 총 길이, 건너편으로 건널때
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1 };
	static boolean flag;
	static Queue<int[]> q = new LinkedList<int[]>();

	private static void BFS() {
		int size = q.size();

		for (int i = 0; i < size; i++) {
			int[] top = q.poll();
			int line = top[0];
			int cord = top[1];
			
			if(map[line][cord]==2)
				continue;
			
			
			{
				int nextL = line == 1 ? 0 : 1;
				int next = cord + K;
				if (next < N && !visited[nextL][next] && map[nextL][next] == 1) {
					visited[nextL][next] = true;
					q.add(new int[] { nextL, next });
				} else if (next >= N) {
					if (next == N && map[nextL][next] == 1) {
						flag = true;
						return;
					} else if(next > N) {
						flag = true;
						return;
					}
				}
			}

			for (int j = 0; j < 2; j++) {
				int next = cord + dx[j];
				if (next < N && !visited[line][next] && map[line][next] == 1) {
					visited[line][next] = true;
					q.add(new int[] { line, next });
				} else if (next >= N) {
					if (next == N && map[line][next] == 1) {
						flag = true;
						return;
					} else if(next > N) {
						flag = true;
						return;
					}
				}
			}
		}

	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[2][N + 1];
		visited = new boolean[2][N + 1];

		for (int i = 0; i < 2; i++) {
			String input = br.readLine();
			for (int j = 1; j <= N; j++)
				map[i][j] = input.charAt(j - 1) - '0';
		}

		q.add(new int[] { 0, 1 });
		visited[0][1] = true;

		for (int time = 1; time <= N; time++) {

			BFS();

			if (flag) {
				System.out.println(1);
				return;
			}

			map[0][time] = 2;
			map[1][time] = 2;
		}

		System.out.println(0);

		br.close();
	}

}
