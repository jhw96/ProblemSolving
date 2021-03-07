package com.jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_Jungol_3521_그리디알고리즘 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[][] weights = new int[5][2]; // 0: 무게 , 1: 개수
		int weight = 1;
		for (int i = 0; i < 5; i++) {// 0: 1kg, 1: 2kg, 2: 4kg, 3: 8kg, 4: 16kg
			weights[i][1] = Integer.parseInt(st.nextToken());
			weights[i][0] = weight;
			weight *= 2;
		}

		int N = Integer.parseInt(st.nextToken());
		int answer = 0;

		for (int i = 4; i >= 0; i--) {

			for (int j = 0; j < weights[i][1]; j++) {
				if (N - weights[i][0] >= 0) {
					answer++;
					N -= weights[i][0];
				} else
					break;
			}

		}
		if (N == 0)
			bw.write(answer + "\n");
		else
			bw.write("impossible\n");

		bw.flush();

		bw.close();
		br.close();
	}

}
