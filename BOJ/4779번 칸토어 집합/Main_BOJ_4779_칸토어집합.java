package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_BOJ_4779_칸토어집합 {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void make(int length) throws Exception{
		if (length == 1) {
			bw.write("-");
			return;
		}
		make(length / 3);
		for (int i = 0; i < length / 3; i++) {
			bw.write(" ");
		}
		make(length / 3);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = "";
		while ((input = br.readLine()) != null) {
			int N = Integer.parseInt(input);
			int length = (int) Math.pow(3, N);
			make(length);
			bw.write("\n");
			bw.flush();
			
		}

		br.close();
	}

}
