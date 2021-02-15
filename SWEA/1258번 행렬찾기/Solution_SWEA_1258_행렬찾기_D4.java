package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_SWEA_1258_행렬찾기_D4 {
	// 상 하 좌 우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static int N, count; // 행렬의 크기 및 너비세기용
	static int[][] matrix; // 행렬
	static boolean[][] visit; // 방문여부

	public static void DFS(int startY, int startX) {
		visit[startY][startX] = true;
		count++;
		for (int i = 0; i < 4; i++) {
			int nextX = startX + dx[i];
			int nextY = startY + dy[i];
			if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) { // 배열의 범위 안이고
				if (visit[nextY][nextX] == false && matrix[nextY][nextX] !=  0) // 방문하지 않았으면
					DFS(nextY, nextX);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(br.readLine()); // 행렬 크기
			matrix = new int[N][N];
			visit = new boolean[N][N];
			ArrayList<int[]> answer = new ArrayList<int[]>();
			
			
			for (int i = 0; i < N; i++) { // 행렬채워넣기
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++)
					matrix[i][j] = Integer.parseInt(st.nextToken());
			}
			

			for (int y = 0; y < N; y++) { // 행 탐색
				for (int x = 0; x < N; x++) { // 열 탐색
					count = 0;
					if (matrix[y][x] != 0 && visit[y][x] == false) { // 빈 용기가 아니면
						DFS(y, x);
						int xLength = 0;
						for (int i = x; i < N; i++) {
							if (matrix[y][i] == 0)
								break;
							xLength++;
						}
						int[] temp = { count, xLength, count / xLength };
						answer.add(temp);
					}

				}
			}
			
			Collections.sort(answer, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});
			
			sb.append(answer.size());
			
			for(int i=0; i<answer.size(); i++)
				sb.append(" ").append(answer.get(i)[2]).append(" ").append(answer.get(i)[1]);
				
			System.out.println(sb);
			

		}

		br.close();
	}

}
