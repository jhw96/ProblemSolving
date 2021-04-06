package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3289_서로소집합 {

	static int[] parents;

	static void make(int n) {
		parents = new int[n + 1];
		for (int i = 1; i <= n; i++)
			parents[i] = i;
	}
	
	static int findset(int n) {
		if(parents[n] == n) 
			return n;
		else 
			return parents[n] = findset(parents[n]);
	}
	
	static boolean union(int a, int b) {
		int aParent = findset(a);
		int bParent = findset(b);
		if(aParent == bParent) return false;
		
		parents[bParent] = aParent; // b그룹의 대표를 a로 만듦
		
		return true;
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder().append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			make(n);

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int c = Integer.parseInt(st.nextToken());
				int num1 = Integer.parseInt(st.nextToken());
				int num2=Integer.parseInt(st.nextToken());
				
				if(c==0)
					union(num1,num2);
				else {
					if(findset(num1) == findset(num2)) // 같은 대표이면
						sb.append(1);
					else
						sb.append(0);
				}
					
			}
			System.out.println(sb.toString());
		}

		br.close();
	}

}
