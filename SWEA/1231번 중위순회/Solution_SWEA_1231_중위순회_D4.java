package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_1231_중위순회 {

	public static void inorder(char[] tree, int start, int size) {
		if (start * 2 <= size)
			inorder(tree, start * 2, size);
		System.out.print(tree[start]);
		if ((start * 2 + 1) <= size)
			inorder(tree, (start * 2 + 1), size);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[] trees = new char[N + 1];

			for (int i = 1; i <= N; i++) { // 트리 만들기
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				trees[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
			}
			System.out.print("#" + tc + " ");
			inorder(trees, 1, N);
			System.out.println();
		}

		br.close();
	}

}
