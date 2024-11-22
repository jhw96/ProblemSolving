package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_2897_몬스터트럭 {

    static int answer[] = new int[5];
    static char[][] map;

    private static void find(int x, int y) {
        int cnt = 0;

        int[] dX = new int[] {0,0,1,1};
        int[] dY = new int[] {0,1,0,1};

        for(int i=0; i<4; i++) {
            int nX = x + dX[i];
            int nY = y + dY[i];

            char now = map[nY][nX];

            if(now == '#')
                return;
            else if(now=='X')
                cnt++;

        }

        answer[cnt]++;
    } // find end


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken()); // 행
        int N = Integer.parseInt(st.nextToken()); // 열

        map = new char[R + 1][N + 1];

        for (int y = 1; y <= R; y++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            for (int x = 1; x <= N; x++)
                map[y][x] = input.charAt(x - 1);
        }

        for(int y=1; y<=R-1; y++) {
            for(int x=1; x<=N-1; x++) {
                if(map[y][x] == '#')
                    continue;
                find(x,y);
            }
        }



        for(int i=0; i<5; i++)
            System.out.println(answer[i]);


        br.close();
    } // main end
}
