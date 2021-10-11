/*
 * 24시간제를 사용하는데 시작 시간과 숫자가 주어지고, 해당 숫자만큼 시간이 지난 뒤에 몇 시인지 알아내는 문제
 * 두 시간을 더한 뒤 mod 24를 해주면 됨.
 * 왜 3단계에 있는지 의문
 */

package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_12368_24시간 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			int sum = start + end;
			System.out.println("#" + tc + " " + (sum % 24));
		}

		br.close();
	}

}
