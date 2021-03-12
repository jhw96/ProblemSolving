package com.jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Jungol_1457_영역구하기 {

	public static int BFS(int sX, int sY, int[][] map, int M, int N, boolean[][] visit) {
		int area = 0; // 너비
						// 상 하 좌 우
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { sX, sY });
		visit[sY][sX] = true;

		while (!queue.isEmpty()) {
			int[] top = queue.poll();
			area++;
			for (int i = 0; i < 4; i++) {
				int nX = top[0] + dx[i];
				int nY = top[1] + dy[i];

				if (nX >= 0 && nY >= 0 && nX < N && nY < M && visit[nY][nX] == false && map[nY][nX] == 0) {
					visit[nY][nX] = true;
					queue.add(new int[] { nX, nY });
				}
			}
		}

		return area;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int M = Integer.parseInt(st.nextToken()); // 모눈종이 세로 길이
		int N = Integer.parseInt(st.nextToken()); // 모눈종이 가로 길이
		int K = Integer.parseInt(st.nextToken()); // 직사각형 개수

		int[][] map = new int[M][N];
		boolean[][] visit = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int[] left = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) }; // 왼쪽 아래
			int[] right = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) }; // 오른쪽 위

			for (int x = left[0]; x < right[0]; x++) {
				for (int y = left[1]; y < right[1]; y++) {
					map[y][x] = 1;
				}
			}

		}
		
		
		int count = 0;
		ArrayList<Integer> area = new ArrayList<Integer>();

		
		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N; x++) {
				if (visit[y][x] == false && map[y][x] == 0) {
					count++;
					area.add(BFS(x, y, map, M, N, visit));
				}
			}
		}
		

		
		Collections.sort(area);
		bw.write(count + "\n");
		for (int i = 0; i < count; i++) {
			if (i != (count - 1))
				bw.write(area.get(i) + " ");
			else
				bw.write(area.get(i) + "\n");
		}

		br.close();
		bw.close();
	}

}
