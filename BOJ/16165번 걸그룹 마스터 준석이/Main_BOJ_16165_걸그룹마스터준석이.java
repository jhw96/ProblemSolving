package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BOJ_16165_걸그룹마스터준석이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 걸그룹 수
		int M = Integer.parseInt(st.nextToken()); // 문제의 수

		Map<String, HashSet> hash = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String girlGroup = br.readLine();
			int n = Integer.parseInt(br.readLine());

			HashSet<String> member = new HashSet<String>();

			for (int j = 0; j < n; j++) {
				member.add(br.readLine());
			}

			hash.put(girlGroup, member);
		}

		for (int i = 0; i < M; i++) {
			String name = br.readLine(); // 퀴즈
			int n = Integer.parseInt(br.readLine());

			if (n == 1) { // 걸 그룹 맞추기
				Iterator<String> keys = hash.keySet().iterator();

				while (keys.hasNext()) {
					String key = keys.next(); // 걸그룹 이름
					if (hash.get(key).contains(name)) {
						System.out.println(key);
						break;
					}
				}

			} else { // 멤버 맞추기
				Iterator<String> keys = hash.keySet().iterator();

				while (keys.hasNext()) {
					if (keys.next().equals(name)) {
						ArrayList<String> members = new ArrayList<String>();
						Iterator<String> itr = hash.get(name).iterator();
						while (itr.hasNext()) {
							members.add(itr.next());
						}
						Collections.sort(members);
						for (int j = 0; j < members.size(); j++)
							System.out.println(members.get(j));
						break;
					}
				}

			}

		}

		br.close();
	}

}
