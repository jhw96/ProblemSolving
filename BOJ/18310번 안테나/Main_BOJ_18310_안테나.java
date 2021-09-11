/*
 * 일직선 상의 마을에 여러 채의 집이 위치해 있다. 이중에서 특정 위치의 집에 특별히 한 개의 안테나를 설치하기로 결정했다.
 * 효율성을 위해 안테나로부터 모든 집까지의 거리의 총 합이 최소가 되도록 설치하려고 한다. 
 * 이 때 안테나는 집이 위치한 곳에만 설치할 수 있고, 논리적으로 동일한 위치에 여러 개의 집이 존재하는 것이 가능하다. 
 * 그냥 정렬해서 가운데에 위치하는 곳에 안테나 꼽으면 끝
 * 정렬 + 그리디
 */

package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BOJ_18310_안테나 {

	static int N; // 집의 개수
	static ArrayList<Integer> house = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			int place = Integer.parseInt(st.nextToken());
			house.add(place);
		}

		int houseCnt = house.size();
		Collections.sort(house); // 정렬 후 가운데 위치에 존재하는 애 집에 설치하기

		int mid = houseCnt % 2 == 0 ? houseCnt / 2 - 1 : houseCnt / 2; // 홀수, 짝수일 경우 나눠서 중간 값 찾기

		int answer = house.get(mid); // 안테나 설치한 곳의 좌표

		System.out.println(answer);

		br.close();
	}

}
