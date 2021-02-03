package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_3143 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			String A = st.nextToken();
			String B = st.nextToken();
			
			int aSize = A.length();
			int bSize = B.length();
			int answer = 0;
			for(int i=0; i<aSize; i++) {
				
				if(A.charAt(i) == B.charAt(0) && (aSize - i + 1 >= bSize)) { // 만약에 A의 글자가 B의 첫글자와 같고 A 뒤에 글자가 충분하면
					String temp = A.substring(i, i + bSize);
					if(temp.equals(B)) {
						answer++;
						i+=(bSize-1);
						continue;
					}
					
				}
		
				answer++;
			} // for end
			
			System.out.println("#" + tc + " " + answer);
			
		}

		br.close();
	}
}
