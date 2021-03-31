package com.programmers;

import java.util.Arrays;

public class Solution_Programmers_구명보트 {

	public static void main(String[] args) {
		int[] people = { 70, 50, 80, 50 };
		int limit = 100;

//		int[] people = { 60, 60, 70, 80, };
//		int limit = 140;
		
		Arrays.sort(people);
		
		int answer = 0;
		int i = 0;
		
		for (int j = people.length - 1; i <= j; j--) { // j : 무거운 놈 , i : 가벼운 놈
			if (people[j] + people[i] > limit)
				answer++;
			else {
				answer++;
				i++;
			}
		}
		// 50 50 70 80
		// 100

		// 60 60 70 80
		// 140
		System.out.println(answer);

	}

}
