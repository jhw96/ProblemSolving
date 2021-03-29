package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_14916_거스름돈 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 5원과 2원으로만 거슬러줌
		int cnt = n / 5; // 거슬러주는 5원 갯수
		int result = cnt; // 잔돈 동전 갯수
		int remain = n - cnt * 5; // 5원 거슬러주고 남은 돈

		// 5원으로 거슬러줄 수 있으면
		while (cnt >= 0) {
			System.out.println("5원 갯수 : " + cnt);
			
			result = cnt;
			remain = n - cnt * 5;

			if (remain == 0) {
				break;
			}

			// 2원으로 거슬러주기
			result += (remain / 2);
			remain = remain % 2;
			System.out.println("2원 갯수 : " + (result-cnt));
			if (remain == 0) {
				break;
			}
			cnt--;
		}
		if (remain == 0)
			System.out.println(result);
		else
			System.out.println(-1);

		br.close();
	}

}
