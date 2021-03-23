package com.programmers;

public class Solution_Programmers_정수삼각형 {

	public static void main(String[] args) {
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };

		int sideLength = 2; // 삼각형 높이에 따른 요소 갯수

		int[][] dp = new int[triangle.length][]; // 삼각형의 각 요소에 따른 최댓값
		
		dp[0] = new int[] { triangle[0][0] }; // 삼각형 맨 위 꼭지점

		for (int i = 1; i < triangle.length; i++) { // 삼각형 높이마다 탐색
			dp[i] = new int[sideLength];

			for (int j = 0; j < sideLength; j++) { // 각 층의 삼각형 요소 탐색
				if (j == 0) { // 맨 왼쪽 요소일 경우
					dp[i][j] = triangle[i][j] + dp[i - 1][j];
					continue;
				}
				if (j == sideLength - 1) { // 맨 오른쪽 요소일 경우
					dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
					continue;
				}
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
			}

			sideLength++;
		}

		int max = 0;
		for(int i=0; i<dp[triangle.length-1].length; i++) {
			if(max < dp[triangle.length-1][i])
				max = dp[triangle.length-1][i];
		}
		
		System.out.println(max);

	}

}
