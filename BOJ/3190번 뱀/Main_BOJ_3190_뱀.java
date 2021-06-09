package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_3190_뱀 {

	static int N, K; // 보드 크기, 사과 개수
	static int[][] map;
	static int[] snakeHead = new int[2]; // 뱀 머리 좌표
	static Queue<int[]> snakeBody = new LinkedList<int[]>(); // 뱀 몸통 좌표
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int dir = 0;
	static boolean die;

	private static void moveSnake() {
		int sX = snakeHead[0];
		int sY = snakeHead[1];

		int nX = sX + dx[dir];
		int nY = sY + dy[dir];

		if (nX >= 1 && nX <= N && nY >= 1 && nY <= N) {
			if (map[nY][nX] == 2) { // 뱀 머리가 몸통에 부딪히면 사망
				die = true;
				return;
			}
			snakeBody.add(new int[] { sX, sY });

			if (map[nY][nX] == 0) { // 사과가 없으면
				int[] tail = snakeBody.poll();
				int x = tail[0];
				int y = tail[1];
				map[y][x] = 0;
			}

			map[nY][nX] = 2;
			snakeHead[0] = nX;
			snakeHead[1] = nY;
		} else { // 뱀 머리가 보드판에 부딪히면 게임 끝
			die = true;
			return;
		}

	} // moveSnake end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			map[y][x] = 1;
		}

		int L = Integer.parseInt(br.readLine());

		// 뱀의 움직임 명령
		int[] time = new int[L]; // 움직일 시간
		char[] command = new char[L]; // 전환할 방향

		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());
			command[i] = st.nextToken().charAt(0);
		}

		snakeHead[0] = 1;
		snakeHead[1] = 1;
		map[1][1] = 2;

		int t = 0, tIdx = 0;
		while (true) {
			t++;
			moveSnake();

			if (tIdx < L)
				if (t == time[tIdx]) { // L : 왼쪽, D : 오른쪽
					char now = command[tIdx++];
					if (now == 'L') {
						dir++;
						if (dir > 3)
							dir = 0;

					} else if (now == 'D') {
						dir--;
						if (dir < 0)
							dir = 3;
					}
				}

			if (die)
				break;
		}

		System.out.println(t);

		br.close();
	}

}
