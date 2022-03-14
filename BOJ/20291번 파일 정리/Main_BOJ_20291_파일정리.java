package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BOJ_20291_파일정리 {

	static class Node implements Comparable<Node> {
		String fileType;
		int cnt;

		Node(String fileType, int cnt) {
			this.fileType = fileType;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			if (this.fileType.compareTo(o.fileType) > 0)
				return 1;
			else
				return -1;
		}
	} // Node end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());

		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < cnt; i++) {
			String input = br.readLine();
			input = input.replace('.', ' ');
			StringTokenizer st = new StringTokenizer(input, " ");

			st.nextToken();
			String fileType = st.nextToken();

			if (map.containsKey(fileType)) {
				int beforeCnt = map.get(fileType);
				map.put(fileType, beforeCnt + 1);
			} else
				map.put(fileType, 1);

		}

		ArrayList<Node> result = new ArrayList<Node>();

		Iterator<String> keys = map.keySet().iterator();

		while (keys.hasNext()) {
			String key = keys.next();
			int nowCnt = map.get(key);
			result.add(new Node(key, nowCnt));
		}

		Collections.sort(result);

		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).fileType + " " + result.get(i).cnt);
		}

		br.close();
	} // main end

}
