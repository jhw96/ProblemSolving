
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_4013_특이한자석 {

	static int[][] magnetic; // 1~4번 자석 : 자성정보
	static ArrayList<Integer>[] chain = (ArrayList<Integer>[]) new ArrayList[5]; // 1~4번 자석 연결된 정보
	static boolean[] rotated = new boolean[5];

	private static void turnRight(int idx) {
		int before = magnetic[idx][1], after = 0;
		int last = magnetic[idx][8];
		for (int i = 1; i <= 7; i++) {
			after = magnetic[idx][i + 1];
			magnetic[idx][i + 1] = before;
			before = after;
		}
		magnetic[idx][1] = last;
	}

	private static void turnLeft(int idx) {
		int before = magnetic[idx][8], after = 0;
		int first = magnetic[idx][1];
		for (int i = 8; i >= 2; i--) {
			after = magnetic[idx][i - 1];
			magnetic[idx][i - 1] = before;
			before = after;
		}
		magnetic[idx][8] = first;
	}

	private static void rotate(int idx, int dir, int geug, int where) { // 톱니바퀴 회전시키기, 톱니바퀴 번호와 회전방향, 그리고 극번호
		// 시계방향 1, 반시계 방향 -1, S극 1, N극 0, 오른쪽에서 왔으면 1, 왼쪽에서 왔으면 0

		if (dir == 0) { // 전 톱니가 돌지 않았으면
			return;
		}

		int right = magnetic[idx][3]; // 오른쪽 바퀴와 맞닿은 자성정보
		int left = magnetic[idx][7]; // 왼쪽 바퀴와 맞닿은 자성정보

		if (geug == -1) { // 첫 톱니바퀴
			if (dir == 1) { // 시계 방향
				turnRight(idx);
			} else { // 반시계 방향
				turnLeft(idx);
			}
		} else { // 첫 톱니바퀴가 아니면

			if (where == 1) { // 오른쪽에서 왔으면
				if (geug != right) { // 닿는 부분이 서로 다르면
					if (dir == 1) { // 전 톱니가 시계방향이였으면 반시계로 돌기
						turnLeft(idx);

						dir = -1; // 현재 톱니 회전 방향으로 갱신
					} else {
						turnRight(idx);

						dir = 1; // 현재 톱니 회전 방향으로 갱신
					}
				} else {
					dir = 0;
				}

			} else if (where == 0) { // 왼쪽에서 왔으면
				if (geug != left) { // 닿는 부분이 서로 다르면
					if (dir == 1) { // 전 톱니가 시계방향이였으면 반시계로 돌기
						turnLeft(idx);

						dir = -1; // 현재 톱니 회전 방향으로 갱신
					} else {
						turnRight(idx);

						dir = 1; // 현재 톱니 회전 방향으로 갱신
					}
				} else {
					dir = 0;
				}
			}

		}

		for (int i = 0; i < chain[idx].size(); i++) { // 연결된 톱니들 건들기
			int next = chain[idx].get(i);

			if (!rotated[next]) {
				if (next < idx) {// 왼쪽에 있는 톱니바퀴면
					rotated[next] = true;
					rotate(next, dir, left, 1);
				} else {// 오른쪽에 있는 톱니바퀴면
					rotated[next] = true;
					rotate(next, dir, right, 0);
				}
			}
		}

	} // rotate end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= 4; i++)
			chain[i] = new ArrayList<Integer>();

		// 톱니바퀴 연결하기
		chain[1].add(2);
		chain[2].add(1);
		chain[2].add(3);
		chain[3].add(2);
		chain[3].add(4);
		chain[4].add(3);

		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine()); // 회전 횟수
			magnetic = new int[5][9]; // 1~4번 자석 : 자성정보

			for (int i = 1; i <= 4; i++) { // 자석 정보 입력받기
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= 8; j++)
					magnetic[i][j] = Integer.parseInt(st.nextToken());
			}

			for (int k = 1; k <= K; k++) {
				Arrays.fill(rotated, false);
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int idx = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				rotated[idx] = true;
				rotate(idx, dir, -1, 0);

			}

			int answer = 0;

			if (magnetic[1][1] == 1)
				answer += 1;
			if (magnetic[2][1] == 1)
				answer += 2;
			if (magnetic[3][1] == 1)
				answer += 4;
			if (magnetic[4][1] == 1)
				answer += 8;

			System.out.println("#" + tc + " " + answer);
		} // 테케 end

		br.close();
	} // main end

} // class end
