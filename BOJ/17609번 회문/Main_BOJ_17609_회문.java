package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_17609_회문 {

	private static boolean check(String s, int left, int right) {

		while (left < right) {
			if (s.charAt(left) == s.charAt(right)) {
				left++;
				right--;
			} else {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) { // 이런식으로 풀면 어떤 문자를 뺄 때 순서에 따라 될 수도 안될 수도 있기 때문에 재귀함수로 구현해보자
			String s = br.readLine();
			int left = 0, right = s.length() - 1;

			boolean flag = true;
			boolean chance = false;
			while (left < right) {
				if (s.charAt(left) == s.charAt(right)) { // 앞 뒤가 같은 문자면
					left++;
					right--;
				} else { // 다른 문자면
					int cnt = 0;
					if (check(s, left + 1, right)) // 문자끼리 다를 때 빼는 순서에 따라 결과가 달라지기 때문에 둘다 해봐야함
						cnt++;
					if (check(s, left, right - 1))
						cnt++;
					if (cnt > 0) {
						chance = true;
						flag = true;
						break;
					} else {
						flag = false;
						break;
					}

				}
			}

//			System.out.println("=================");

			if (chance)
				System.out.println(1);
			else if (!flag)
				System.out.println(2);
			else
				System.out.println(0);

		} // 테케 end

	} // main end

} // class end
