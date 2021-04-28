package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_17143_낚시왕 {

	static class shark implements Comparable<shark> {
		int x;
		int y;
		int s; // 속력
		int d; // 이동방향
		int z; // 상어 크기

		public shark(int x, int y, int s, int d, int z) {
			super();
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(shark o) { // 크기가 작은 애들이 앞으로
			return this.z - o.z;
		}

	}

	static int R, C, M;
	// 상 하 좌 우
	static int[] dx = { 0, 0, 0, 1, -1 };
	static int[] dy = { 0, -1, 1, 0, 0 };
	static shark[] sharks;
	static int[][] map;
	static boolean[] exist;
	static int c = 0;

	private static void moveShark() {
		int[][] clone = new int[R + 1][C + 1];

		for (int i = 1; i <= R; i++)
			Arrays.fill(clone[i], -1);

		for (int i = 0; i < M; i++) {
			if (exist[i]) { // 아직 살아있는 상어면
				int x = sharks[i].x;
				int y = sharks[i].y;
				int dir = sharks[i].d;
				int s = sharks[i].s;
				int z = sharks[i].z;

				for (int j = 0; j < s; j++) { // 상어 속력만큼 움직이기
					int nX = x + dx[dir];
					int nY = y + dy[dir];
//					if (i == 2)
//						System.out.println("X : " + nX + " Y : " + nY);
					x = nX;
					y = nY;
					if (nX < 1 || nY < 1 || nX > C || nY > R) { // 맵 범위를 벗어나면
						// 방향 바꿔주기
						dir = dir % 2 == 0 ? dir - 1 : dir + 1;
						x += 2*dx[dir];
						y += 2*dy[dir];
					}
				}
				if (clone[y][x] != -1) // 이미 작은 상어가 있었다면 죽음 처리
					exist[clone[y][x]] = false;
				clone[y][x] = i; // 더 큰 상어 덮어주기
				sharks[i].x = x;
				sharks[i].y = y;
				sharks[i].d = dir;
//				sharks[i] = new shark(x, y, s, dir, z); (시간초과)
			}
		}
//		c++;

		for (int y = 1; y <= R; y++) {
			for (int x = 1; x <= C; x++)
				map[y][x] = clone[y][x];
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken()); // 세로 길이
		C = Integer.parseInt(st.nextToken()); // 가로 길이
		M = Integer.parseInt(st.nextToken()); // 상어 수

		exist = new boolean[M];
		sharks = new shark[M];
		map = new int[R + 1][C + 1];

		for (int i = 1; i <= R; i++)
			Arrays.fill(map[i], -1);

		Arrays.fill(exist, true);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken()); // 속력
			int d = Integer.parseInt(st.nextToken()); // 방향
			int z = Integer.parseInt(st.nextToken()); // 크기
			sharks[i] = new shark(x, y, s, d, z);
		}

		Arrays.sort(sharks); // 크기가 작은애들부터 앞으로
		
		for (int i = 0; i < M; i++) {
			int x = sharks[i].x;
			int y = sharks[i].y;
			map[y][x] = i; // 맵에 상어 인덱스 표시
		}

		int answer = 0;

//		for (int i = 1; i <= R; i++)
//			System.out.println(Arrays.toString(map[i]));
//		System.out.println();

		for (int x = 1; x <= C; x++) { // 낚시시작
			for (int y = 1; y <= R; y++) { // 땅과 가까운 상어 잡기
				if (map[y][x] == -1)
					continue;

				exist[map[y][x]] = false;
				answer += sharks[map[y][x]].z; // 잡은 상어 크기
				map[y][x] = -1; // 잡은 상어 index 제외해주기
				break;
			}

			moveShark();
			
//			int cnt =0;
//			for(int i=0; i<M; i++) {
//				if(exist[i])
//					cnt++;
//			}
//			System.out.println("살아있는 상어 : " + cnt);
//
//			for (int i = 1; i <= R; i++)
//				System.out.println(Arrays.toString(map[i]));
//			System.out.println();
		}

		System.out.println(answer);

		br.close();
	}

}
