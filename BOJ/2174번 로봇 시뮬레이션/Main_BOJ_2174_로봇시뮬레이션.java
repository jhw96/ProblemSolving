package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_2174_로봇시뮬레이션 {

	static int[][] robots; // 로봇의 위치 및 방향
	static int[][] map;
	static int A, B;
	static int[][] command; // 명령을 내리는 로봇, 명령 횟수
	static char[] commandKind; // 명령의 종류

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	private static boolean moveRobot(int cIdx) { // 몇번째 명령인지 매개변수 받기
		int rIdx = command[cIdx][0]; // 명령을 수행할 로봇
		int cnt = command[cIdx][1]; // 명령 반복 횟수
		char rCommand = commandKind[cIdx]; // 수행할 명령

		// 명령을 받은 로봇의 초기 위치
		int sX = robots[rIdx][0];
		int sY = robots[rIdx][1];
		int dir = robots[rIdx][2];

		map[sY][sX] = 0;

		for (int i = 0; i < cnt; i++) {
			if (rCommand == 'L') { // 왼쪽으로 회전
				if (dir == 0)
					dir = 3;
				else
					dir--;
			} else if (rCommand == 'R') { // 오른쪽으로 회전
				if (dir == 3)
					dir = 0;
				else
					dir++;
			} else { // 앞으로 한칸 이동
				int nX = sX + dx[dir];
				int nY = sY + dy[dir];
				if (nX >= 1 && nX <= A && nY >= 1 && nY <= B) { // 맵의 범위 안일 경우
					if (map[nY][nX] != 0) {
						System.out.println("Robot " + rIdx + " crashes into robot " + map[nY][nX]);
						return false;
					}
					sX = nX;
					sY = nY;
				} else {
					System.out.println("Robot " + rIdx + " crashes into the wall");
					return false;
				}

			}
		}

		map[sY][sX] = rIdx;
		robots[rIdx][0] = sX;
		robots[rIdx][1] = sY;
		robots[rIdx][2] = dir;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		A = Integer.parseInt(st.nextToken()); // 가로길이
		B = Integer.parseInt(st.nextToken()); // 세로길이
		map = new int[B + 1][A + 1];

		st = new StringTokenizer(br.readLine(), " ");

		int cnt = Integer.parseInt(st.nextToken());
		int commandCnt = Integer.parseInt(st.nextToken());

		robots = new int[cnt + 1][3];

		for (int i = 1; i <= cnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			robots[i][0] = x;
			robots[i][1] = B - (y - 1);

			if (dir == 'N')
				robots[i][2] = 0;
			else if (dir == 'E')
				robots[i][2] = 1;
			else if (dir == 'S')
				robots[i][2] = 2;
			else if (dir == 'W')
				robots[i][2] = 3;

			map[B - (y - 1)][x] = i;
		}
		command = new int[commandCnt][2];
		commandKind = new char[commandCnt];

		boolean flag = true;
		for (int i = 0; i < commandCnt; i++) {
			for(int y=1; y<=B; y++)
				System.out.println(Arrays.toString(map[y]));
			System.out.println();
			
			st = new StringTokenizer(br.readLine(), " ");
			int idx = Integer.parseInt(st.nextToken());
			char cmd = st.nextToken().charAt(0);
			int cCnt = Integer.parseInt(st.nextToken());

			command[i][0] = idx;
			command[i][1] = cCnt;
			commandKind[i] = cmd;

			flag = moveRobot(i);
			if (!flag) {
				break;
			}
		}

		if (flag)
			System.out.println("OK");

		br.close();
	}

}
