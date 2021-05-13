package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_13335_트럭 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		Queue<int[]> truck = new LinkedList<int[]>(); // 다리를 지나는 트럭의 무게와 남은 시간
		int n = Integer.parseInt(st.nextToken()); // 트럭의 개수
		int w = Integer.parseInt(st.nextToken()); // 다리의 길이
		int l = Integer.parseInt(st.nextToken()); // 다리의 최대 하중
		int answer = 0;

		int[] weight = new int[n];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++)
			weight[i] = Integer.parseInt(st.nextToken());
		int totalWeight = 0;
		int idx = 0;
		while (true) { // 트럭 넣기
			if (idx < n) { // 마지막 트럭까지만 넣기
				if (totalWeight + weight[idx] <= l) { // 다리가 트럭올려도 견딜 수 있으면 트럭 올리기
					truck.add(new int[] { weight[idx], w });
					totalWeight += weight[idx];
					idx++;
				}
			}

			int size = truck.size();
			if (size == 0)
				break;

			for (int i = 0; i < size; i++) { // 다리에 있는 트럭들 한번씩 움직이기(1초동안 발생)
				int[] top = truck.poll();
				top[1]--; // 한칸 움직임
				if (top[1] != 0) // 아직 다리를 지나지 못했으면
					truck.add(new int[] { top[0], top[1] });
				else { // 다리를 지났으면 다리 위에 무게 줄이기
					totalWeight -= top[0];
				}
			}

			answer++; // 1초 지남
		}

		System.out.println(answer);
		br.close();
	}

}
