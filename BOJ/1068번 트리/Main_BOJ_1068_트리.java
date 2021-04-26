package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ_1068_트리 {
	static ArrayList<Integer>[] child;// idx 번째 노드의 자식들 (방향 그래프)
	static ArrayList<Integer> root;
	static int[] parent;
	static boolean[] visited;
	static int answer = 0;

	public static void delete(int remove) {
//		System.out.println(remove + " 번 노드 제거");

		for (int i = 0; i < child[remove].size(); i++) {
			int next = child[remove].get(i);
//			System.out.println(next + " 번을 제거하자!");
			if (!visited[next]) {
				visited[next] = true;
				delete(next);
			}
		}
	}

	public static void DFS(int start) {
//		System.out.println(start + " 번의 노드 시작");
		visited[start] = true;
		boolean flag = true;
		
		for (int i = 0; i < child[start].size(); i++) {
			int next = child[start].get(i);
//			System.out.println(next + " 번의 방문여부 : " + visited[next]);
			if (!visited[next]) {
				flag = false;
				DFS(next);
			}
		}
		
		if(flag)
			answer++;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		child = (ArrayList<Integer>[]) new ArrayList[N];
		root = new ArrayList<Integer>();
		parent = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			child[i] = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
			if (parent[i] == -1) { // 부모가 없으면 루트
				root.add(i);
			} else {
				child[parent[i]].add(i);
			}
		}

//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			System.out.println(i + " 번의 자식들");
//			for (int j = 0; j < child[i].size(); j++)
//				System.out.print(child[i].get(j) + " ");
//			System.out.println();
//		}

		int remove = Integer.parseInt(br.readLine()); // 제거해야할 노드

		visited[remove] = true;
		delete(remove);
//		System.out.println(Arrays.toString(visited));

		for (int i = 0; i < root.size(); i++) {
			int start = root.get(i);
//			System.out.println(start+ " 번 노드 탐색");
			if (!visited[start])
				DFS(start);
		}

		System.out.println(answer);

		br.close();
	}

}
