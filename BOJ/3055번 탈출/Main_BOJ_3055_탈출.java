package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_3055_탈출 {
	static int R, C; // 세로, 가로
	static char[][] map;
	static boolean flag;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static ArrayList<int[]> waters = new ArrayList<int[]>(); // 물의 위치
	static ArrayList<int[]> place = new ArrayList<int[]>(); // 고슴도치 위치

	public static void moveWater() {
		Queue<int[]> q = new LinkedList<int[]>();

		for (int i = 0; i < waters.size(); i++) {
			q.add(waters.get(i));
		}

		waters.clear();

		while (!q.isEmpty()) {
			int[] top = q.poll();

			for (int i = 0; i < 4; i++) {
				int nX = top[0] + dx[i];
				int nY = top[1] + dy[i];

				if (nX >= 1 && nX <= C && nY >= 1 && nY <= R) {
					if (map[nY][nX] == '.' || map[nY][nX] == 'S') {
						waters.add(new int[] { nX, nY });
						map[nY][nX] = '*';
					}
				}
			}
		}

	} // moveWater end

	public static void move() {
		Queue<int[]> q = new LinkedList<int[]>();

		for (int i = 0; i < place.size(); i++) {
			q.add(place.get(i));
		}

		place.clear();

		while (!q.isEmpty()) {
			int[] top = q.poll();

			for (int i = 0; i < 4; i++) {
				int nX = top[0] + dx[i];
				int nY = top[1] + dy[i];

				if (nX >= 1 && nX <= C && nY >= 1 && nY <= R) {
					if (map[nY][nX] == '.') {
						place.add(new int[] { nX, nY });
						map[nY][nX] = 'S';
					} else if (map[nY][nX] == 'D') { // 비버굴 찾으면
						flag = true;
						break;
					}
				}
			}

		}

	} // move end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R + 1][C + 1];

		for (int y = 1; y <= R; y++) {
			String input = br.readLine();
			for (int x = 1; x <= C; x++) {
				map[y][x] = input.charAt(x - 1);
				if (map[y][x] == 'S') { // 고슴도치 위치 기억하기
					place.add(new int[] { x, y });
				} else if (map[y][x] == '*') { // 물 위치 기억하기
					waters.add(new int[] { x, y });
				}
			}
		}
		int answer = 0;
		while (true) {
			answer++;
			moveWater();
			move();
			
//			for(int y=1; y<=R; y++)
//				System.out.println(Arrays.toString(map[y]));
//			System.out.println();
			
			if (flag)
				break;
			if(place.size() == 0) {
				break;
			}
		}
		
		if(flag) // 탈출 성공 시
			System.out.println(answer);
		else
			System.out.println("KAKTUS");
		
		br.close();
	}

}
