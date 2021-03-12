package com.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_4008_숫자만들기 {

	static int max, min = 0;

	public static void perm(int[] nums, int[] count, int cnt, int N, int result) {
		if (cnt == N - 1) {
			if (result > max)
				max = result;
			if (result < min)
				min = result;

			return;
		}

		for (int i = 0; i < 4; i++) { // 연산자 넣기
			if (count[i] != 0) { // 현재 결과에 다음값 연산해주기
				count[i]--;
				if (i == 0) // +일 경우
					perm(nums, count, cnt + 1, N, result + nums[cnt + 1]);
				else if (i == 1) // -일 경우
					perm(nums, count, cnt + 1, N, result - nums[cnt + 1]);
				else if (i == 2) // *일 경우
					perm(nums, count, cnt + 1, N, result * nums[cnt + 1]);
				else {// 나누기일 경우
					if (nums[cnt + 1] != 0)
						perm(nums, count, cnt + 1, N, result / nums[cnt + 1]);
				}
				count[i]++;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int[] count = new int[4]; // 순서대로 + , - , * , / 개 개수

			for (int i = 0; i < 4; i++) {
				count[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");

			int[] nums = new int[N];
			for (int i = 0; i < N; i++)
				nums[i] = Integer.parseInt(st.nextToken());

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;

			perm(nums, count, 0, N, nums[0]);

			bw.write("#" + tc + " " + (max - min)+"\n");
			bw.flush();
		}

		br.close();
		bw.close();
	}

}
