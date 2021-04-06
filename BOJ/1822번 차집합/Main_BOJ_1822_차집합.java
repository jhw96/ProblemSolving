package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_BOJ_1822_차집합 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		HashSet<Integer> A = new HashSet<Integer>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < a; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<b; i++) {
			int B = Integer.parseInt(st.nextToken());
			if(A.contains(new Integer(B))) {
				A.remove(new Integer(B));
			}
		}
		
		if(A.size() == 0) {
			System.out.println(0);
			return;
		}
		
		
		int[] arr = new int[A.size()];
		Iterator<Integer> itr = A.iterator();
		int index = 0;
		while(itr.hasNext()) {
			arr[index] = itr.next();
			index++;
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr.length);
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		
		
		

		br.close();
	}

}
