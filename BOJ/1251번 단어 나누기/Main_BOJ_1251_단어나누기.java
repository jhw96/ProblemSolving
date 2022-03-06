package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_BOJ_1251_단어나누기 {

	public static void main(String[] args) throws Exception {
		List<String> list = new ArrayList<String>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] tmp = new String[3];

		// 길이가 1 이상인 단어로 잘라야함 but 1만큼 자를 시 뒤집을때 자르나마나 이므로 2부터
		for (int i = 1; i < input.length() - 1; ++i) {
			for (int j = i + 1; j < input.length(); ++j) {
				tmp[0] = input.substring(0, i);
				tmp[1] = input.substring(i, j);
				tmp[2] = input.substring(j, input.length());

				StringBuffer sb = new StringBuffer();

				// 3개로 나눈 단어 뒤집기
				for (int k = 0; k < 3; k++) {
					for (int l = tmp[k].length() - 1; l >= 0; l--) {
						sb.append(Character.toString(tmp[k].charAt(l)));
					}
				}
				
				list.add(sb.toString());
			}
		}

		Collections.sort(list);
		
		System.out.println(list.get(0));

		br.close();
	} // main end

}
