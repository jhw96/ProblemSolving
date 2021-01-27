package com.baekjoon;

// 땅따먹기
public class LandWar {
	public static void main(String[] args) {
		int answer = 0;
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		int cLength = land[0].length;
        int rLength = land.length;
        
		
		
		for (int i = 1; i < rLength; i++) { // 행 탐색
			for (int j = 0; j < cLength; j++) { // 열 탐색
				int max = 0;
				for (int k = 0; k < cLength; k++) { // 현재 밟을 열
					if (k != j) { // 같은 열이 아니면 이전 값 중 가장 큰 값 찾아내기
						max = Math.max(land[i - 1][k], max);
					}
				}
				land[i][j] += max;
                if(i == (rLength - 1))
                    answer = Math.max(answer, land[i][j]);
			}
		}
		
		System.out.println(answer);
		/*
		 * int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}}; int [][] dp = new int[3][4];
		 * 
		 * for(int i=0; i<4; i++) dp[0][i] = land[0][i];
		 * 
		 * int cLength = land[0].length;
		 * 
		 * for(int i=1; i<land.length; i++) { for(int j=0; j<cLength; j++) { for(int
		 * k=0; k<cLength; k++) { // 현재 밟을 열 if(k != j) { // 같은 열이 아니면 dp[i][k] =
		 * Math.max(dp[i][k], dp[i-1][j] + land[i][k]); } } } }
		 * 
		 * for(int i=0; i<cLength; i++) System.out.println(dp[2][i]);
		 */

	}
}
