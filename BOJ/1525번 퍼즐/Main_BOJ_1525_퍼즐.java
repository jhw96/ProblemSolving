/*
 *	3X3 칸 중 1칸은 빈칸인 퍼즐
 *  가장 오른쪽 아래를 빈칸으로 만들고 나머지 숫자들 전부 정리시키기
 *  String으로 했었지만 메모리 초과나서 int[][] 형 현재 퍼즐 상태 표시해서 해결
 *  BFS 탐색 이용
 */

package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BOJ_1525_퍼즐 {

	static int answer = -1;
	static Set<Integer> set = new HashSet<>();

	static class Node {
		int[][] status;
		int moveCnt;

		Node(int[][] status, int moveCnt) {
			this.status = status;
			this.moveCnt = moveCnt;
		}
	}

	private static int change(int[][] status) {
		int result = 0;
		int idx = 8;
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				result += (status[y][x] * Math.pow(10, idx--));
			}
		}

		return result;
	}

	private static void BFS(int[][] start) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(start, 0));

		while (!q.isEmpty()) {
			Node top = q.poll();
			int[][] status = top.status;
			int moveCnt = top.moveCnt;

			if (change(status) == 123456780) {
				answer = moveCnt;
				break;
			}

			int zeroY = 0, zeroX = 0;

			for (int y = 0; y < 3; y++) { // 빈칸 인덱스 찾기
				for (int x = 0; x < 3; x++) {
					if (status[y][x] == 0) {
						zeroY = y;
						zeroX = x;
						break;
					}
				}
			}

			boolean NoUp = false, NoDown = false, NoLeft = false, NoRight = false;

			if (zeroY == 0)
				NoUp = true;

			if (zeroY == 2)
				NoDown = true;

			if (zeroX == 0)
				NoLeft = true;

			if (zeroX == 2)
				NoRight = true;

			if (!NoUp) {
				int[][] next = new int[3][3];

				int tmp = status[zeroY - 1][zeroX];
				for (int y = 0; y < 3; y++) {
					for (int x = 0; x < 3; x++) {
						if (x == zeroX && y == zeroY - 1)
							next[y][x] = 0;
						else if (x == zeroX && y == zeroY)
							next[y][x] = tmp;
						else
							next[y][x] = status[y][x];
					}
				}

				int changeNum = change(next);
				if (!set.contains(changeNum)) {
					set.add(changeNum);
					q.add(new Node(next, moveCnt + 1));
				}

			}

			if (!NoDown) {
				int[][] next = new int[3][3];

				int tmp = status[zeroY + 1][zeroX];
				for (int y = 0; y < 3; y++) {
					for (int x = 0; x < 3; x++) {
						if (x == zeroX && y == zeroY + 1)
							next[y][x] = 0;
						else if (x == zeroX && y == zeroY)
							next[y][x] = tmp;
						else
							next[y][x] = status[y][x];
					}
				}

				int changeNum = change(next);
				if (!set.contains(changeNum)) {
					set.add(changeNum);
					q.add(new Node(next, moveCnt + 1));
				}

			}

			if (!NoLeft) {
				int[][] next = new int[3][3];

				int tmp = status[zeroY][zeroX - 1];
				for (int y = 0; y < 3; y++) {
					for (int x = 0; x < 3; x++) {
						if (x == zeroX - 1 && y == zeroY)
							next[y][x] = 0;
						else if (x == zeroX && y == zeroY)
							next[y][x] = tmp;
						else
							next[y][x] = status[y][x];
					}
				}

				int changeNum = change(next);
				if (!set.contains(changeNum)) {
					set.add(changeNum);
					q.add(new Node(next, moveCnt + 1));
				}

			}

			if (!NoRight) {
				int[][] next = new int[3][3];

				int tmp = status[zeroY][zeroX + 1];
				for (int y = 0; y < 3; y++) {
					for (int x = 0; x < 3; x++) {
						if (x == zeroX + 1 && y == zeroY)
							next[y][x] = 0;
						else if (x == zeroX && y == zeroY)
							next[y][x] = tmp;
						else
							next[y][x] = status[y][x];
					}
				}
				int changeNum = change(next);
				if (!set.contains(changeNum)) {
					set.add(changeNum);
					q.add(new Node(next, moveCnt + 1));
				}

			}

		} // while end

	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] start = new int[3][3];
		for (int y = 0; y < 3; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int x = 0; x < 3; x++)
				start[y][x] = Integer.parseInt(st.nextToken());
		}
		BFS(start);

		if (answer == -1)
			System.out.println(-1);
		else
			System.out.println(answer);

		br.close();
	} // main end

}
