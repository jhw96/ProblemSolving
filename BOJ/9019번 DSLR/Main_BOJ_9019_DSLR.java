package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_9019_DSLR {
	static String start, end;
	static boolean[] visited;

	static class Node {
		String data;
		String process; // 여태까지 수행한 명령어

		Node(String data, String process) {
			this.data = data;
			this.process = process;
		}
	}

	private static String BFS() { // D : 2배 , S : 1빼기 , L : 자릿수 왼편으로 이동 , R : 자릿수 오른편으로 이동
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(start, ""));

		while (!q.isEmpty()) {
			Node top = q.poll();
			String data = top.data;
			String process = top.process;

			if (data.equals(end)) {
				return process;
			}

			int changeData = Integer.parseInt(data);

			int first = (changeData * 2) % 10000;
			if (!visited[first]) {
				visited[first] = true;
				String result = "";
				if (first < 1000)
					result = change(String.valueOf(first));
				else
					result = String.valueOf(first);

				q.add(new Node(result, process + "D"));
			}

			int second = changeData == 0 ? 9999 : changeData - 1;
			if (!visited[second]) {
				visited[second] = true;
				String result = "";
				if (second < 1000)
					result = change(String.valueOf(second));
				else
					result = String.valueOf(second);
				q.add(new Node(result, process + "S"));
			}


			int third = (changeData%1000 * 10) + changeData/1000;
//			System.out.println("에러잡기 -> 원본 : " +changeData + " 변경 후 : " + third);
			if (!visited[third]) {
				visited[third] = true;
				String result = "";
				if (third < 1000)
					result = change(String.valueOf(third));
				else
					result = String.valueOf(third);
				q.add(new Node(result, process + "L"));
			}

			int fourth = ((changeData%10)*1000) + changeData/10;
//			System.out.println("에러잡기 -> 원본 : " +changeData + " 변경 후 : " + fourth);
			if (!visited[fourth]) {
				visited[fourth] = true;
				String result = "";
				if (fourth < 1000)
					result = change(String.valueOf(fourth));
				else
					result = String.valueOf(fourth);
				q.add(new Node(result, process + "R"));
			}
		}
		
		return "";
	} // BFS end


	private static String change(String str) {
		String result = "";

		if (str.length() < 4) {

			for (int i = 0; i < 4 - str.length(); i++) {
				result += "0";
			}
			result += str;
		} else {
			result = str;
		}

		return result;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			start = change(st.nextToken());
			end = change(st.nextToken());
			visited = new boolean[10000];

			bw.write(BFS()+"\n");
			bw.flush();
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
