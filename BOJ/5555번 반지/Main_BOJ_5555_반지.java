package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_5555_반지 {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String sample = bufferedReader.readLine();
        int N = Integer.parseInt(bufferedReader.readLine());

        int answer = 0;

        for(int i=0; i<N; i++){
            String input = bufferedReader.readLine();
            String input2 = input + input;
            if (input2.contains(sample))
                answer++;
        }

        System.out.println(answer);


    } // main end
}
