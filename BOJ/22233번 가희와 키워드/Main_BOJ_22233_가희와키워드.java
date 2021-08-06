package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BOJ_22233_가희와키워드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		Set<String> set = new HashSet<String>();

		int N = Integer.parseInt(st.nextToken()); // 메모장의 글 개수
		int M = Integer.parseInt(st.nextToken()); // 블로그에 글 쓰는 횟수

		for (int i = 0; i < N; i++) {
			String memo = br.readLine();
			set.add(memo);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), ",");
			while(st.hasMoreTokens()) {
				String blog = st.nextToken();
				if(set.contains(blog))
					set.remove(blog);
			}
			System.out.println(set.size());
		}

		br.close();
	}

}
