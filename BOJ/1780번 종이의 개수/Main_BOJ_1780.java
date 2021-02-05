package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
0 1 -1 0 1 -1 0 1 -1
0 -1 1 0 1 -1 0 1 -1
0 1 -1 1 0 -1 0 1 -1*/

// 유도파트 인덱스 넘겨줄때 이상함
public class Main_BOJ_1780 {

	private static int[][] paper;
	private static int[] dx = { 1, 1, 0 }; // 우, 우하, 아래
	private static int[] dy = { 0, 1, 1 };
	private static int[] colorCount = { 0, 0, 0 }; // -1 개수, 0 개수, 1 개수

	private static void search(int xIndex, int yIndex, int size) {
		boolean flag = true;
		loop: for (int i = yIndex; i < yIndex + size - 1; i++) {
			for (int j = xIndex; j < xIndex + size -1; j++) {
				for (int k = 0; k < 3; k++) {
					if (paper[i][j] != paper[i + dy[k]][j + dx[k]]) { // 현재 인덱스 기준으로 우, 우하, 아래 중에 색이 다르면
						flag = false;
						break loop;
					}
				}
			}
		}
		if (flag) { // 모두 색이 같으면
			if (paper[yIndex][xIndex] == -1)
				colorCount[0] += 1;
			else if (paper[yIndex][xIndex] == 0)
				colorCount[1] += 1;
			else
				colorCount[2] += 1;
		} else { // 색이 다르면 9등분, 인덱스 잘못줬음 인덱스 고치자!!
			int newSize = size/3;
			for (int i = yIndex; i < yIndex+size; i+=newSize) {
				for (int j = xIndex; j < xIndex+size; j+=newSize) {
					search(j, i, newSize);
				}
			}
		}

	} // search end

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());

		paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		search(0, 0, N);

		for (int i = 0; i < 3; i++)
			System.out.println(colorCount[i]);

		br.close();
	}
}
