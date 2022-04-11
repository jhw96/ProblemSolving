package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_13901_로봇 {

	static int R, C, k; // 세로크기, 가로크기, 장애물 개수

	static boolean[][] visited; // 방문여부
	static Queue<Robot> q = new LinkedList<Robot>();

	static int[] dx = { 0, 	0, 0, -1, 1 }; // 위 아 왼 오 (but 좌표가 위 아래로 반대)
	static int[] dy = { 0, 	-1, 1, 0, 0 };

	static int[] order = new int[4]; // 방향 순서
	static int idx; // 방향 인덱스

	static class Robot {
		int x;
		int y;

		Robot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	} // Robot end

	private static void move() {

		while (!q.isEmpty()) {
			Robot top = q.poll();

			// 현재 좌표
			int x = top.x;
			int y = top.y;
			

			int cnt = 0;
			boolean find = false;
			while (true) {
				cnt++;	// 횟수 세기
				int dir = order[idx];

				int nX = x + dx[dir];
				int nY = y + dy[dir];

				if (nX >= 0 && nX < C && nY >= 0 && nY < R) {	// 범위 안이고
					if (!visited[nY][nX]) {		// 이동할 수 있으면
						visited[nY][nX] = true;
						q.add(new Robot(nX, nY));
						find = true;
					}
				}


				if (find)	// 찾았으면 멈추기
					break;
				else {	 // 해당방향으로 갈 수 없다면 방향바꾸기
					idx = idx + 1 == 4 ? 0 : idx + 1;
				}
				
				if (cnt == 4) { // 이동할 수 없으면 출력 후 멈추기
					System.out.println(y + " " + x);
					break;
				}

			} // while end
		
		} // q end

	} // find end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		visited = new boolean[R][C];

		k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) { // 장애물 위치 입력받기
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			visited[y][x] = true;
		}

		st = new StringTokenizer(br.readLine(), " "); // 로봇 위치 입력받기
		int sY = Integer.parseInt(st.nextToken());
		int sX = Integer.parseInt(st.nextToken());

		visited[sY][sX] = true;
		q.add(new Robot(sX, sY));

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < 4; i++) // 방향 입력받기
			order[i] = Integer.parseInt(st.nextToken());

		move();

		br.close();
	} // main end

}
