package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_Programmers_쿼드압축후개수세기 {

	static ArrayList<Integer> compress = new ArrayList<Integer>();

	private static void solve(int[][] arr, int sX, int sY, int size, int value) {
		if (size == 1) {
			compress.add(value);
			return;
		}

		boolean check = true;

		for (int x = sX; x < sX + size; x++) {
			for (int y = sY; y < sY + size; y++) {
				if (arr[y][x] != value) {
					check = false;
					break;
				}
			}
		}

		if (check) // 값이 같다면
			compress.add(value);
		else { // 값이 다르다면
			int nX = sX + size / 2;
			int nY = sY + size / 2;

			solve(arr, sX, sY, size / 2, arr[sY][sX]);
			solve(arr, nX, sY, size / 2, arr[sY][nX]);
			solve(arr, sX, nY, size / 2, arr[nY][sX]);
			solve(arr, nX, nY, size / 2, arr[nY][nX]);
		}

	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };

		int size = arr[0].length;

		solve(arr, 0, 0, size, arr[0][0]);

		int zeroCnt = 0, oneCnt = 0;

		for (int i = 0; i < compress.size(); i++) {
			int data = compress.get(i);
			if (data == 0)
				zeroCnt++;
			else
				oneCnt++;
		}

		int[] answer = { zeroCnt, oneCnt };
		System.out.println(Arrays.toString(answer));
	}

}
