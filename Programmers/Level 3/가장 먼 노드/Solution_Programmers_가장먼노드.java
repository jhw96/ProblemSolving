package com.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_Programmers_가장먼노드 {

	static int answer = 0;

	public static void BFS(LinkedList<Integer>[] vertex, int n) {
		int [] visited = new int[n+1];
		int max = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		visited[1] = 1;
		
		while(!q.isEmpty()) {
			int top = q.poll();
			if(max < visited[top]) {
				max = visited[top];
			}
			
			int size = vertex[top].size();
			
			for(int i=0; i<size; i++) {
				int next = vertex[top].get(i);
				if(visited[next] == 0) {
					visited[next] = visited[top] + 1;
					q.add(next);
				}
			}
		}
		
		for(int i=1; i<=n; i++) {
			if(max==visited[i])
				answer++;
		}
		
		
	}

	public static void main(String[] args) {
		int n = 6;
		int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

		LinkedList<Integer>[] vertex = new LinkedList[n + 1];

		for (int i = 0; i <= n; i++)
			vertex[i] = new LinkedList<Integer>();

		for (int i = 0; i < edge.length; i++) {
			int from = edge[i][0];
			int to = edge[i][1];
			vertex[from].add(to);
			vertex[to].add(from);
		}
		
		BFS(vertex,n);
		System.out.println(answer);
		

	}

}
