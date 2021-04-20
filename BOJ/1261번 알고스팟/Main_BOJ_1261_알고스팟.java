package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BOJ_1261_알고스팟 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int M = Integer.parseInt(st.nextToken()); // 가로길이
		int N = Integer.parseInt(st.nextToken()); // 세로길이

		// 상 하 좌 우
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		int[][] map = new int[N][M];
		int[][] dist = new int[N][M]; // 시작정점에서 해당 idx까지 가는데 걸리는 최소가중치
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);

		dist[0][0] = 0; // 시작점 초기화

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = input.charAt(j) - '0';
		}

		PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) { // 거리 더 짧은 애들을 위로
				return o1[2] - o2[2];
			}
		});

		q.add(new int[] { 0, 0, 0 });

		while (!q.isEmpty()) {
			int[] minInfo = q.poll();

			int sX = minInfo[0];
			int sY = minInfo[1];
			int minDist = minInfo[2];

			visited[sY][sX] = true;

			for (int i = 0; i < 4; i++) { // 사방탐색
				int nX = sX + dx[i];
				int nY = sY + dy[i];

				if (nX >= 0 && nY >= 0 && nX < M && nY < N) { // 범위 안이고
					if (!visited[nY][nX] && dist[nY][nX] > minDist + map[nY][nX]) {
						// 방문하지 않았고, 출발 정점에서 다음으로 가는것보다 현재를 경유해서 다음으로 가는 것이 더 작은경우
						dist[nY][nX] = minDist + map[nY][nX];
						q.add(new int[] { nX, nY, dist[nY][nX] });
					}
				}
			}

		}
		
		System.out.println(dist[N-1][M-1]);

		br.close();
	}

}
