package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_BOJ_5568_카드놓기 {

	static int n; // 카드 개수
	static int k; // 고를 개수
	static int[] card;
	static boolean[] visited;
	static Set<String> map;

	public static void solve(int idx, String str) {
		if (idx == k) {
			map.add(str);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				solve(idx + 1, str + Integer.toString(card[i]));
				visited[i] = false;
			}
		}

	} // DFS end

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new HashSet<String>();

		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		card = new int[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++)
			card[i] = Integer.parseInt(br.readLine());
		
		solve(0, "");
		
		System.out.println(map.size());
		

		br.close();

	}

}
