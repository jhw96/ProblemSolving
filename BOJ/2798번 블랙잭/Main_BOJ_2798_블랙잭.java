package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2798_블랙잭 {

    private static int[] num;
    private static int max = -1;
    private static int N;
    private static int M;

    private static void solve(int init, int idx, int sum) {
        if (idx == 3) {
            if (sum >= max && sum <= M) // 총합이 M을 넘지 않게
                max = sum;
            return;
        }

        for (int i = init; i < N; i++) {
            solve(i + 1, idx + 1, sum + num[i]);

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        solve(0,0,0);

        System.out.println(max);
    }

}
