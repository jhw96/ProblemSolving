package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_5464_주차장 {

	static int N, M; // 주차공간의 개수, 차량의 개수
	static int[] fee; // 단위무게당 주차요금
	static int[] carWeight; // 자동차 무게
	static Queue<Integer> wait = new LinkedList<>(); // 대기하는 차량들
	static Map<Integer, Integer> status = new HashMap<Integer, Integer>(); // 주차상황
	static PriorityQueue<Integer> emptyPlace = new PriorityQueue<>(); // 비어있는 곳 표시

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		fee = new int[N + 1];
		carWeight = new int[M + 1];

		for (int i = 1; i <= N; i++) {
			fee[i] = Integer.parseInt(br.readLine());
			emptyPlace.add(i);
		}

		for (int i = 1; i <= M; i++) {
			carWeight[i] = Integer.parseInt(br.readLine());
		}

//		System.out.println(Arrays.toString(fee));
//		System.out.println(Arrays.toString(carWeight));

		int answer = 0;
		String input = "";
		while ((input = br.readLine()) != null) {
			int carNum = Integer.parseInt(input);
			if (carNum > 0) { // 차량이 들어오는 경우
				if (emptyPlace.size() > 0) { // 주차자리가 있는 경우
					int top = emptyPlace.poll();
					answer += (carWeight[carNum] * fee[top]);
					status.put(carNum, top);
				} else { // 주차자리가 없는 경우 대기시키기
					wait.add(carNum);
				}

			} else if (carNum < 0) { // 차량이 나가는 경우
				carNum *= -1;
				int place = status.get(carNum);
				status.remove(carNum);

				if (wait.size() > 0) { // 대기 차량이 있는 경우
					int next = wait.poll();
					status.put(next, place);
					answer += (carWeight[next] * fee[place]);
				} else { // 대기 차량이 없는 경우
					emptyPlace.add(place);
				}
			}
		}

		System.out.println(answer);

		br.close();
	}

}
