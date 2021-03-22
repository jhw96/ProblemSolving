package com.programmers;

import java.util.ArrayList;

public class Solution_Programmers_하노이의탑 {

	static ArrayList<int[]> container = new ArrayList<int[]>();
	
	public static void hanoi(int from, int temp, int to, int n) {
		if (n == 0)
			return;
		hanoi(from, to, temp, n-1);
		
		container.add(new int[] {from,to});
		
		hanoi(temp, from, to, n-1);
	}

	public static void main(String[] args) {
		int n = 2;

		hanoi(1, 2, 3, n);
		
		int[][] answer = new int[container.size()][2];
		
		for(int i=0; i<container.size(); i++) {
			answer[i][0] = container.get(i)[0];
			answer[i][1] = container.get(i)[1];
		}
		
		

	}// main end

} // class end
