package com.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_10032_과자분배 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N= Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			
			answer = N%K;
			
			
			
			
			System.out.println("#" + tc + " " + answer);
		}

		
		br.close();
	}

}
