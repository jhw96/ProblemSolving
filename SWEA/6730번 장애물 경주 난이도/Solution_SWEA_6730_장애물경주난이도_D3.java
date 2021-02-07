package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_6730_장애물경주난이도_D3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] block = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++)
				block[i] = Integer.parseInt(st.nextToken());
			int up = 9999;
			int down = -9999;
			int diff = 0;
			boolean upFlag = false;
			boolean downFlag = false;

			for (int i = 0; i < N - 1; i++) {
				if(block[i] <= block[i+1]) 
					upFlag = true;
				else if(block[i] >= block[i+1])
					downFlag = true;
				diff = block[i] - block[i + 1];

				if (diff < up && upFlag)
					up = diff;
				if (diff > down && downFlag)
					down = diff;
			}
			
			if(!upFlag)
				up = 0;
			if(!downFlag)
				down = 0;

			System.out.println("#" + tc + " " + (-up) + " " + down);

		}

		br.close();
	}
}
