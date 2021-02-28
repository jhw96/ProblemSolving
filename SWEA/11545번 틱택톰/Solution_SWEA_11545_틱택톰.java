package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_11545_틱택톰 {

	static boolean flag;
	static char[][] map;
	static int oWin = 0, xWin = 0;

	// 상 우상 우 우하 하 좌하 좌 좌상
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void DFS(int sX, int sY, int dir, int cnt) {
		if (cnt == 3) {
			flag = true;
			return;
		}

		int nY = sY + dy[dir];
		int nX = sX + dx[dir];
		if (nY >= 0 && nX >= 0 && nX <= 3 && nY <= 3) { // 범위 안이고
			if (map[sY][sX] == map[nY][nX] || map[nY][nX] == 'T') { // 같은 색말이거나 T이면
				DFS(nX, nY, dir, cnt + 1);
			}
			if (map[sY][sX] == 'T') { // 현재 말이 T라면
				int bX = sX - cnt * dx[dir];
				int bY = sY - cnt * dy[dir];
				if (map[bY][bX] == map[nY][nX])
					DFS(nX, nY, dir, cnt + 1);
			}
		}

	} // DFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			map = new char[4][4];

			int dotCount = 0;

			for (int i = 0; i < 4; i++) {
				String str = br.readLine();
				for (int j = 0; j < 4; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '.')
						dotCount++;
				}
			}
			if(tc!=t)
			br.readLine();
			
			xWin = 0;
			oWin = 0;

			for (int y = 0; y < 4; y++) { // 격자판 탐색
				for (int x = 0; x < 4; x++) {
					for (int dir = 0; dir < 8; dir++) { // 해당 좌표에서 8방 탐색
						int nY = y + dy[dir];
						int nX = x + dx[dir];
						flag = false;
						if (nY >= 0 && nX >= 0 && nY <= 3 && nX <= 3) { // 격자판 범위 안이고
							if (map[y][x] == map[nY][nX] || map[nY][nX] == 'T') // 그 방향으로 같은 말이거나 T이면
								DFS(nX, nY, dir, 1);

							if (flag) {
								if (map[y][x] == 'X')
									xWin++;
								else if (map[y][x] == 'O')
									oWin++;
							}
						}
					}

				}

			} // 격자판 end
			
			StringBuilder sb = new StringBuilder().append("#").append(tc).append(" ");
			
			if(xWin > oWin)
				sb.append("X won");
			else if(oWin > xWin) 
				sb.append("O won");
			else if(oWin == xWin && dotCount != 0)
				sb.append("Game has not completed");
			else if(oWin == xWin && dotCount == 0)
				sb.append("Draw");
			
			System.out.println(sb.toString());	
		}
		br.close();

	} // main end

} // class end
