package com.swea;

import java.util.*;

public class StringMirror {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			
			StringBuilder sb = new StringBuilder();
			for (int i = str.length() - 1; i >= 0; i--) {
				if(str.charAt(i) == 'b')
					sb.append('d');
				else if(str.charAt(i) == 'd')
					sb.append('b');
				else if(str.charAt(i) == 'p')
					sb.append('q');
				else if(str.charAt(i) == 'q')
					sb.append('p');			
			}
			
			System.out.println("#" + tc + " " + sb);

		}

		sc.close();
	}
}
