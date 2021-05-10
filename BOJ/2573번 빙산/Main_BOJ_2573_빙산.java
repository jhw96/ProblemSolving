package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_2573_빙산 {

	static int[][] map;
	static int[][] seaCnt;
	static int N, M;
	static int cnt;

	private static void melting(int x, int y) {
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };


		for (int dir = 0; dir < 4; dir++) {
			int nX = x + dx[dir];
			int nY = y + dy[dir];
			if (nX >= 1 && nY >= 1 && nX <= M && nY <= N) { // 맵 범위 안이면
				if (map[nY][nX] == 0) // 주변 바다 갯수 저장
					seaCnt[y][x]++;
			}
		}


	}

	private static void counting(int x, int y, boolean[][] visited) {
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y });
		visited[y][x] = true;

		while (!q.isEmpty()) {
			int[] top = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				int nX = top[0] + dx[dir];
				int nY = top[1] + dy[dir];

				if (nY >= 1 && nX >= 1 && nX <= M && nY <= N) {
					if (map[nY][nX] > 0 && !visited[nY][nX]) { // 방문하지 않은 빙하면
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
		N = Integer.parseInt(st.nextToken()); // 세로길이
		M = Integer.parseInt(st.nextToken()); // 가로길이

		map = new int[N + 1][M + 1];
		int year = 0;

		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= M; x++)
				map[y][x] = Integer.parseInt(st.nextToken());
		}

		while (cnt < 2) { // 빙하가 1덩이 일때 계속 돌기
			seaCnt = new int[N+1][M+1]; // 주변 바다칸 개수
			boolean[][] visited = new boolean[N + 1][M + 1]; // 방문여부
			cnt = 0;
			year++;

			for (int y = 1; y <= N; y++) { // 빙하 녹이기
				for (int x = 1; x <= M; x++) {
					if (map[y][x] > 0) // 빙하면
						melting(x, y);
				}
			}
			
			for(int y=1; y<=N; y++) {
				for(int x=1; x<=M; x++) {
					if(seaCnt[y][x] > 0) {
						map[y][x] -= seaCnt[y][x];
						if(map[y][x] < 0)
							map[y][x] = 0;
					}
				}
			}
			
//			for(int y=1; y<=N; y++)
//				System.out.println(Arrays.toString(map[y]));
//			System.out.println("===");

			for (int y = 1; y <= N; y++) { // 빙하 덩어리 세기
				for (int x = 1; x <= M; x++) {
					if (map[y][x] > 0 && !visited[y][x]) {
						cnt++;
						counting(x, y, visited);
					}
				}
			}
            
            if(cnt==0) {
                year = 0;
                break;
            }
                

		}

		System.out.println(year);

		br.close();
	}

}
