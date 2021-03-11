import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_1949_등산로조성 {

	static int max;

	public static void DFS(int[][] map, int sX, int sY, int K, int distance, int N, boolean[][] visit, boolean cutting) { // 시작좌표 값, 공사가능 깊이, 부지 크기
		if (distance > max)
			max = distance;
		
		
		// 상 하 좌 우
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		for (int i = 0; i < 4; i++) { // 상 하 좌 우 탐색
			int nX = sX + dx[i];
			int nY = sY + dy[i];

			if (nY >= 0 && nX >= 0 && nY < N && nX < N) { // 범위 안이고
				if (map[nY][nX] < map[sY][sX] && visit[nY][nX] == false) {// 다음 이동할 칸이 현재 위치보다 낮으면
					visit[nY][nX] = true;
					DFS(map, nX, nY, K, distance + 1, N, visit, cutting);
					visit[nY][nX] = false;
				}
				else { // 다음 이동할 칸이 현재 위치보다 높거나 같으면
					int diff = map[nY][nX] - map[sY][sX]; // 다음 칸과의 차이 구하기
					if (diff < K && visit[nY][nX] == false && cutting == false) { // 공사해서 더 낮아질 수 있으면
						map[nY][nX] -= (diff + 1); // 실제로 값을 빼기
						visit[nY][nX] = true;
						cutting = true;
						DFS(map, nX, nY, K - diff - 1, distance + 1, N, visit, cutting);
						map[nY][nX] += (diff + 1); // 다시 올려주기
						visit[nY][nX] = false;
						cutting = false;
					}
				}
			}

		}


	} // DFS end

	// 완탐으로 풀면됨. DFS
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 등산로 부지 크기
			int K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이

			max = 0;
			int highest = 0;
			int[][] map = new int[N][N];
			boolean[][] visit = new boolean[N][N];

			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int x = 0; x < N; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
					if (map[y][x] > highest) // 가장 높은 봉우리 찾기
						highest = map[y][x];
				}
			}

			for (int y = 0; y < N; y++) { // 완전탐색 시작
				for (int x = 0; x < N; x++) {
					if (map[y][x] == highest) {// 가장 높은 봉우리에서 시작하기
						boolean cutting = false;
						visit[y][x] = true;
						DFS(map, x, y, K, 1, N, visit, cutting);
						visit[y][x] = false;
					}
				}
			}
			bw.write("#" + tc + " " + max + "\n");
			bw.flush();
		} //

		br.close();
		bw.close();
	} // main end

} // class end
