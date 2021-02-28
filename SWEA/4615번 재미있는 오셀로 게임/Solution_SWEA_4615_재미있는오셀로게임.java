import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_4615_재미있는오셀로게임 {

	static int N;

	// 상 우상 우 우하 하 좌하 좌 좌상
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[][] map;
	static boolean flag;

	public static void DFS(int sX, int sY, int dir, int stone) { // 좌표, 방향, 시작 돌색
		int nY = sY + dy[dir];
		int nX = sX + dx[dir];

		if (nY >= 1 && nX >= 1 && nY <= N && nX <= N) { // 맵 안이고
			// 시작 돌과 다른 색 돌이면
			if (map[nY][nX] >= 1 && map[nY][nX] != stone)
				DFS(nX, nY, dir, stone);

			// 같은 색 돌을 만난 경우
			if (map[nY][nX] == stone) {
				flag = true;
			}
		}

		if (flag) {
			map[sY][sX] = stone;
			return;
		}

	} // DFS end

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 보드판 사이즈
			int M = Integer.parseInt(st.nextToken()); // 돌 놓는 횟수
			map = new int[N + 1][N + 1]; // 보드판

			// 보드판 가운데 돌놓기
			map[N / 2][N / 2] = 2;
			map[N / 2][N / 2 + 1] = 1;
			map[N / 2 + 1][N / 2] = 1;
			map[N / 2 + 1][N / 2 + 1] = 2;

			for (int m = 0; m < M; m++) { // 보드판에 돌 놓기
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken()); // 보드판에 돌 놓는 좌표
				int y = Integer.parseInt(st.nextToken());
				int stone = Integer.parseInt(st.nextToken()); // 1:흑돌, 2:백돌

				map[y][x] = stone;

				for (int dir = 0; dir < 8; dir++) { // 돌 놓는 기준 8방 탐색
					int nY = y + dy[dir];
					int nX = x + dx[dir];

					if (nY >= 1 && nX >= 1 && nY <= N && nX <= N) {

						if (map[nY][nX] >= 1 && map[nY][nX] != stone) {
							flag = false;
							DFS(nX, nY, dir, stone);
						}
					}

				}

			} // for end
			int white = 0, black = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == 1)
						black++;
					else if (map[i][j] == 2)
						white++;
				}
			}

			System.out.println("#" + tc + " " + black + " " + white);

		} // 테스트 케이스 end

		br.close();

	} // main end
} // class end