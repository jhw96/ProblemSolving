import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_SWEA_10966_물놀이를가자 {
	static Queue<int[]> queue = new LinkedList<int[]>();

	public static void BFS(int N, int M, int[][] visit) { // 맵의 세로길이, 가로길이, 방문여부 체크 및 거리용
		// 상 하 좌 우
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		while (!queue.isEmpty()) {
			int[] top = queue.poll(); // 현재 x,y 좌표

			for (int i = 0; i < 4; i++) {
				int nX = top[0] + dx[i];
				int nY = top[1] + dy[i];

				if (nX >= 0 && nY >= 0 && nX <= M - 1 && nY <= N - 1 && visit[nY][nX] < 1) { // 범위 안이며 방문하지 않았으면
					visit[nY][nX] = visit[top[1]][top[0]] + 1; // 다음 위치는 현재 거리 + 1만큼의 거리
					queue.add(new int[] { nX, nY });
				}

			}

		}
	} // BFS end

	// 물에서부터 BFS
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 세로 길이
			int M = Integer.parseInt(st.nextToken()); // 가로 길이

			char[][] map = new char[N][M];
			int[][] visit = new int[N][M]; // 방문 여부 체크

			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = input.charAt(j);
					if (map[i][j] == 'W') {// 물이면 1 표시
						int[] temp = { j, i }; // 물이 있는 x,y 좌표
						queue.add(temp);
						visit[i][j] = 1;
					}
				}
			}

			BFS(N, M, visit);

			int sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visit[i][j] != 1)
						sum += (visit[i][j] - 1);
				}
			}
			bw.write("#" + tc + " " + sum + "\n");
			bw.flush();
		} // 테스트케이스 end

		bw.close();
		br.close();
	}

}
