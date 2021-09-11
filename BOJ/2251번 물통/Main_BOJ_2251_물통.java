/*
 * 3가지의 물통이 주어지고 세번째 물통에는 물을 꽉 채워서 준다.
 * 물을 옮길때 한쪽이 가득차거나 한쪽이 빌 때까지 계속 넣어야함
 * 그냥 단순하게 가위바위보처럼 모든 경우를 BFS로 탐색하면 된다.
 * 너무 귀찮은 문제
 * 그리고 정답조건이 첫번째 물통이 비어있을 때 세번째 물통의 가능한 물의 양을 찾는 거였는데
 * 제대로 안 읽어보고 그냥 세가지 물통의 모든 가능한 수를 넣어서 계속 틀림
 * 조건 좀 잘 읽자 제발;
 */

package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BOJ_2251_물통 {

	static int[] WaterBottle = new int[4]; // 물통 크기
	static boolean[][][] visited;

	static ArrayList<Integer> answer = new ArrayList<>();
	static Set<Integer> set = new HashSet<>();

	private static void BFS() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, WaterBottle[3] });

		while (!q.isEmpty()) {
			int[] top = q.poll();

			int first = top[0];
			int second = top[1];
			int third = top[2];

			if (visited[first][second][third])
				continue;

			visited[first][second][third] = true;

			if(first ==0) { // 첫번째 물통이 비어있을 때 세번째 물통 양 구하기(구해야 하는 정답)
				if(!set.contains(third)) {
					set.add(third);
					answer.add(third);
				}
			}

			// 첫번째 -> 두번째
			if (first + second > WaterBottle[2])
				q.add(new int[] { first + second - WaterBottle[2], WaterBottle[2], third });
			else
				q.add(new int[] { 0, first + second, third });

			// 첫번째 -> 세번째
			if (first + third > WaterBottle[3])
				q.add(new int[] { first + third - WaterBottle[3], second, WaterBottle[3] });
			else
				q.add(new int[] { 0, second, first + third });

			// 두번째 -> 첫번째
			if (second + first > WaterBottle[1])
				q.add(new int[] { WaterBottle[1], first + second - WaterBottle[1], third });
			else
				q.add(new int[] { first + second, 0, third });

			// 두번째 -> 세번째
			if (second + third > WaterBottle[3])
				q.add(new int[] { first, second + third - WaterBottle[3], WaterBottle[3] });
			else
				q.add(new int[] { first, 0, second + third });

			// 세번째 -> 첫번째
			if (third + first > WaterBottle[1])
				q.add(new int[] { WaterBottle[1], second, first + third - WaterBottle[1] });
			else
				q.add(new int[] { first + third, second, 0 });

			// 세번째 -> 두번째
			if (third + second > WaterBottle[2])
				q.add(new int[] { first, WaterBottle[2], third + second - WaterBottle[2] });
			else
				q.add(new int[] { first, second + third, 0 });
		}

	} // BFS end

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= 3; i++)
			WaterBottle[i] = Integer.parseInt(st.nextToken());

		visited = new boolean[WaterBottle[1] + 1][WaterBottle[2] + 1][WaterBottle[3] + 1];

		BFS();

		Collections.sort(answer);
		
		for (int i = 0; i < answer.size(); i++) {
			if (i != answer.size() - 1)
				System.out.print(answer.get(i) + " ");
			else
				System.out.print(answer.get(i));
		}

		br.close();
	}

}
