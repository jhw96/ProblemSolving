package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BOJ_2910_빈도정렬 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] arr = new int[N]; // 입력받을 수열
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Map<Integer, int[]> map = new HashMap<>(); // Key : 숫자, int[] : 출연빈도, 출연순서
		Set<Integer> set = new HashSet<>(); // 출연했는지 체크용

		int turn = 0;

		for (int i = 0; i < N; i++) {
			if (!set.contains(arr[i])) { // 처음 출연하는 숫자라면
				map.put(arr[i], new int[] { 1, ++turn });
				set.add(arr[i]);
			} else { // 이미 출연했었던 숫자라면
				int[] nums = map.get(arr[i]);
				int cnt = nums[0]; // 출연빈도
				int nowTurn = nums[1]; // 출연순서
				map.put(arr[i], new int[] { cnt + 1, nowTurn });
			}
		}

		ArrayList<int[]> result = new ArrayList<>(); // 최종 결과 저장용

		for (int key : map.keySet()) { // key를 이용해서 map의 값들 받아내기
			int[] nums = map.get(key);
			result.add(new int[] { key, nums[1], nums[0] }); // 0: 값 , 1: 출연순서, 2: 출연빈도
		}

		Collections.sort(result, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] != o2[2]) { // 출연빈도가 다르면
					return o2[2] - o1[2];
				} else { // 출연빈도가 같으면
					return o1[1] - o2[1];
				}
			}

		});

		for (int i = 0; i < result.size(); i++) {
			int[] nums = result.get(i);

			for (int j = 0; j < nums[2]; j++)
				System.out.print(nums[0] + " ");
		}
		
		System.out.println();
		
		br.close();
	}

}
