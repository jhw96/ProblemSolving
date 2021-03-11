import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1952_수영장 {

	static int min;

	public static void solve(int[] swim, int price, int day, int month, int threeMonth, int cnt) {
		if (cnt >= 12) {
			if (price < min)
				min = price;
			return;
		}
		int dayPrice = swim[cnt] * day; // cnt번째 달 수영장 이용 가격 (per day)
		int decide = Math.min(dayPrice, month); // 1일 이용권과 달 이용권 중 더 싼거 고르기

		solve(swim, price + decide, day, month, threeMonth, cnt + 1); // 1달치 계산
		solve(swim, price + threeMonth, day, month, threeMonth, cnt + 3); // 3달치 계산
	}

	// 완탐을 통한 재귀 or DP
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int day = Integer.parseInt(st.nextToken()); // 1일 이용권 가격
			int month = Integer.parseInt(st.nextToken()); // 1달 이용권 가격
			int threeMonth = Integer.parseInt(st.nextToken()); // 3달 이용권 가격
			int year = Integer.parseInt(st.nextToken()); // 1년 이용권 가격
			int[] swim = new int[12]; // 월 수영장 이용 횟수
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < 12; i++)
				swim[i] = Integer.parseInt(st.nextToken());

			solve(swim, 0, day, month, threeMonth, 0);
			min = Math.min(year, min); // 년도 이용권 vs 현재까지 계산한 이용권 가격
			System.out.println("#" + tc + " " + min);
		}

		br.close();
	}

}
