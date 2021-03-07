package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BOJ_1764_듣보잡 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		HashSet<String> listen = new HashSet<String>();
		LinkedList<String> result = new LinkedList<String>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) // 듣도 못한 사람 입력
			listen.add(br.readLine());

		for (int i = 0; i < M; i++) {// 보도 못한 사람 입력
			String str = br.readLine();
			if(listen.contains(str))
				result.add(str);
		}
		
		bw.write(result.size()+"\n");
		Iterator<String> itr = result.iterator();
		while(itr.hasNext())
			bw.write(itr.next()+"\n");
		

		bw.close();
		br.close();
	}

}
