package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_1227_미로2_D4 {

	static int[][] map;
	static boolean[][] visited;
	static boolean flag;

	public static void DFS(int sX, int sY) {
		if (flag)
			return;
		
		visited[sY][sX] = true;

		// 상 하 좌 우
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		for (int i = 0; i < 4; i++) {
			int nY = sY + dy[i];
			int nX = sX + dx[i];
			if (nX >= 0 && nY >= 0 && nX <= 99 && nY <= 99) { // 맵 안이고
				if (map[nY][nX] == 0 && visited[nY][nX] == false) { // 길이면 이동
					DFS(nX, nY);
				} else if (map[nY][nX] == 3) { // 도착지이면 stop
					flag = true;
					return;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			StringBuilder sb = new StringBuilder().append("#").append(tc).append(" ");

			flag = false;
			map = new int[100][100];
			visited = new boolean[100][100];

			for (int i = 0; i < 100; i++) { // 미로 맵 입력받기 0:길, 1:벽, 2:출발, 3:도착
				String input = br.readLine();
				for (int j = 0; j < 100; j++)
					map[i][j] = input.charAt(j) - '0';
			}
			
			

			for (int y = 0; y < 100; y++) {
				for (int x = 0; x < 100; x++) {
					if (map[y][x] == 2) { // 출발점이면
						DFS(x, y);
						break;
					}
				}
			}

			if (flag)
				sb.append(1);
			else
				sb.append(0);
			System.out.println(sb.toString());
		}

		br.close();
	}

}
