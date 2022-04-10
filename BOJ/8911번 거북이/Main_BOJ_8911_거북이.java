package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_8911_거북이 {

	static int minX, maxX, minY, maxY;
	static String command;
	static int answer;
	
	static int[] dFx = { 0, 1, 0, -1 }; // 앞으로 x 이동
	static int[] dFy = { 1, 0, -1, 0 }; // 앞으로 y 이동

	static int[] dBx = { 0, -1, 0, 1 }; // 뒤로 x 이동
	static int[] dBy = { -1, 0, 1, 0 }; // 뒤로 y 이동

	static class turtle {
		int x;
		int y;
		int dir;

		turtle(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}

	private static void move() {

		Queue<turtle> q = new LinkedList<turtle>();
		q.add(new turtle(0, 0, 0)); // 0: 북 , 1: 동, 2: 남, 3: 서
		for (int c = 0; c < command.length(); c++) {
			turtle top = q.poll();

			int x = top.x;
			int y = top.y;
			int dir = top.dir;
			

			if (command.charAt(c) == 'L') { // 왼쪽 회전
				int nextDir = dir == 0 ? 3 : dir - 1;
				q.add(new turtle(x, y, nextDir));
			} else if (command.charAt(c) == 'R') { // 오른쪽 회전
				int nextDir = dir == 3 ? 0 : dir + 1;
				q.add(new turtle(x, y, nextDir));
			} else {
				if (command.charAt(c) == 'F') { // 앞으로 이동
					int nX = top.x + dFx[dir];
					int nY = top.y + dFy[dir];
					q.add(new turtle(nX, nY, dir));
					
					if(nX != x) { // x축이 움직였으면
						if(nX > maxX) 
							maxX = nX;
						if(nX < minX) 
							minX = nX;
					} else if(nY != y) { // y축이 움직였으면
						if(nY > maxY)
							maxY = nY;
						if(nY < minY)
							minY = nY;
					}
				} else if (command.charAt(c) == 'B') { // 뒤로 이동
					int nX = top.x + dBx[dir];
					int nY = top.y + dBy[dir];
					q.add(new turtle(nX, nY, dir));
					
					if(nX != x) { // x축이 움직였으면
						if(nX > maxX) 
							maxX = nX;
						if(nX < minX) 
							minX = nX;
					} else if(nY != y) { // y축이 움직였으면
						if(nY > maxY)
							maxY = nY;
						if(nY < minY)
							minY = nY;
					}
				}
			}

		}

	} // move end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			minX = 0;
			maxX = 0;
			minY = 0;
			maxY = 0;

			command = br.readLine();
			
			move();
			
			answer = (maxY - minY) * (maxX - minX);

			System.out.println(answer);
		}

		br.close();
	} // main end

}
