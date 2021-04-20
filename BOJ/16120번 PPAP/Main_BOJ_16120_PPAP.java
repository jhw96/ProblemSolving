package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_16120_PPAP {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Character> st = new Stack<Character>();
		String s = br.readLine();
		
		if(s.length()==1 && s.equals("P")) { // 그냥 P만 들어와도 PPAP
			System.out.println("PPAP");
			return;
		}

		int aCnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'P') {
				st.push(s.charAt(i));
			} else { // 현재 A일때
				if (i < s.length() - 1) { // 현재 A인데 뒤에 문자가 있으면
					if (s.charAt(i + 1) == 'P') { // 뒤에 P가 있으면

						if (st.size() > 1) {
							aCnt++;
							st.pop();
							i++;
						} else {
//							System.out.println("1");
							System.out.println("NP");
							return;
						}
					} else { // 뒤에 P가 없으면
//						System.out.println("2");
						System.out.println("NP");
						return;
					}
				} else { // 현재 A인데 뒤에 문자가 없으면
//					System.out.println("3");
					System.out.println("NP");
					return;
				}
			}
		}
		
		
		

		if (st.size() > 1) { // P가 2개 이상이면
//			System.out.println("4");
			System.out.println("NP");
			return;
		} else if(aCnt == 0) { // P가 1개이지만 AP가 들어오지 않았을 경우
//			System.out.println("5");
			System.out.println("NP");
			return;
		}

		System.out.println("PPAP");

		br.close();
	} // main end

} // class end
