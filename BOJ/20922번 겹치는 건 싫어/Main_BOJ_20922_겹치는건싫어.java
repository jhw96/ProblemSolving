/*
 * N개의 수열이 주어졌을 때 같은 원소의 개수가 K개 이하인 최장 연속 부분의 길이가 가장 긴 것 찾기
 * 문제 제대로 안 읽고 수열을 맘대로 정렬해서 계속 틀렸었음
 * 사람이 계산하는 것처럼 똑같이 투포인터식으로 구현해주면 풀림
 */

package com.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_20922_겹치는건싫어 {

	static int N, K; // 입력으로 주어지는 수열의 길이, 같은 원소는 K개 이하로 들어가게 할 것
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int left = 0, right = 0;
		int answer = 0;
		int[] cnt = new int[100001];

		int process = 1;
		cnt[arr[left]] = 1;

		while (left <= right && right < N) {
			if (right + 1 < N && cnt[arr[right]] <= K) { // 오른쪽에서 앞서는 수가 K개 이하면
				right += 1;
				cnt[arr[right]] += 1;
				process++;
				if (cnt[arr[right]] <= K) { // 바로 위에서 부분연속수열의 길이를 +1 해줬기에 그 길이가 정답으로써 유효한지 체크해야함
					answer = Math.max(process, answer);
				}

			} else if (cnt[arr[right]] > K) { // K개 넘으면 왼쪽꺼 당기기
				process -= 1;
				cnt[arr[left]] -= 1;
				left += 1;

			} else if (right + 1 >= N)
				break;
		}

		System.out.println(answer);

		br.close();
	}

}
