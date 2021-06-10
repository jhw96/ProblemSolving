package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_BOJ_11656_접미사배열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		ArrayList<String> suffix = new ArrayList<String>();
		
		for(int i=0; i<str.length(); i++) {
			String tmp = str.substring(i,str.length());
			suffix.add(tmp);
		}
		
		Collections.sort(suffix);
		
		for(int i=0; i<suffix.size(); i++)
			System.out.println(suffix.get(i));
		
		
		
		br.close();
	}

}
