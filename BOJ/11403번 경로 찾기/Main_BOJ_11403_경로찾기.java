package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11403_경로찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] adj = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
				if (adj[i][j] == 0) {
					adj[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		for (int k = 0; k < N; k++) {
			for (int start = 0; start < N; start++) {
				if (start != k) {
					for (int end = 0; end < N; end++) {
						if (k != end && start != end) {
							if (adj[start][k] != Integer.MAX_VALUE && adj[k][end] != Integer.MAX_VALUE)
								adj[start][end] = Math.min(adj[start][end], adj[start][k] + adj[k][end]);
						}
					}
				}
			}
		}


		int[][] result = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (adj[i][j] == Integer.MAX_VALUE) { // 갈 수 없는 경우
					if (i == j) { // 자기 자신인 경우
						for(int k=0; k<N; k++) {
							if(i!=k) {
								if(adj[i][k] != Integer.MAX_VALUE) {
									if(adj[k][i] != Integer.MAX_VALUE) {
										result[i][j] = 1;
										break;
									}
								}
							}
						}

					} else { // 자기 자신이 아닌 경우
						result[i][j] = 0;
					}
				} else {
					result[i][j] = 1;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)
				System.out.print(result[i][j] + " " );
			System.out.println();
		}

		br.close();
	}

}
