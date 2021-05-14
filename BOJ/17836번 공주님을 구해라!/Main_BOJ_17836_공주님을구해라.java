package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_17836_공주님을구해라 {

	static class Warrior { // 용자 클래스(좌표, 시간, 키 소지 여부)
		int x;
		int y;
		int depth;
		boolean key;

		public Warrior(int x, int y, int depth, boolean key) {
			this.x = x;
			this.y = y;
			this.depth = depth;
			this.key = key;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 세로 길이
		int M = Integer.parseInt(st.nextToken()); // 가로 길이
		int T = Integer.parseInt(st.nextToken()); // 제한 시간

		int[][] map = new int[N + 1][M + 1];

		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}

		// 미로 탐색 시작
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };
		int answer = -1;

		boolean[][][] visited = new boolean[N + 1][M + 1][2]; // 무기를 가진 상태와 안가진 상태
		Queue<Warrior> q = new LinkedList<Warrior>();

		if (map[1][1] == 2) { // 시작 지점에 전설의 무기가 있다면
			q.add(new Warrior(1, 1, 0, true));
			visited[1][1][1] = true;
		} else {
			q.add(new Warrior(1, 1, 0, false));
			visited[1][1][0] = true;
		}

		while (!q.isEmpty()) {
			Warrior top = q.poll();
//			System.out.println("키 존재 여부 : " + top.key);
//			System.out.println("현재 위치 : " + top.x + " , " + top.y + " 지난 시간 : " + top.depth);
			if (top.y == N && top.x == M) { // 끝 지점 도달
				answer = top.depth;
				break;
			}

			for (int dir = 0; dir < 4; dir++) {
				int nX = top.x + dx[dir];
				int nY = top.y + dy[dir];

				if (nY >= 1 && nX >= 1 && nY <= N && nX <= M) {
					if (top.depth < T) {
						if (top.key && !visited[nY][nX][1]) { // 전설의 무기가 있으면 아무데나 갈 수 있음
							q.add(new Warrior(nX, nY, top.depth + 1, true));
							visited[nY][nX][1] = true;
						} else if(!visited[nY][nX][0]) { // 전설의 무기가 없으면
							if (map[nY][nX] == 0) { // 빈칸이면
								q.add(new Warrior(nX, nY, top.depth + 1, false));
								visited[nY][nX][0] = true;
							} else if (map[nY][nX] == 2) { // 전설의 무기면 줍는다
//								System.out.println("무기 줍기 : " + nX + " , " + nY);
								q.add(new Warrior(nX, nY, top.depth + 1, true));
								visited[nY][nX][0] = true;
								visited[nY][nX][1] = true;
							}

						}
					}
				}
			}

		}

		if (answer == -1) // 구출 실패
			System.out.println("Fail");
		else
			System.out.println(answer);

		br.close();
	}

}
