package com.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_Jungol_1141_불쾌한날 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<int[]> stack = new Stack<int[]>(); // 0: 몇번째 소 , 1: 소의 크기

		int N = Integer.parseInt(br.readLine());
		int[] cows = new int[N + 1]; // 소의 크기 저장할 배열
		int index = N;

		for (int i = 1; i <= N; i++) // 1번 소부터 N번 소까지 크기 입력
			cows[i] = Integer.parseInt(br.readLine());

		long answer = 0;

		while (index >= 1) { // N번째 소부터 1번째 소까지 (오른쪽에서 왼쪽으로 반대로)
			int compare = cows[index]; // 비교할 소의 크기
			boolean flag = false;

			while (!stack.isEmpty()) {
				int[] top = stack.pop(); // 0: 몇번째 소인지 , 1: 소의 크기

				if (top[1] >= compare) { // 현재 비교하는 소보다 앞에 더 크거나 같은 소가 나오면
//					System.out.println("앞에 더 큰 소 있음");
//					System.out.println("index : "+ index + " -> " + "큰 소 번호 : " + top[0] + " 현재 소 번호 : " + index);
//					System.out.println((top[0] - index - 1) + "만큼 더 함");
					answer += (top[0] - index - 1); // 그 소의 번호 - 현재 소의 번호
					flag = true;
					stack.push(top);
					break;
				}
			}

			if (!flag) { // 앞에 더 큰 소가 나타나지 않았으면
//				System.out.println("앞에 큰 소 없음");
//				System.out.println("index : "+ index + " -> " + (N - index));
//				System.out.println((N-index) + " 만큼 더 함");
				answer += (N - index);
				
			}

			stack.push(new int[] { index, compare }); // 현재 비교한 소의 순서와 크기 stack에 넣기
			index--;
		}
		
		System.out.println(answer);

		br.close();
	}
}
