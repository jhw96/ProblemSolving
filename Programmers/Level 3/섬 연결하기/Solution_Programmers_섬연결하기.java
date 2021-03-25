package com.programmers;

public class Solution_Programmers_섬연결하기 {

	public static void main(String[] args) { // 프림 알고리즘
		int n = 4;
		int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
		
		
		int[][] adj = new int[n][n];
		boolean[] visited = new boolean[n];
		int[] minEdge = new int[n]; // 최소신장트리에 연결된 각 정점의 최소 가중치 값
		
		for(int i=0; i<costs.length; i++) { // 무방향 가중치 그래프 입력
			adj[costs[i][0]][costs[i][1]] = costs[i][2];
			adj[costs[i][1]][costs[i][0]] = costs[i][2];
		}
		
		
		for(int i=0; i<n; i++) 
			minEdge[i] = Integer.MAX_VALUE;
		minEdge[0] = 0; // 임의의 시작점으로 0 세팅
		
		
		int min = 0, minVertex= 0, answer = 0;
		for(int i=0; i<n; i++) {
			min = Integer.MAX_VALUE;
			
			for(int v=0; v<n; v++) { // 방문하지 않았고 최소신장트리에 연결이 가능한 최소 가중치를 가진 정점 선택 
				if(!visited[v]&& min > minEdge[v]) {
					min = minEdge[v];
					minVertex = v;
				}
			}
			
			visited[minVertex] = true;
			answer += minEdge[minVertex];
			
			for(int v=0; v<n; v++) {
				if(!visited[v] && adj[minVertex][v] != 0) { // 아직 최소신장트리에 연결하지 않았고 연결이 가능한 간선들을 최소 가중치로 갱신
					minEdge[v] = Math.min(minEdge[v], adj[minVertex][v]);
				}
			}
			
		}
		
		System.out.println(answer);
		
		
		
	} // main end
} // class end
