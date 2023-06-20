package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_6186_BestGrass {

	static int R, C; // Row, Column

	static int[][] map = new int[101][101];
	static boolean[][] visited = new boolean[101][101];

	static int[] dx = { 0, 0, -1, 1 }; // U D L R
	static int[] dy = { -1, 1, 0, 0 }; // U D L R
	
	static int answer;
	
	private static class Node {
		int x;
		int y;
		
		Node() {
			
		}
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	} // Node end;

	private static void BFS(int sR, int sC) { // startRow startColumn
		answer++;
		
		Queue<Node> q = new LinkedList<Node>();
		
		// first start
		visited[sR][sC] = true;
		q.add(new Node(sC,sR));
		
		
		while(!q.isEmpty()) {
			Node now = q.remove();
			
			int x = now.x;
			int y = now.y;

			for(int d=0; d<4; d++) { // calculate next place
				int nX = x + dx[d];
				int nY = y + dy[d];
				
				if(nX >=1 && nX <= C && nY >= 1 && nY <= R) {
					if(!visited[nY][nX] && map[nY][nX] == 1) {
						visited[nY][nX] = true;
						q.add(new Node(nX,nY));
					}
				}
			} // for end
		} // while end
		
		
	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		for (int r = 1; r <= R; r++) { // input map
			char[] input = new char[C + 1];
			input = br.readLine().toCharArray();

			for (int c = 0; c < C; c++) { // char to int
				if (input[c] == '#')
					map[r][c + 1] = 1;
			}
		}

		for (int r = 1; r <= R; r++) {
			for (int c = 1; c <= C; c++) {
				if (!visited[r][c] && map[r][c] == 1) {
					BFS(r, c);
				}
			}
		}
		
		System.out.println(answer);

		br.close();
	} // main end

}
