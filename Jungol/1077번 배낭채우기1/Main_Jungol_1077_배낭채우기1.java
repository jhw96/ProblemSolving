package com.jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_Jungol_1077_배낭채우기1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[][] diamond = new int[N][2]; // 0: 보석 무게, 1: 보석 가치

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				diamond[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] maxCost = new int[W + 1]; // 무게 별 최대 가치
		maxCost[0] = 0;

		for (int weight = 1; weight <= W; weight++) { // 가능한 무게 다 체크해보기
			int max = 0;
			for (int idx = 0; idx < N; idx++) { // 무게별로 물건들 다 넣어보기
				int diaWeight = diamond[idx][0]; // 보석 무게
				int diaValue = diamond[idx][1]; // 보석 가치
				if(diaWeight <= weight && maxCost[weight-diaWeight] + diaValue > max) {
				// 현재 보석 무게가 최대 무게보다 가볍거나 같고 / 이 물건을 포함한 가치가 더 높으면
					max = maxCost[weight-diaWeight] + diaValue;
				}
			}
			maxCost[weight] = max;
		}
		
		bw.write(maxCost[W] + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
