package com.jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_Jungol_1370_회의실배정 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] meetings = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
			meetings[i][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(meetings, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		int cnt = 1;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(meetings[0][0]);
		int end = meetings[0][2];
		
		for (int i = 1; i < N; i++) {
			if (end <= meetings[i][1]) { // 이전 회의 종료시간보다 늦게 시작한다면
				cnt++;
				numbers.add(meetings[i][0]);
				end = meetings[i][2];
			}
		}

		bw.write(cnt + "\n");
		for (int i = 0; i < numbers.size(); i++) {
			bw.write(numbers.get(i) + " ");
		}

		bw.flush();

		br.close();
		bw.close();
	}

}
