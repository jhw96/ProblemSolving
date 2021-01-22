package com.swea;

import java.util.*;

public class BinaryPresent {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int compare = 1;
			for (int i = 1; i < N; i++) {
				compare += (int) Math.pow(2, i);
			}

			if ((compare & M) == compare)
				System.out.println("#" + tc + " ON");
			else
				System.out.println("#" + tc + " OFF");

		}

	}
}
