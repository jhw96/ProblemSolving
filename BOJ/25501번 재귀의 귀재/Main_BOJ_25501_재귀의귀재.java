package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_25501_재귀의귀재 {

	static int cnt; // 재귀함수 호출횟수

	private static int recursive(String str, int left, int right) {
		cnt++;
		if (left >= right) // 끝까지 비교 완료
			return 1;
		else if (str.charAt(left) != str.charAt(right)) // 왼쪽, 오른쪽 다르면
			return 0;
		else // 다음 단계로
			return recursive(str, left + 1, right - 1);
	} // recursive END

	private static int isPalindrome(String str) {
		return recursive(str, 0, str.length() - 1);
	} // isPalindrome END

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String str = br.readLine();

			cnt = 0;

			System.out.println(isPalindrome(str) + " " + cnt);
		}

		br.close();
	}

}
