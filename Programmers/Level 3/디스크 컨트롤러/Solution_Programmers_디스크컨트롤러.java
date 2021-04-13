package com.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution_Programmers_디스크컨트롤러 {

	public static void main(String[] args) {
		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
//		int[][] jobs = { { 0, 5 }, { 2, 10 }, { 5000, 2 } };

		Arrays.sort(jobs, new Comparator<int[]>() { // 작업 요청 시간 순대로 정렬하기
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		// 작업이 짧은 순서대로 넣기
		Queue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1] - o2[1];
			}
		});

		int second = -1, idx = 0;
		long sum = 0; // 종료시간 누적합
		int end = 0;
		boolean flag = false;

		while (true) {
			second++;

			while (true) { // 시간 초에 따라 우선순위 큐에 작업넣기
				if (idx < jobs.length && jobs[idx][0] == second)
					pq.add(jobs[idx]);
				else
					break;
				idx++;
			}

			if (!flag && !pq.isEmpty() && second <= pq.peek()[0]) { // 앞에 작업이 없으면
				int[] top = pq.poll();
				sum += second + top[1] - top[0]; // 종료까지 걸린 시간
				end = second + top[1]; // 종료하는 시간
				flag = true;
				System.out.println(end + " 초에 종료");
			}
			if(flag) { // 앞에 작업이 있으면
				if(end <= second) { // 앞에 작업이 종료했으면
					if(pq.isEmpty()) flag = false;
					else {
						if(pq.peek()[0] <= second) {
							int[] top = pq.poll();
							sum += second + top[1] - top[0]; // 종료까지 걸린 시간
							end = second + top[1];
							System.out.println(end + " 초에 종료");
						}
					}
				}
				
			}
//			System.out.println(pq.size() + " <- 사이즈");

			if (idx > jobs.length - 1 && pq.isEmpty()) // 처리해야할 작업을 모두 훑어봤다면
				break;

		}

		System.out.println(sum);

		System.out.println(sum / jobs.length);

	} // main end

} // class end
