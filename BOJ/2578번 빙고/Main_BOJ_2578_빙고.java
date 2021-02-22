package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2578_빙고 {
	static int count = 0;
	static boolean[][] usedY = new boolean[5][3];
	static boolean[] usedX = new boolean[5];

	public static void lining(int[][] bingo, boolean[][] check) {
		int sX = 0;
		for (int y = 0; y < 5; y++) { // 오른쪽 대각선 위, 오른쪽 대각선 밑, 오른쪽 검사하기

			if (check[y][0] == true && usedY[y][0] == false) { // 만약에 체크한데가 있으면
				if (check[y][sX + 1] == true) { // 오른쪽도 체크되있으면
					boolean flag = true;
					for (int x = 2; x < 5; x++) {
						if (check[y][x] == false) {
							flag = false;
							break;
						}
					}
					if (flag) {
						count++;
						usedY[y][0] = true;

					}
				}

				if (y - 1 >= 0) { // 오른쪽 위 대각선 체크
					if (check[y - 1][sX + 1] == true && usedY[y][1] == false) { // 오른쪽 위가 체크되어있으면
						int smallCount = 0;
						for (int i = 2; i < 5; i++) {
							if (y - i >= 0) {
								if (check[y - i][sX + i] == true)
									smallCount++;
							} else
								break;
						}
						if (smallCount == 3) {
							count++;
							usedY[y][1] = true;
						}
					}
				}

				if (y + 1 < 5) { // 오른쪽 아래 대각선 체크
					if (check[y + 1][sX + 1] == true && usedY[y][2] == false) {
						int smallCount = 0;
						for (int i = 2; i < 5; i++) {
							if (y + i < 5) {
								if (check[y + i][sX + i] == true)
									smallCount++;
							} else
								break;
						}
						if (smallCount == 3) {
							count++;
							usedY[y][2] = true;
						}
					}
				}

			}

		} // for end
		int sY = 0;
		for (int x = 0; x < 5; x++) {
			if (check[sY][x] == true) {
				if(check[sY+1][x] == true && usedX[x] == false) {
					int smallCount = 0;
					for(int y=2; y<5; y++) {
						if(check[sY+y][x] == true)
							smallCount++;
						else
							break;
					}
					if(smallCount == 3) {
						count++;
						usedX[x] = true;
					}
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int[][] bingo = new int[5][5];
		boolean[][] check = new boolean[5][5]; // 빙고 체크

		for (int i = 0; i < 5; i++) { // 빙고판 채우기
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		loop: for (int i = 0; i < 5; i++) { // 사회자가 숫자 부르기
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				answer++;
				for (int y = 0; y < 5; y++) { // 빙고판 체크하기
					for (int x = 0; x < 5; x++) {
						if (bingo[y][x] == num) {
							check[y][x] = true;
							if (i >= 2)
								lining(bingo, check);
						}
						if (count == 3) {// 빙고 나오면 스탑
							break loop;
						}
					}
				}
			}
		}

		System.out.println(answer);

		br.close();
	} // main end
} // class end
