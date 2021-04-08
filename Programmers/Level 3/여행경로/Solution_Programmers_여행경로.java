package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution_Programmers_여행경로 {

	static ArrayList<String> list = new ArrayList<String>();
	static boolean[] used;

	public static void DFS(String tickets[][], String route, String present, int cnt) {
		if (cnt == tickets.length) {
			list.add(route);
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			if (!used[i] && tickets[i][0].equals(present)) {
				used[i] = true;
				DFS(tickets, route + "," + tickets[i][1], tickets[i][1], cnt + 1);
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) {
//		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
//				{ "ATL", "SFO" } };
		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//		String[][] tickets = {{"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}};
//		String[][] tickets = {{"ICN","A"},{"ICN","A"},{"A","ICN"}};
		String[] answer = {};
		used = new boolean[tickets.length];

		for (int i = 0; i < tickets.length; i++) {
			String start = tickets[i][0];
			String end = tickets[i][1];

			if (start.equals("ICN")) {
				used[i] = true;
				DFS(tickets, "ICN," + end, end, 1);
				used[i] = false;
			}
		}
		Collections.sort(list);
		answer = list.get(0).split(",");

		System.out.println(Arrays.toString(answer));
	}

}
