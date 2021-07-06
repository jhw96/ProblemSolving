package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_5356_의석이의세로로말해요 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String words[] = new String[5];
			StringBuilder sb = new StringBuilder().append("#").append(tc).append(" ");

			int max = 0;
			for (int i = 0; i < 5; i++) {
				words[i] = br.readLine();
				if (words[i].length() > max)
					max = words[i].length();
			}

			for (int x = 0; x < max; x++) {
				for (int y = 0; y < 5; y++) {
					if (words[y].length() > x) {
						sb.append(words[y].charAt(x));
					}
				}
			}

			System.out.println(sb.toString());

		}

		br.close();
	}

}
