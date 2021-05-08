package com.jungol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_Jungol_1809_탑 {

	static class top {
		int idx;
		int height;

		public top(int idx, int height) {
			this.idx = idx;
			this.height = height;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		top[] tops = new top[N + 1];
		Stack<top> stack = new Stack<top>();

		for (int i = 1; i <= N; i++) {
			tops[i] = new top(i, Integer.parseInt(st.nextToken()));
		}


		for (int i = 1; i <= N; i++) {
			top now = tops[i];

			boolean flag = true;
			while (!stack.isEmpty()) {
				top tmp = stack.pop();

				if (tmp.height > now.height) { // 왼쪽에 현재보다 더 큰 탑이 있으면
					bw.write(tmp.idx + " ");
					stack.push(tmp);
					flag = false;
					break;
				}
			}
			if (flag) // 현재 탑보다 큰 탑이 없으면
				bw.write("0 ");
			stack.push(now);
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
