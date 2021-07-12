package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11170_0ÀÇ°³¼ö {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int answer = 0;

			for (int i = N; i <= M; i++) {
				String num = String.valueOf(i);
				for (int j = 0; j < num.length(); j++)
					if (num.charAt(j) == '0')
						answer++;
			}

			System.out.println(answer);
		}

		br.close();
	}

}
