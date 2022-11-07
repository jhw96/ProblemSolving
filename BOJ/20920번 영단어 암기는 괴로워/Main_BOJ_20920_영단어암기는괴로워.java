package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main_BOJ_20920_영단어암기는괴로워 {

	public static void main(String[] args) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N, M; // 단어입력 개수, 기억할 최소 단어 길이
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();

			if (tmp.length() >= M) {
				int cnt = 0;
				if (map.get(tmp) != null)
					cnt = map.get(tmp);
				map.put(tmp, cnt + 1);
			}
		}

//		자주 나오는 단어일수록 앞에 배치한다.
//		해당 단어의 길이가 길수록 앞에 배치한다.
//		알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다

		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				if (obj1.getValue() > obj2.getValue()) // 앞에 나오는 단어의 횟수가 더 잦으면 바꾸기
						return -1;
				else
				{
					if(obj1.getValue() == obj2.getValue()) // 단어의 횟수가 같으면
					{
						if(obj1.getKey().length() > obj2.getKey().length()) // 단어의 길이가 길면 앞으로
							return -1;
						else if(obj1.getKey().length() == obj2.getKey().length()) // 단어의 길이가 같으면
						{
							return obj1.getKey().compareTo(obj2.getKey()); // 알파벳 사전 순 앞으로
						}
						else
							return 1;
					}
					else 
						return 1;
				}
			}
		});
		


		for (int i = 0; i < list.size(); i++)
			bw.write(list.get(i).getKey() + "\n");

		bw.flush();

		bw.close();
		br.close();

	}

}
