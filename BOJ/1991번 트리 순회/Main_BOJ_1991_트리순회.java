package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_BOJ_1991_트리순회 {

	static Map<Integer, Character> map = new HashMap<Integer, Character>(); // 트리에서 노드번호, 해당 알파벳
	static Map<Character, Integer> tree = new HashMap<Character, Integer>();

	public static void preOrder(char start) { // 전위 순회
		System.out.print(start);

		int startIdx = tree.get(start);

		int leftChild = startIdx * 2;
		int rightChild = leftChild + 1;
		if (map.containsKey(leftChild))
			preOrder(map.get(leftChild));
		if (map.containsKey(rightChild))
			preOrder(map.get(rightChild));
	}

	public static void inOrder(char start) { // 중위 순회
		int startIdx = tree.get(start);

		int leftChild = startIdx * 2;
		int rightChild = leftChild + 1;

		if (map.containsKey(leftChild))
			inOrder(map.get(leftChild));

		System.out.print(start);

		if (map.containsKey(rightChild))
			inOrder(map.get(rightChild));

	}

	public static void postOrder(char start) { // 후위 순회
		int startIdx = tree.get(start);

		int leftChild = startIdx * 2;
		int rightChild = leftChild + 1;

		if (map.containsKey(leftChild))
			postOrder(map.get(leftChild));
		
		if (map.containsKey(rightChild))
			postOrder(map.get(rightChild));

		System.out.print(start);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		tree.put('A', 1);

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			int parentIdx = tree.get(parent);
			map.put(parentIdx, parent);

			if (left >= 'A' && left <= 'Z') {
				tree.put(left, parentIdx * 2);
			}
			if (right >= 'A' && right <= 'Z') {
				tree.put(right, parentIdx * 2 + 1);
			}
		}

		preOrder('A');
		System.out.println();
		inOrder('A');
		System.out.println();
		postOrder('A');

		br.close();
	}

}
