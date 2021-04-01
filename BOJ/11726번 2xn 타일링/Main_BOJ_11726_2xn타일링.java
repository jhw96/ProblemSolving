package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BOJ_11726_2xn타일링 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1001]; // idx번째 직사각형을 채우는 수 ( 1칸 전에 2x1로 하는 방법과 (세로x가로) 2칸 전에 1x2(세로x가로)로 하는 방법이 있다. )
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2; i<=N; i++)
			dp[i]= (dp[i-2] + dp[i-1])%10007;
		
		System.out.println(dp[N]);
		
		
		br.close();
	}

}
