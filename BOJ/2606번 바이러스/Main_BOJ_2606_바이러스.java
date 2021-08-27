package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2606_바이러스 {

	static int N, M; // 컴퓨터의 수, 그래프 정보 입력 수
	static int[] root;

	private static void make_set() { // 분리 집합 초기 설정 메소드
		for (int i = 1; i <= N; i++)
			root[i] = i;
	}

	private static int find(int x) { // 루트가 누구인지 찾으면서 경로 압축
		if (x == root[x]) {
			return x;
		} else
			return root[x] = find(root[x]);
	}

	private static void union(int x, int y) { // 두개의 분리집합 루트를 찾아서 합치기
		int rootX = find(x);
		int rootY = find(y);
		
		if (rootX == rootY)
			return;

		root[rootY] = rootX;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		root = new int[N + 1];

		make_set(); // N개의 컴퓨터 분리집합 만들어주기

		for (int i = 0; i < M; i++) { // 양방향 그래프 정보 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			union(to, from); // 컴퓨터 연결시키기
		}

		for (int i = 1; i <= N; i++) // 모든 컴퓨터 root 통일시키기
			find(i);

		int answer = 0;
		int compare = 0;
		
		for (int i = 2; i <= N; i++) { // 1번 컴퓨터의 루트와 숫자가 같으면 같은 분리집합
			if (root[i] == root[1]) {
				answer++;
			}
		}
		
		System.out.println(answer);

		br.close();
	}

}
