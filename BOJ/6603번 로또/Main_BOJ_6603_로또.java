package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BOJ_6603_로또 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			if (k == 0)
				break;

			int[] numbers = new int[k];
			for (int i = 0; i < k; i++)
				numbers[i] = Integer.parseInt(st.nextToken());

			Arrays.sort(numbers);
			int[] res = new int[6];

			for (int i = 0; i < k; i++) {
				res[0] = numbers[i];
				for (int j = i + 1; j < k; j++) {
					res[1] = numbers[j];
					for (int l = j + 1; l < k; l++) {
						res[2] = numbers[l];
						for (int m = l + 1; m < k; m++) {
							res[3] = numbers[m];
							for (int n = m + 1; n < k; n++) {
								res[4] = numbers[n];
								for (int o = n + 1; o < k; o++) {
									res[5] = numbers[o];
									bw.write(res[0] + " " + res[1] + " " + res[2] + " " + res[3] + " " + res[4] + " "
											+ res[5] + "\n");
								}
							}
						}
					}
				}
			}
			bw.write("\n");

		}

		bw.flush();
		bw.close();
		br.close();
	}

}
