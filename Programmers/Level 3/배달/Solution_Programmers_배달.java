package com.programmers;

public class Solution_Programmers_배달 {

	public static void main(String[] args) {
		int N = 6;
		int[][] road = { { 1, 2, 1 }, { 1, 3, 2 }, { 2, 3, 2 }, { 3, 4, 3 }, { 3, 5, 2 }, { 3, 5, 3 }, { 5, 6, 1 } };
		int K = 4;
//	
//		int N = 5;
//		int[][] road = { {1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2} };
//		int K = 3;

		int[][] graph = new int[N + 1][N + 1]; // 방향 가중치 그래프
		boolean[] visited = new boolean[N + 1]; // 방문여부 체크
		int[] distance = new int[N + 1]; // 시작정점에서 idx번 정점까지 가는데 걸린 최소 가중치 값 저장

		for (int i = 0; i < road.length; i++) {
			int to = road[i][0];
			int from = road[i][1];
			int weight = road[i][2];
			
			if(graph[to][from] == 0) {
			graph[to][from] = weight;
			graph[from][to] = weight;
			} else {
				int min = Math.min(graph[to][from], weight);
				graph[to][from] = min;
				graph[from][to] = min;
			}
		}

		for (int i = 2; i <= N; i++)
			distance[i] = Integer.MAX_VALUE;

		int min = 0, current = 0;
		for (int i = 1; i <= N; i++) {
			min = Integer.MAX_VALUE;

			for (int v = 1; v <= N; v++) { // 방문하지 않은 정점 중 갈 수 있는 애들 중에 최소 가중치를 갖고 있는 정점 찾기
				if (visited[v] == false && min > distance[v]) {
					min = distance[v];
					current = v;
				}
			}

			visited[current] = true;

			for (int v = 1; v <= N; v++) {
				if (visited[v] == false && graph[current][v] != 0) { // 방문하지 않았고 연결되있는 정점 중에
					// 현재 정점을 거쳐서 가는게 좋은지 , 직접 가는게 좋은지 결정하기
					distance[v] = Math.min(distance[v], distance[current] + graph[current][v]);
				}
			}

		}
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			System.out.println(distance[i]);
			if (distance[i] <= K)
				answer++;
		}

		System.out.println(answer);

	} // main end

} // class end
