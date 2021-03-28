package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_5427_불 {

	static boolean flag = false;

	public static void move(char[][] map, boolean[][][] visited, int h, int w, int who, Queue<int[]> Sang) { // 상근이 움직이기
		// 상 하 좌 우
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		int size = Sang.size();

		for (int s = 0; s < size; s++) {
			int[] top = Sang.poll();

			for (int i = 0; i < 4; i++) {
				int nX = top[0] + dx[i];
				int nY = top[1] + dy[i];

				if (nY < 0 || nX < 0 || nX >= w || nY >= h) { // 범위 밖으로 나가면 탈출 성공
					flag = true;
					return;
				}

				if (nY >= 0 && nX >= 0 && nY < h && nX < w) { // 범위 안이고
					if (!visited[nY][nX][who] && map[nY][nX] == '.') { // 방문하지 않았고 빈칸이면 이동가능
						map[nY][nX] = '@';
						Sang.add(new int[] { nX, nY });

					}
				}
			}
		}

	} // move end

	public static void moveFire(char[][] map, boolean[][][] visited, int h, int w, int who, Queue<int[]> Fire) { // 불퍼지기
		// 상 하 좌 우
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		int size = Fire.size();

		for (int s = 0; s < size; s++) {
			int[] top = Fire.poll();

			for (int i = 0; i < 4; i++) {
				int nX = top[0] + dx[i];
				int nY = top[1] + dy[i];
				if (nX >= 0 && nY >= 0 && nX < w && nY < h) { // 맵 범위 안이고
					if (!visited[nY][nX][who] && map[nY][nX] != '#') { // 방문하지 않았고 벽이 아니면 퍼진다. (상근이도 태움)
						map[nY][nX] = '*';
						Fire.add(new int[] { nX, nY });
						visited[nY][nX][who] = true;
					}
				}
			}
		}

	} // fire end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			Queue<int[]> Sang = new LinkedList<int[]>(); // 상근이 위치 좌표를 넣을 큐
			Queue<int[]> Fire = new LinkedList<int[]>(); // 불의 위치 좌표를 넣을 큐

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int w = Integer.parseInt(st.nextToken()); // 지도의 너비
			int h = Integer.parseInt(st.nextToken()); // 지도의 높이

			boolean[][][] visited = new boolean[h][w][2];
			char[][] map = new char[h][w];

			for (int i = 0; i < h; i++) {
				String input = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = input.charAt(j);
					if (map[i][j] == '*') { // 불이면
						Fire.add(new int[] { j, i });
						visited[i][j][0] = true;
					} else if (map[i][j] == '@') { // 상근이면
						Sang.add(new int[] { j, i });
						visited[i][j][1] = true;
					}

				}
			}

			int second = 0;
			// .: 빈공간 , #: 벽 , @: 상근이 시작 위치 , *: 불
			while (true) {

				if (Sang.size() == 0) {
					bw.write("IMPOSSIBLE\n");
					break;
				}

				moveFire(map, visited, h, w, 0, Fire); // 불 먼저 퍼지기

				move(map, visited, h, w, 1, Sang); // 상근이 움직이기

				second++;

				if (flag) {
					bw.write(second + "\n");
					break;
				}
			}
			bw.flush();
			flag = false;

		}
		bw.close();
		br.close();
	} // main end

} // class end
