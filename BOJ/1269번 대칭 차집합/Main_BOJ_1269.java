package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BOJ_1269 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		Set<Integer> aSet = new HashSet<Integer>();
		Set<Integer> bSet = new HashSet<Integer>();
		

		st = new StringTokenizer(br.readLine(), " ");

		int aSize = Integer.parseInt(st.nextToken());
		int bSize = Integer.parseInt(st.nextToken());

		int[] A = new int[aSize];
		int[] B = new int[bSize];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < aSize; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			aSet.add(A[i]);
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < bSize; i++) {
			B[i] = Integer.parseInt(st.nextToken());
			bSet.add(B[i]);
		}
		
		for(int i=0; i<bSize; i++)
			aSet.remove(B[i]);
		
		for(int i=0; i<aSize; i++)
			bSet.remove(A[i]);
		
		System.out.println(aSet.size()+bSet.size());
		

		br.close();
	}
}
