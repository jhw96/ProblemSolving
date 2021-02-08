package com.programmers;

import java.util.Arrays;
import java.util.Collections;

public class Solution_Programmers_최솟값만들기 {

	public static void main(String[] args) {
		int[] A = { 1, 4, 2 };
		int[] B = { 5, 4, 4 };
		int answer = 0;
		int length = B.length;

		Integer[] temp = new Integer[length];

		for (int i = 0; i < length; i++)
			temp[i] = B[i];

		Arrays.sort(A);
		Arrays.sort(temp, Collections.reverseOrder());

		for (int i = 0; i < length; i++)
			answer += (A[i] * temp[i]);

		System.out.println(answer);
	}

}
