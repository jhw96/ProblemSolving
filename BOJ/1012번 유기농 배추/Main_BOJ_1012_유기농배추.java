/*
 * 배추가 난 곳은 1로 표시되며, 해충으로부터 보호받기 위해 배추흰지렁이가 필요한데,
 * 한 마리라도 있으면 상하좌우로 인접한 곳을 보호한다.
 * 위치상 인접한 것들을 한 덩어리로 생각하고 풀면 됨 
 */

package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_1012_유기농배추 {

	static int[] dx = { 0, 0, -1, 1 }; // 방향 전환
	static int[] dy = { -1, 1, 0, 0 };

	static int M, N; // 맵의 가로길이, 세로길이
	static int[][] map; // 배추재배하는 땅
	static boolean[][] visited; // 방문여부

	private static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		visited[y][x] = true;

		while (!q.isEmpty()) { // (x,y) 좌표에서 방문할 수 있는 인접한 배추들 모두 방문
			int[] top = q.poll();
			int sX = top[0];
			int sY = top[1];

			for (int dir = 0; dir < 4; dir++) {
				int nX = sX + dx[dir];
				int nY = sY + dy[dir];
				if (nX >= 0 && nX < M && nY >= 0 && nY < N) {
					if (!visited[nY][nX] && map[nY][nX] == 1) {
						q.add(new int[] { nX, nY });
						visited[nY][nX] = true;
					}
				}

			}
		}
	} // BFS end

	private static int countBugs() {
		int cnt = 0;

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (!visited[y][x] && map[y][x] == 1) { // 아직 보지못한 배추면
					cnt++;
					BFS(x, y);
				}
			}
		}

		return cnt;
	} // countBugs end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 입력

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken()); // 배추 개수

			map = new int[N][M];
			visited = new boolean[N][M];

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[y][x] = 1;
			}

			System.out.println(countBugs());

		}

		br.close();
	}

}
