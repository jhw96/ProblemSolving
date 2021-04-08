package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution_SWEA_7701_염라대왕의이름정렬_D4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			HashSet<String> hash = new HashSet<String>();

			for (int i = 0; i < N; i++) {
				hash.add(br.readLine());
			}

			String[] names = new String[hash.size()];

			Iterator<String> itr = hash.iterator();

			int idx = 0;
			
			while (itr.hasNext())
				names[idx++] = itr.next();

			Arrays.sort(names, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.length() == o2.length()) {
						return o1.compareTo(o2);
					}
					return o1.length() - o2.length();
				}

			});

			System.out.println("#" + tc);
			for (int i = 0; i < names.length; i++)
				System.out.println(names[i]);

		}

		br.close();
	}

}
