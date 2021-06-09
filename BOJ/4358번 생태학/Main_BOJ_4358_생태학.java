package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main_BOJ_4358_생태학 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int total = 0; // 나무 전체의 개수
		String input = " ";
		Map<String, Integer> map = new HashMap<String, Integer>();

		while ((input = br.readLine()) != null) {
			total++;

			if (map.containsKey(input)) { // 이미 입력 받았다면
				int cnt = map.get(input);
				cnt += 1;
				map.put(input, cnt);
			} else {
				map.put(input, 1);
			}

		}

		Set<String> keySet = map.keySet();
		Iterator<String> itr = keySet.iterator();
		String[] keys = new String[keySet.size()];

		int idx = 0;
		while (itr.hasNext()) {
			keys[idx++] = itr.next();
		}

		Arrays.sort(keys);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			double value = ((double) map.get(key) / total * 100);
			sb.append(key + " " + String.format("%.4f", value) + "\n");
		}
		System.out.println(sb.toString());
		
		br.close();
	}

}
