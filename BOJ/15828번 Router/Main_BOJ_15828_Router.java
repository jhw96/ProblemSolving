package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_BOJ_15828_Router {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 라우터 버퍼의 크기

		Queue<Integer> router = new LinkedList<Integer>();

		while (true) {
			int num = Integer.parseInt(br.readLine());

			if (num == -1)
				break;

			if (num == 0) // 패킷 처리
				router.poll();
			else { // 패킷 입력
				if (router.size() < N) { // 버퍼가 가득 찼을 때
					router.add(num);
				}
			}
		}

		int size = router.size();

		if (size == 0)
			System.out.println("empty");
		else
			for (int i = 0; i < size; i++)
				System.out.print(router.poll() + " ");

		br.close();
	}

}
