package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_2667_단지번호붙이기 {

	static int N; // 지도크기
	static int[][] map; // 지도

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static boolean[][] visited; // 방문여부
	static ArrayList<Integer> houseCnt = new ArrayList<Integer>(); // 집 개수

	private static int BFS(int x, int y) { // 현재 단지를 탐색하면서 집의 개수를 반환하는 함수
		int cnt = 1;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y });
		visited[y][x] = true;

		while (!q.isEmpty()) {
			int[] top = q.poll();
			int sX = top[0];
			int sY = top[1];

			for (int dir = 0; dir < 4; dir++) { // 상 하 좌 우 탐색
				int nX = sX + dx[dir];
				int nY = sY + dy[dir];
				if (nX >= 1 && nX <= N && nY >= 1 && nY <= N) { // 맵의 범위 안에 있으며
					if (!visited[nY][nX] && map[nY][nX] == 1) {
						q.add(new int[] { nX, nY });
						visited[nY][nX] = true;
						cnt++;
					}
				}
			}
		}
		
		return cnt;
	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];

		for (int y = 1; y <= N; y++) {
			String input = br.readLine();
			for (int x = 1; x <= N; x++)
				map[y][x] = input.charAt(x - 1) - '0';
		}

		// 전체 탐색
		for (int y = 1; y <= N; y++) {
			for (int x = 1; x <= N; x++) {
				if (!visited[y][x] && map[y][x] == 1) // 집이 있으며 아직 방문하지 않은 단지일 경우
					houseCnt.add(BFS(x, y));
			}
		}

		System.out.println(houseCnt.size()); // 단지 개수 반환
		Collections.sort(houseCnt); // 오름차순으로 정렬하기
		for (int i = 0; i < houseCnt.size(); i++)
			System.out.println(houseCnt.get(i));

		br.close();
	}

}
