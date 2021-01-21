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
		// ��, ��, ��, ��, �»�, ���, ����, ����
		int[] dx = { 0, 0, -1, 1, -1, 1, -1, 1 };
		int[] dy = { -1, 1, 0, 0, -1, -1, 1, 1 };

		Scanner sc = new Scanner(System.in);
		boolean[][] chess = new boolean[8][8]; // ü����
		String king = " ", stone = " ", command = " "; // ŷ, �� ��ġ
		int N = 0; // ��ɹ��� Ƚ��

		king = sc.next();
		stone = sc.next();
		N = sc.nextInt();

		// �ƽ�Ű�ڵ� A:65 ~ H:72 , ŷ�� �ʹ� ��ġ ����
		int kx_place = king.charAt(0) - 65;
		int ky_place = 8 - (king.charAt(1) - '0'); // 8 -> 0, 7(�Է��ε���) -> 1(���� �ε���)

		chess[ky_place][kx_place] = true;

		// ���� �ʹ� ��ġ ����
		int sx_place = stone.charAt(0) - 65;
		int sy_place = 8 - (stone.charAt(1) - '0');

		chess[sy_place][sx_place] = true;

		// ŷ �����̴� ���
		for (int tc = 1; tc <= N; tc++) {
			command = sc.next();
			//System.out.println(command);
			if (command.equals("T")) { // �� : 0
				int next_kx = kx_place + dx[0];
				int next_ky = ky_place + dy[0];
				//System.out.print((char)(kx_place+65));
				//System.out.println(next_ky + "�� �̵��Ұž�");

				if (inChess(next_kx, next_ky)) { // ���� ��ġ�� ü���� ���̸�
					//System.out.println("ü���� �̵�����");
					if (chess[next_ky][next_kx] == true) { // ŷ�� ������ ������
						int next_sx = sx_place + dx[0];
						int next_sy = sy_place + dy[0];

						if (inChess(next_sx, next_sy)) { // ������ �̵��ص� �ʾ��̸�
							chess[ky_place][kx_place] = false; // ������� �ִ� ŷ�� ���� ��ġ �����
							chess[sy_place][sx_place] = false;
							kx_place = next_kx; // �Ѵ� �̵���Ű��
							ky_place = next_ky;
							sx_place = next_sx;
							sy_place = next_sy;
							chess[ky_place][kx_place] = true;
							chess[sy_place][sx_place] = true;
						} else
							continue;
					}
					else { // ŷ�� ������ ��������
						chess[ky_place][kx_place] = false; // ������� �ִ� ŷ�� ���� ��ġ �����
						kx_place = next_kx; 
						ky_place = next_ky;
						chess[ky_place][kx_place] = true;
						//System.out.print((char)(kx_place+65));
						//System.out.println(ky_place + "�� �̵�");
					}
				} else // ���� ��ġ�� ü���� ���� �ƴϸ�
					continue;
				
			} else if (command.equals("B")) { // �� : 1
				int next_kx = kx_place + dx[1];
				int next_ky = ky_place + dy[1];
				//System.out.print((char)(kx_place+65));
				//System.out.println((8-next_ky) + "�� �̵��Ұž�");

				if (inChess(next_kx, next_ky)) { // ���� ��ġ�� ü���� ���̸�
					//System.out.println("ü���� �̵�����");
					if (chess[next_ky][next_kx] == true) { // ŷ�� ������ ������
						int next_sx = sx_place + dx[1];
						int next_sy = sy_place + dy[1];

						if (inChess(next_sx, next_sy)) { // ������ �̵��ص� �ʾ��̸�
							chess[ky_place][kx_place] = false; // ������� �ִ� ŷ�� ���� ��ġ �����
							chess[sy_place][sx_place] = false;
							kx_place = next_kx; // �Ѵ� �̵���Ű��
							ky_place = next_ky;
							sx_place = next_sx;
							sy_place = next_sy;
							chess[ky_place][kx_place] = true;
							chess[sy_place][sx_place] = true;
						} else
							continue;
					}
					else {
						chess[ky_place][kx_place] = false; // ������� �ִ� ŷ�� ���� ��ġ �����
						kx_place = next_kx; 
						ky_place = next_ky;
						chess[ky_place][kx_place] = true;
						//System.out.print((char)(kx_place+65));
						//System.out.println((8 - ky_place) + "�� �̵�");
					}
				} else // ���� ��ġ�� ü���� ���� �ƴϸ�
					continue;

			} else if (command.equals("L")) { // �� : 2
				int next_kx = kx_place + dx[2];
				int next_ky = ky_place + dy[2];
				//System.out.print((char)(kx_place+65));
				//System.out.println((8-next_ky) + "�� �̵��Ұž�");

				if (inChess(next_kx, next_ky)) { // ���� ��ġ�� ü���� ���̸�
					//System.out.println("ü���� �̵�����");
					if (chess[next_ky][next_kx] == true) { // ŷ�� ������ ������
						int next_sx = sx_place + dx[2];
						int next_sy = sy_place + dy[2];

						if (inChess(next_sx, next_sy)) { // ������ �̵��ص� �ʾ��̸�
							chess[ky_place][kx_place] = false; // ������� �ִ� ŷ�� ���� ��ġ �����
							chess[sy_place][sx_place] = false;
							kx_place = next_kx; // �Ѵ� �̵���Ű��
							ky_place = next_ky;
							sx_place = next_sx;
							sy_place = next_sy;
							chess[ky_place][kx_place] = true;
							chess[sy_place][sx_place] = true;
						} else
							continue;
					}
					else {
						chess[ky_place][kx_place] = false; // ������� �ִ� ŷ�� ���� ��ġ �����
						kx_place = next_kx; 
						ky_place = next_ky;
						chess[ky_place][kx_place] = true;
						//System.out.print((char)(kx_place+65));
						//System.out.println((8 - ky_place) + "�� �̵�");
					}
				} else // ���� ��ġ�� ü���� ���� �ƴϸ�
					continue;
			} else if (command.equals("R")) { // �� : 3
				int next_kx = kx_place + dx[3];
				int next_ky = ky_place + dy[3];
				//System.out.print((char)(kx_place+65));
				//System.out.println((8-next_ky) + "�� �̵��Ұž�");

				if (inChess(next_kx, next_ky)) { // ���� ��ġ�� ü���� ���̸�
					//System.out.println("ü���� �̵�����");
					if (chess[next_ky][next_kx] == true) { // ŷ�� ������ ������
						int next_sx = sx_place + dx[3];
						int next_sy = sy_place + dy[3];

						if (inChess(next_sx, next_sy)) { // ������ �̵��ص� �ʾ��̸�
							chess[ky_place][kx_place] = false; // ������� �ִ� ŷ�� ���� ��ġ �����
							chess[sy_place][sx_place] = false;
							kx_place = next_kx; // �Ѵ� �̵���Ű��
							ky_place = next_ky;
							sx_place = next_sx;
							sy_place = next_sy;
							chess[ky_place][kx_place] = true;
							chess[sy_place][sx_place] = true;
						} else
							continue;
					}
					else {
						chess[ky_place][kx_place] = false; // ������� �ִ� ŷ�� ���� ��ġ �����
						kx_place = next_kx; 
						ky_place = next_ky;
						chess[ky_place][kx_place] = true;
						//System.out.print((char)(kx_place+65));
						//System.out.println((8 - ky_place) + "�� �̵�");
					}
				} else // ���� ��ġ�� ü���� ���� �ƴϸ�
					continue;

			} else if (command.equals("LT")) { // �»� : 4
				int next_kx = kx_place + dx[4];
				int next_ky = ky_place + dy[4];
				//System.out.print((char)(kx_place+65));
				//System.out.println((8-next_ky) + "�� �̵��Ұž�");

				if (inChess(next_kx, next_ky)) { // ���� ��ġ�� ü���� ���̸�
					//System.out.println("ü���� �̵�����");
					if (chess[next_ky][next_kx] == true) { // ŷ�� ������ ������
						int next_sx = sx_place + dx[4];
						int next_sy = sy_place + dy[4];

						if (inChess(next_sx, next_sy)) { // ������ �̵��ص� �ʾ��̸�
							chess[ky_place][kx_place] = false; // ������� �ִ� ŷ�� ���� ��ġ �����
							chess[sy_place][sx_place] = false;
							kx_place = next_kx; // �Ѵ� �̵���Ű��
							ky_place = next_ky;
							sx_place = next_sx;
							sy_place = next_sy;
							chess[ky_place][kx_place] = true;
							chess[sy_place][sx_place] = true;
						} else
							continue;
					}
					else {
						chess[ky_place][kx_place] = false; // ������� �ִ� ŷ�� ���� ��ġ �����
						kx_place = next_kx; 
						ky_place = next_ky;
						chess[ky_place][kx_place] = true;
						//System.out.print((char)(kx_place+65));
						//System.out.println((8 - ky_place) + "�� �̵�");
					}
				} else // ���� ��ġ�� ü���� ���� �ƴϸ�
					continue;

			} else if (command.equals("RT")) { // ��� : 5
				int next_kx = kx_place + dx[5];
				int next_ky = ky_place + dy[5];
				//System.out.print((char)(kx_place+65));
				//System.out.println((8-next_ky) + "�� �̵��Ұž�");

				if (inChess(next_kx, next_ky)) { // ���� ��ġ�� ü���� ���̸�
					//System.out.println("ü���� �̵�����");
					if (chess[next_ky][next_kx] == true) { // ŷ�� ������ ������
						int next_sx = sx_place + dx[5];
						int next_sy = sy_place + dy[5];

						if (inChess(next_sx, next_sy)) { // ������ �̵��ص� �ʾ��̸�
							chess[ky_place][kx_place] = false; // ������� �ִ� ŷ�� ���� ��ġ �����
							chess[sy_place][sx_place] = false;
							kx_place = next_kx; // �Ѵ� �̵���Ű��
							ky_place = next_ky;
							sx_place = next_sx;
							sy_place = next_sy;
							chess[ky_place][kx_place] = true;
							chess[sy_place][sx_place] = true;
						} else
							continue;
					}
					else {
						chess[ky_place][kx_place] = false; // ������� �ִ� ŷ�� ���� ��ġ �����
						kx_place = next_kx; 
						ky_place = next_ky;
						chess[ky_place][kx_place] = true;
						//System.out.print((char)(kx_place+65));
						//System.out.println((8 - ky_place) + "�� �̵�");
					}
				} else // ���� ��ġ�� ü���� ���� �ƴϸ�
					continue;

			} else if (command.equals("LB")) { // ���� : 6
				int next_kx = kx_place + dx[6];
				int next_ky = ky_place + dy[6];
				//System.out.print((char)(kx_place+65));
				//System.out.println((8-next_ky) + "�� �̵��Ұž�");

				if (inChess(next_kx, next_ky)) { // ���� ��ġ�� ü���� ���̸�
					//System.out.println("ü���� �̵�����");
					if (chess[next_ky][next_kx] == true) { // ŷ�� ������ ������
						int next_sx = sx_place + dx[6];
						int next_sy = sy_place + dy[6];

						if (inChess(next_sx, next_sy)) { // ������ �̵��ص� �ʾ��̸�
							chess[ky_place][kx_place] = false; // ������� �ִ� ŷ�� ���� ��ġ �����
							chess[sy_place][sx_place] = false;
							kx_place = next_kx; // �Ѵ� �̵���Ű��
							ky_place = next_ky;
							sx_place = next_sx;
							sy_place = next_sy;
							chess[ky_place][kx_place] = true;
							chess[sy_place][sx_place] = true;
						} else
							continue;
					}
					else {
						chess[ky_place][kx_place] = false; // ������� �ִ� ŷ�� ���� ��ġ �����
						kx_place = next_kx; 
						ky_place = next_ky;
						chess[ky_place][kx_place] = true;
						//System.out.print((char)(kx_place+65));
						//System.out.println((8 - ky_place) + "�� �̵�");
					}
				} else // ���� ��ġ�� ü���� ���� �ƴϸ�
					continue;

			} else if (command.equals("RB")) { // ���� : 7
				int next_kx = kx_place + dx[7];
				int next_ky = ky_place + dy[7];
				//System.out.print((char)(kx_place+65));
				//System.out.println((8-next_ky) + "�� �̵��Ұž�");

				if (inChess(next_kx, next_ky)) { // ���� ��ġ�� ü���� ���̸�
					//System.out.println("ü���� �̵�����");
					if (chess[next_ky][next_kx] == true) { // ŷ�� ������ ������
						int next_sx = sx_place + dx[7];
						int next_sy = sy_place + dy[7];

						if (inChess(next_sx, next_sy)) { // ������ �̵��ص� �ʾ��̸�
							chess[ky_place][kx_place] = false; // ������� �ִ� ŷ�� ���� ��ġ �����
							chess[sy_place][sx_place] = false;
							kx_place = next_kx; // �Ѵ� �̵���Ű��
							ky_place = next_ky;
							sx_place = next_sx;
							sy_place = next_sy;
							chess[ky_place][kx_place] = true;
							chess[sy_place][sx_place] = true;
						} else
							continue;
					}
					else {
						chess[ky_place][kx_place] = false; // ������� �ִ� ŷ�� ���� ��ġ �����
						kx_place = next_kx; 
						ky_place = next_ky;
						chess[ky_place][kx_place] = true;
						//System.out.print((char)(kx_place+65));
						//System.out.println((8 - ky_place) + "�� �̵�");
					}
				} else // ���� ��ġ�� ü���� ���� �ƴϸ�
					continue;

			}
		}
		
		char result_kx = (char)(kx_place + 65);
		int result_ky = 8 - ky_place; // 2 -> 6, ���� �ε������� �䱸�ϴ� �ε����� ����
		
		char result_sx = (char)(sx_place + 65);
		int result_sy = 8 - sy_place;
		
		System.out.print(result_kx);
		System.out.println(result_ky);
		System.out.print(result_sx);
		System.out.println(result_sy);
		

	} // main end
} // class end
