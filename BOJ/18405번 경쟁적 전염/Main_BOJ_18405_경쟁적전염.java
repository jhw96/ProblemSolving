package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_18405_경쟁적전염 {

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static int N, K; // 세로길이, 가로길이
	static int S, X, Y; // 시간, 확인할 좌표

	static int[][] map;

	static class Node {
		int x;
		int y;
		int virusNum;

		Node(int x, int y, int virusNum) {
			this.x = x;
			this.y = y;
			this.virusNum = virusNum;
		}
	}

	static ArrayList<Node> start = new ArrayList<Node>();
	static Queue<Node> virus = new LinkedList<Node>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N + 1][K + 1];

		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if (map[y][x] != 0) // 바이러스면 큐에 넣기
					start.add(new Node(x, y, map[y][x]));
			}
		}

		Collections.sort(start, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.virusNum - o2.virusNum;
			}

		});

		for (int i = 0; i < start.size(); i++)
			virus.add(start.get(i));

		st = new StringTokenizer(br.readLine(), " ");

		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= S; t++) {
			int size = virus.size();
			for (int i = 0; i < size; i++) {
				Node top = virus.poll();
				int x = top.x;
				int y = top.y;
				int virusNum = top.virusNum;
				for (int dir = 0; dir < 4; dir++) {
					int nX = x + dx[dir];
					int nY = y + dy[dir];
					if (nX >= 1 && nX <= K && nY >= 1 && nY <= N && map[nY][nX] == 0) { // 아직 전염된 곳이 아니라면
						map[nY][nX] = virusNum;
						virus.add(new Node(nX, nY, virusNum));
					}
				}
			}
		}

		System.out.println(map[X][Y]);

		br.close();
	}

}
