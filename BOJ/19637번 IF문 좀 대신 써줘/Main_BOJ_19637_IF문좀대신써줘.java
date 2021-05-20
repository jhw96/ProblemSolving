package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
3 1
WEAK 10000
NORMAL 100000
STRONG 1000000
10001
 */

public class Main_BOJ_19637_IF문좀대신써줘 {

	static int N, M;
	static ArrayList<Integer> powers = new ArrayList<Integer>();
	static HashMap<Integer, String> map = new HashMap<Integer, String>();

	public static String search(int power) {
		int left = 0;
		int right = powers.size() - 1;
		
		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			if (powers.get(mid) > power) {
				right = mid;
			} else if (powers.get(mid) < power) {
				left = mid + 1;
			} else if(powers.get(mid) == power) {
				break;
			}
			if(mid==left && left==right)
				break;
//			System.out.println(power);
//			System.out.println(powers.get(mid));
//			System.out.println(left + " , " + mid + " , " + right);
		}
//		System.out.println("현재 비교해야하는 파워 : " + power);
//		System.out.println("소속될 파워 : " + powers.get(mid));
//		System.out.println("칭호 : " + map.get(powers.get(mid)));
//		System.out.println("idx : " + mid);
		return map.get(powers.get(mid));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		

		N = Integer.parseInt(st.nextToken()); // 칭호의 개수
		M = Integer.parseInt(st.nextToken()); // 칭호를 출력해야하는 캐릭터들의 개수

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken(); // 칭호
			int power = Integer.parseInt(st.nextToken()); // 전투력

			if (!map.containsKey(power)) { // 이미 입력되있는 전투력의 칭호라면 pass
				powers.add(power);
				map.put(power, name);
			}
		}
		Collections.sort(powers);

		for (int i = 0; i < M; i++) {
			int power = Integer.parseInt(br.readLine());
			bw.write(search(power) + "\n");
		}
		bw.flush();
		br.close();
	}

}
