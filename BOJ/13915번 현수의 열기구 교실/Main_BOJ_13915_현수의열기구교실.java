package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_BOJ_13915_현수의열기구교실 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		while ((input = br.readLine()) != null) {
			int N = Integer.parseInt(input);
			int answer = 0;
			Set<String> kind = new HashSet<String>();

			for (int i = 0; i < N; i++) {
				boolean[] num = new boolean[10];
				StringBuilder sb = new StringBuilder();

				String score = br.readLine();
				
				for (int j = 0; j < score.length(); j++) {
					int change = score.charAt(j) - '0';
					if (!num[change])
						num[change] = true;
				}
				
				for(int j=1; j<=9; j++) {
					if(num[j])
						sb.append(j);
				}
				
				if(!kind.contains(sb.toString())) {
					kind.add(sb.toString());
					answer++;
				}
			}
			System.out.println(answer);

		}

		br.close();
	}

}
