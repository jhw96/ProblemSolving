package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14912_숫자빈도수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		for(int i=1; i<=n; i++) {
			String value = String.valueOf(i);
			for(int j=value.length()-1; j>=0; j--)
				if(value.charAt(j) -'0' == d)
					answer++;
		}
		
		System.out.println(answer);
		
		
		
		br.close();
	}

}
