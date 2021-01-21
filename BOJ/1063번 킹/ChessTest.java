package com.baekjoon;

import java.util.*;

public class ChessTest {
	
	static boolean inChess(int x, int y) {
		if (x >= 0 && x <= 7 && y >= 0 && y <= 7)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// 상, 하, 좌, 우, 좌상, 우상, 좌하, 우하
		int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };
		int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 };

		Scanner sc = new Scanner(System.in);
		boolean[][] chess = new boolean[8][8]; // 체스판
		String king = " ", stone = " ", command = " "; // 킹, 돌 위치
		int N = 0; // 명령받을 횟수

		king = sc.next();
		stone = sc.next();
		N = sc.nextInt();

		// 아스키코드 A:65 ~ H:72 , 킹의 초반 위치 설정
		int kx_place = king.charAt(0) - 65;
		int ky_place = 8 - (king.charAt(1) - '0'); // 8 -> 0, 7(입력인덱스) -> 1(실제 인덱스)

		chess[ky_place][kx_place] = true;

		// 돌의 초반 위치 설정
		int sx_place = stone.charAt(0) - 65;
		int sy_place = 8 - (stone.charAt(1) - '0');

		chess[sy_place][sx_place] = true;

		// 킹 움직이는 명령
		for (int tc = 1; tc <= N; tc++) {
			command = sc.next();
			//System.out.println(command);
			if (command.equals("T")) { // 상 : 0
				int next_kx = kx_place + dx[0];
				int next_ky = ky_place + dy[0];
				//System.out.print((char)(kx_place+65));
				//System.out.println(next_ky + "로 이동할거야");

				if (inChess(next_kx, next_ky)) { // 다음 위치가 체스판 안이면
					//System.out.println("체스판 이동가능");
					if (chess[next_ky][next_kx] == true) { // 킹이 스톤을 만나면
						int next_sx = sx_place + dx[0];
						int next_sy = sy_place + dy[0];

						if (inChess(next_sx, next_sy)) { // 스톤이 이동해도 맵안이면
							chess[ky_place][kx_place] = false; // 현재까지 있던 킹과 돌의 위치 지우기
							chess[sy_place][sx_place] = false;
							kx_place = next_kx; // 둘다 이동시키기
							ky_place = next_ky;
							sx_place = next_sx;
							sy_place = next_sy;
							chess[ky_place][kx_place] = true;
							chess[sy_place][sx_place] = true;
						} else
							continue;
					}
					else { // 킹이 스톤을 못만나면
						chess[ky_place][kx_place] = false; // 현재까지 있던 킹과 돌의 위치 지우기
						kx_place = next_kx; 
						ky_place = next_ky;
						chess[ky_place][kx_place] = true;
						//System.out.print((char)(kx_place+65));
						//System.out.println(ky_place + "로 이동");
					}
				} else // 다음 위치가 체스판 안이 아니면
					continue;
				
			} else if (command.equals("B")) { // 하 : 1
				int next_kx = kx_place + dx[1];
				int next_ky = ky_place + dy[1];
				//System.out.print((char)(kx_place+65));
				//System.out.println((8-next_ky) + "로 이동할거야");

				if (inChess(next_kx, next_ky)) { // 다음 위치가 체스판 안이면
					//System.out.println("체스판 이동가능");
					if (chess[next_ky][next_kx] == true) { // 킹이 스톤을 만나면
						int next_sx = sx_place + dx[1];
						int next_sy = sy_place + dy[1];

						if (inChess(next_sx, next_sy)) { // 스톤이 이동해도 맵안이면
							chess[ky_place][kx_place] = false; // 현재까지 있던 킹과 돌의 위치 지우기
							chess[sy_place][sx_place] = false;
							kx_place = next_kx; // 둘다 이동시키기
							ky_place = next_ky;
							sx_place = next_sx;
							sy_place = next_sy;
							chess[ky_place][kx_place] = true;
							chess[sy_place][sx_place] = true;
						} else
							continue;
					}
					else {
						chess[ky_place][kx_place] = false; // 현재까지 있던 킹과 돌의 위치 지우기
						kx_place = next_kx; 
						ky_place = next_ky;
						chess[ky_place][kx_place] = true;
						//System.out.print((char)(kx_place+65));
						//System.out.println((8 - ky_place) + "로 이동");
					}
				} else // 다음 위치가 체스판 안이 아니면
					continue;

			} else if (command.equals("L")) { // 좌 : 2
				int next_kx = kx_place + dx[2];
				int next_ky = ky_place + dy[2];
				//System.out.print((char)(kx_place+65));
				//System.out.println((8-next_ky) + "로 이동할거야");

				if (inChess(next_kx, next_ky)) { // 다음 위치가 체스판 안이면
					//System.out.println("체스판 이동가능");
					if (chess[next_ky][next_kx] == true) { // 킹이 스톤을 만나면
						int next_sx = sx_place + dx[2];
						int next_sy = sy_place + dy[2];

						if (inChess(next_sx, next_sy)) { // 스톤이 이동해도 맵안이면
							chess[ky_place][kx_place] = false; // 현재까지 있던 킹과 돌의 위치 지우기
							chess[sy_place][sx_place] = false;
							kx_place = next_kx; // 둘다 이동시키기
							ky_place = next_ky;
							sx_place = next_sx;
							sy_place = next_sy;
							chess[ky_place][kx_place] = true;
							chess[sy_place][sx_place] = true;
						} else
							continue;
					}
					else {
						chess[ky_place][kx_place] = false; // 현재까지 있던 킹과 돌의 위치 지우기
						kx_place = next_kx; 
						ky_place = next_ky;
						chess[ky_place][kx_place] = true;
						//System.out.print((char)(kx_place+65));
						//System.out.println((8 - ky_place) + "로 이동");
					}
				} else // 다음 위치가 체스판 안이 아니면
					continue;
			} else if (command.equals("R")) { // 우 : 3
				int next_kx = kx_place + dx[3];
				int next_ky = ky_place + dy[3];
				//System.out.print((char)(kx_place+65));
				//System.out.println((8-next_ky) + "로 이동할거야");

				if (inChess(next_kx, next_ky)) { // 다음 위치가 체스판 안이면
					//System.out.println("체스판 이동가능");
					if (chess[next_ky][next_kx] == true) { // 킹이 스톤을 만나면
						int next_sx = sx_place + dx[3];
						int next_sy = sy_place + dy[3];

						if (inChess(next_sx, next_sy)) { // 스톤이 이동해도 맵안이면
							chess[ky_place][kx_place] = false; // 현재까지 있던 킹과 돌의 위치 지우기
							chess[sy_place][sx_place] = false;
							kx_place = next_kx; // 둘다 이동시키기
							ky_place = next_ky;
							sx_place = next_sx;
							sy_place = next_sy;
							chess[ky_place][kx_place] = true;
							chess[sy_place][sx_place] = true;
						} else
							continue;
					}
					else {
						chess[ky_place][kx_place] = false; // 현재까지 있던 킹과 돌의 위치 지우기
						kx_place = next_kx; 
						ky_place = next_ky;
						chess[ky_place][kx_place] = true;
						//System.out.print((char)(kx_place+65));
						//System.out.println((8 - ky_place) + "로 이동");
					}
				} else // 다음 위치가 체스판 안이 아니면
					continue;

			} else if (command.equals("LT")) { // 좌상 : 4
				int next_kx = kx_place + dx[4];
				int next_ky = ky_place + dy[4];
				//System.out.print((char)(kx_place+65));
				//System.out.println((8-next_ky) + "로 이동할거야");

				if (inChess(next_kx, next_ky)) { // 다음 위치가 체스판 안이면
					//System.out.println("체스판 이동가능");
					if (chess[next_ky][next_kx] == true) { // 킹이 스톤을 만나면
						int next_sx = sx_place + dx[4];
						int next_sy = sy_place + dy[4];

						if (inChess(next_sx, next_sy)) { // 스톤이 이동해도 맵안이면
							chess[ky_place][kx_place] = false; // 현재까지 있던 킹과 돌의 위치 지우기
							chess[sy_place][sx_place] = false;
							kx_place = next_kx; // 둘다 이동시키기
							ky_place = next_ky;
							sx_place = next_sx;
							sy_place = next_sy;
							chess[ky_place][kx_place] = true;
							chess[sy_place][sx_place] = true;
						} else
							continue;
					}
					else {
						chess[ky_place][kx_place] = false; // 현재까지 있던 킹과 돌의 위치 지우기
						kx_place = next_kx; 
						ky_place = next_ky;
						chess[ky_place][kx_place] = true;
						//System.out.print((char)(kx_place+65));
						//System.out.println((8 - ky_place) + "로 이동");
					}
				} else // 다음 위치가 체스판 안이 아니면
					continue;

			} else if (command.equals("RT")) { // 우상 : 5
				int next_kx = kx_place + dx[5];
				int next_ky = ky_place + dy[5];
				//System.out.print((char)(kx_place+65));
				//System.out.println((8-next_ky) + "로 이동할거야");

				if (inChess(next_kx, next_ky)) { // 다음 위치가 체스판 안이면
					//System.out.println("체스판 이동가능");
					if (chess[next_ky][next_kx] == true) { // 킹이 스톤을 만나면
						int next_sx = sx_place + dx[5];
						int next_sy = sy_place + dy[5];

						if (inChess(next_sx, next_sy)) { // 스톤이 이동해도 맵안이면
							chess[ky_place][kx_place] = false; // 현재까지 있던 킹과 돌의 위치 지우기
							chess[sy_place][sx_place] = false;
							kx_place = next_kx; // 둘다 이동시키기
							ky_place = next_ky;
							sx_place = next_sx;
							sy_place = next_sy;
							chess[ky_place][kx_place] = true;
							chess[sy_place][sx_place] = true;
						} else
							continue;
					}
					else {
						chess[ky_place][kx_place] = false; // 현재까지 있던 킹과 돌의 위치 지우기
						kx_place = next_kx; 
						ky_place = next_ky;
						chess[ky_place][kx_place] = true;
						//System.out.print((char)(kx_place+65));
						//System.out.println((8 - ky_place) + "로 이동");
					}
				} else // 다음 위치가 체스판 안이 아니면
					continue;

			} else if (command.equals("LB")) { // 좌하 : 6
				int next_kx = kx_place + dx[6];
				int next_ky = ky_place + dy[6];
				//System.out.print((char)(kx_place+65));
				//System.out.println((8-next_ky) + "로 이동할거야");

				if (inChess(next_kx, next_ky)) { // 다음 위치가 체스판 안이면
					//System.out.println("체스판 이동가능");
					if (chess[next_ky][next_kx] == true) { // 킹이 스톤을 만나면
						int next_sx = sx_place + dx[6];
						int next_sy = sy_place + dy[6];

						if (inChess(next_sx, next_sy)) { // 스톤이 이동해도 맵안이면
							chess[ky_place][kx_place] = false; // 현재까지 있던 킹과 돌의 위치 지우기
							chess[sy_place][sx_place] = false;
							kx_place = next_kx; // 둘다 이동시키기
							ky_place = next_ky;
							sx_place = next_sx;
							sy_place = next_sy;
							chess[ky_place][kx_place] = true;
							chess[sy_place][sx_place] = true;
						} else
							continue;
					}
					else {
						chess[ky_place][kx_place] = false; // 현재까지 있던 킹과 돌의 위치 지우기
						kx_place = next_kx; 
						ky_place = next_ky;
						chess[ky_place][kx_place] = true;
						//System.out.print((char)(kx_place+65));
						//System.out.println((8 - ky_place) + "로 이동");
					}
				} else // 다음 위치가 체스판 안이 아니면
					continue;

			} else if (command.equals("RB")) { // 우하 : 7
				int next_kx = kx_place + dx[7];
				int next_ky = ky_place + dy[7];
				//System.out.print((char)(kx_place+65));
				//System.out.println((8-next_ky) + "로 이동할거야");

				if (inChess(next_kx, next_ky)) { // 다음 위치가 체스판 안이면
					//System.out.println("체스판 이동가능");
					if (chess[next_ky][next_kx] == true) { // 킹이 스톤을 만나면
						int next_sx = sx_place + dx[7];
						int next_sy = sy_place + dy[7];

						if (inChess(next_sx, next_sy)) { // 스톤이 이동해도 맵안이면
							chess[ky_place][kx_place] = false; // 현재까지 있던 킹과 돌의 위치 지우기
							chess[sy_place][sx_place] = false;
							kx_place = next_kx; // 둘다 이동시키기
							ky_place = next_ky;
							sx_place = next_sx;
							sy_place = next_sy;
							chess[ky_place][kx_place] = true;
							chess[sy_place][sx_place] = true;
						} else
							continue;
					}
					else {
						chess[ky_place][kx_place] = false; // 현재까지 있던 킹과 돌의 위치 지우기
						kx_place = next_kx; 
						ky_place = next_ky;
						chess[ky_place][kx_place] = true;
						//System.out.print((char)(kx_place+65));
						//System.out.println((8 - ky_place) + "로 이동");
					}
				} else // 다음 위치가 체스판 안이 아니면
					continue;

			}
		}
		
		char result_kx = (char)(kx_place + 65);
		int result_ky = 8 - ky_place; // 2 -> 6, 실제 인덱스에서 요구하는 인덱스로 변경
		
		char result_sx = (char)(sx_place + 65);
		int result_sy = 8 - sy_place;
		
		System.out.print(result_kx);
		System.out.println(result_ky);
		System.out.print(result_sx);
		System.out.println(result_sy);
		

	} // main end
} // class end
