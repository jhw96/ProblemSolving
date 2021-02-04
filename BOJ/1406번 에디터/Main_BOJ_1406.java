package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();


        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char ch : line) {
            left.push(ch);
        }

        int num = Integer.parseInt(br.readLine());

        for(int i = 0 ; i<num ; i++) {
            String [] bCmd = br.readLine().split(" ");
            char cmd =  bCmd[0].charAt(0);
                if(cmd == 'L') {
                    if (!left.empty())
                        right.push(left.pop());
                } else if(cmd == 'D') {
                    if (!right.empty())
                        left.push(right.pop());
                } else if(cmd == 'B') {
                    if (!left.empty())
                        left.pop();
                } else if(cmd == 'P') {
                    left.push(bCmd[1].charAt(0));
                }
        }

        while(!left.isEmpty()) {
            right.push(left.pop());
        }
        StringBuilder sb= new StringBuilder();
        while(!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
        
        br.close();
	}

}
