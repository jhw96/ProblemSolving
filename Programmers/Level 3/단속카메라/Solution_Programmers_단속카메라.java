package com.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_Programmers_단속카메라 {

	public static void main(String[] args) {
		int[][] routes = { { -20, 15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
		
		Arrays.sort(routes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0])
					return 1;
				return -1;
			}

		});
		
		int cnt = 1;
		int minOut = routes[0][1]; // 진출시간 최솟값
		for(int i=1; i<routes.length; i++) {
			if(routes[i][0] > minOut) { // 다음 차 진입시간이 현재까지 진출시간 최솟값보다 크면 
				cnt++;
				minOut = routes[i][1];
			} else { // 현재까지 진출시간 최솟값보다 작은데 
				if(routes[i][1] < minOut) {
					minOut= routes[i][1];
				}
			}
			
			
		}
		
		System.out.println(cnt);
		
		
	}

}
