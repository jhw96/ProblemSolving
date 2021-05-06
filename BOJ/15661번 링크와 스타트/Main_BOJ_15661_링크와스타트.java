package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_15661_링크와스타트 {

	static int N;
	static int[][] scope;
	static boolean[] teamA;
	static int min = Integer.MAX_VALUE;

	private static void calDiff() {
		int aScope = 0, bScope = 0;

		for (int i = 1; i <= N; i++) { // A팀 점수 계산하기
			if (teamA[i]) {
				for (int j = 1; j <= N; j++) {
					if (i != j && teamA[j]) { // 자기 자신이 아니고 A팀이면
						aScope += scope[i][j];
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) { // B팀 점수 계산하기
			if (!teamA[i]) {
				for (int j = 1; j <= N; j++) {
					if (i != j && !teamA[j]) { // 자기 자신이 아니고 B팀이면
						bScope += scope[i][j];
					}
				}
			}
		}

		if (min > Math.abs(aScope - bScope))
			min = Math.abs(aScope - bScope);
	}

	private static void makeTeam(int start, int step) { // 팀 뽑기 (조합으로 만들기)
		if (step == N) { // 한쪽 팀에 한명은 남겨야함
			return;
		}

		for (int i = start; i <= N; i++) {
			teamA[i] = true; // 현재 A팀을 뽑힌 사람 표시
			makeTeam(i + 1, step + 1);

			calDiff();// 1명 부터 N-1명뽑았을때까지 매번 점수 계산해보기

			teamA[i] = false; // 돌아와서는 원래대로
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 사람 수
		scope = new int[N + 1][N + 1]; // 점수 조합표
		teamA = new boolean[N + 1]; // 한쪽 팀

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++)
				scope[i][j] = Integer.parseInt(st.nextToken());
		}

		makeTeam(1, 1);
		
		System.out.println(min);

		br.close();
	}

}
