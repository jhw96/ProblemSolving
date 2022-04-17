package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BOJ_5107_마니또 {

	static ArrayList<String> people;
	static Map<String, String> manito;
	static Set<String> visited;
	static int answer;

	private static void BFS() {
		Queue<String> q = new LinkedList<String>();

		for (int i = 0; i < people.size(); i++) {
			String person = people.get(i);
			if (!visited.contains(person)) {
				q.add(person);
				break;
			}
		}

		while (!q.isEmpty()) {
			String top = q.poll();

			String next = manito.get(top); // 다음 사람

			if (visited.contains(next)) { // 이미 받은 사람이면
				answer++;
				break;
			} else { // 받지 않은 사람이면
				visited.add(next);
				q.add(next);
			}

		}

	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 0;
		
		while (true) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0)
				break;
			t++;
			answer = 0;
			manito = new HashMap<String, String>();
			visited = new HashSet<String>();
			people = new ArrayList<String>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String from = st.nextToken();
				String to = st.nextToken();

				people.add(from);

				manito.put(from, to);
			}

			while (true) {
				if (visited.size() == N)
					break;
				BFS();
			}

			System.out.println(t + " " + answer);
		}

		br.close();
	} // main end

}
