package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_BOJ_1431_시리얼번호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String[] guitars = new String[N];

		for (int i = 0; i < N; i++) {
			guitars[i] = br.readLine();
		}

		Arrays.sort(guitars, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() != o2.length()) // 길이가 다르면
					return o1.length() - o2.length();
				else { // 길이가 같으면
					int sum1 = 0, sum2 = 0, size = o1.length();
					for(int i=0; i<size; i++) {
						if(o1.charAt(i) >= '1' &&o1.charAt(i) <= '9')
							sum1 += o1.charAt(i) - '0';
						if(o2.charAt(i) >= '1' &&o2.charAt(i) <= '9')
							sum2 += o2.charAt(i) - '0';
					}
					if(sum1 != sum2) // 자릿수의 합이 다르면
						return sum1-sum2;
					else { // 위 두가지 방법으로 계산할 수 없으면
						return o1.compareTo(o2);
					}
				}
			}

		});
		
		for(int i=0; i<N; i++)
			System.out.println(guitars[i]);

		br.close();
	}

}
