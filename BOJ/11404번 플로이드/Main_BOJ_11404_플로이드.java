package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_11404_플로이드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 도시의 갯수
		int m = Integer.parseInt(br.readLine()); // 버스의 갯수
		int[][] adj = new int[n+1][n+1]; // 방향 가중치 그래프

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			if(adj[to][from] == 0)
				adj[to][from] = weight;
			else
				adj[to][from] = Math.min(adj[to][from], weight);
		}
		
		for(int i=1; i<=n; i++)
			for(int j=1; j<=n; j++) {
				if(i!=j && adj[i][j] == 0)
					adj[i][j] = Integer.MAX_VALUE;
			}
		
 
		for (int k = 1; k <= n; k++) {
			for (int start = 1; start <= n; start++) {
				if (k != start)
					for (int end = 1; end <= n; end++) {
						if (start != end && end != k) {
							if (adj[start][k] != Integer.MAX_VALUE && adj[k][end] != Integer.MAX_VALUE)
								adj[start][end] = Math.min(adj[start][end], adj[start][k] + adj[k][end]);
						}
					}
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i!=j && adj[i][j] == Integer.MAX_VALUE)
					adj[i][j] = 0;
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}

		br.close();
	}

}
