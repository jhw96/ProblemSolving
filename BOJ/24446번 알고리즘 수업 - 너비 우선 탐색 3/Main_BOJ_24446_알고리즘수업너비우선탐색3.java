package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_24446_알고리즘수업너비우선탐색3 {

    static int N, M, R; // 정점의 수, 간선의 수, 시작정점
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int[] order; // 방문순서

    private static class Node {

        int idx;
        int order;

        public Node(int idx, int order) {
            this.idx = idx;
            this.order = order;
        }

        public int getIdx() {
            return this.idx;
        }

        public int getOrder() {
            return this.order;
        }
    } // Node end

    public static void BFS(int r) {
        Queue<Node> queue = new LinkedList<Node>();
        Node start = new Node(r, 0);

        queue.add(start);
        visited[r] = true;
        order[r] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int idx = now.getIdx();
            int nowOrder = now.getOrder();

            for (int i = 0; i < graph[idx].size(); i++) {
                int next = graph[idx].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    order[next] = nowOrder + 1;
                    queue.add(new Node(next, nowOrder + 1));
                }
            }

        }
    } // BFS end

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            order[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        BFS(R);

        for (int i = 1; i <= N; i++)
            System.out.println(order[i]);

    } // main end

}
