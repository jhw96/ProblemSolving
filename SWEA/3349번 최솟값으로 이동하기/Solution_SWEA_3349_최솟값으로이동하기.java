package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3349_최솟값으로이동하기 {

	public static int move(int sX, int sY, int nX, int nY) { // 현재 도착지에서 다음 도착지로 이동한 최솟값 반환하기
		int count = 0;
		int diffX = nX - sX;
		int diffY = nY - sY;

		if (diffX >= 1 && diffY >= 1) {// 윗대각선으로 움직여야하는 경우
			int min = Math.min(diffX, diffY);
			count+=min;
			diffX -= min;
			diffY -= min;
		} else if (diffX <= -1 && diffY <= -1) {// 아랫대각선으로 움직여야하는 경우
			int Max = Math.max(diffX, diffY);
			count+= Math.abs(Max);
			diffX -= Max;
			diffY -= Max;

		}
		
		// 가능한 대각선 이동 끝난 후
		diffX = Math.abs(diffX);
		diffY = Math.abs(diffY);
		int sum = diffX + diffY;
		count += sum;
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int W = Integer.parseInt(st.nextToken()); // x길이
			int H = Integer.parseInt(st.nextToken()); // y길이
			int N = Integer.parseInt(st.nextToken()); // 도착지 개수

			st = new StringTokenizer(br.readLine(), " ");
			int sX = Integer.parseInt(st.nextToken());
			int sY = Integer.parseInt(st.nextToken());
			int count = 0;

			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int nX = Integer.parseInt(st.nextToken());
				int nY = Integer.parseInt(st.nextToken());
				count += move(sX, sY, nX, nY);
				sX = nX;
				sY = nY;
			}
			System.out.println("#" + tc + " " + count);

		}

		br.close();
	}

}
