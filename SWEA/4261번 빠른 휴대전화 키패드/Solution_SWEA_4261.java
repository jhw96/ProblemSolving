package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 4261 빠른 휴대전화 키패드
public class Solution_SWEA_4261 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			String num = st.nextToken();
			int nLength = num.length();
			int[] phoneNumbers = new int[nLength]; // 폰번호 입력

			int count = Integer.parseInt(st.nextToken());
			String[] words = new String[count];
			boolean[] correspond = new boolean[count]; // 입력받은 폰번호와 단어가 대응되는지 체크

			for (int i = 0; i < correspond.length; i++)
				correspond[i] = true;

			st = new StringTokenizer(br.readLine(), " "); // 단어 입력

			for (int i = 0; i < count; i++)
				words[i] = st.nextToken();

			int wSize = words.length; // 단어의 개수

			for (int i = 0; i < nLength; i++) {
				phoneNumbers[i] = num.charAt(i) - '0';
				switch (phoneNumbers[i]) {
				case 2: // a b c
					for (int j = 0; j < wSize; j++) { // 단어가 돌아가면서 한 글자씩 비교
						if (correspond[j] == true) {
							if (words[j].charAt(i) > 'c') {
								correspond[j] = false;
							}
						}
					}

					break;
				case 3: // d e f
					for (int j = 0; j < wSize; j++) { // 단어가 돌아가면서 한 글자씩 비교
						if (correspond[j] == true) {
							if ( words[j].charAt(i) < 'd' || words[j].charAt(i) > 'f') {
								correspond[j] = false;
							}
						}
					}
					break;
				case 4: // g h i
					for (int j = 0; j < wSize; j++) { // 단어가 돌아가면서 한 글자씩 비교
						if (correspond[j] == true) {
							if (words[j].charAt(i) < 'g' || words[j].charAt(i) > 'i') {
								correspond[j] = false;
							}
						}
					}
					break;
				case 5: // j k l
					for (int j = 0; j < wSize; j++) { // 단어가 돌아가면서 한 글자씩 비교
						if (correspond[j] == true) {
							if (words[j].charAt(i) < 'j' || words[j].charAt(i) > 'l') {
								correspond[j] = false;
							}
						}
					}
					break;
				case 6: // m n o
					for (int j = 0; j < wSize; j++) { // 단어가 돌아가면서 한 글자씩 비교
						if (correspond[j] == true) {
							if (words[j].charAt(i) < 'm' || words[j].charAt(i) > 'o') {
								correspond[j] = false;
							}
						}
					}
					break;

				case 7: // p q r s
					for (int j = 0; j < wSize; j++) { // 단어가 돌아가면서 한 글자씩 비교
						if (correspond[j] == true) {
							if (words[j].charAt(i) < 'p' || words[j].charAt(i) > 's') {
								correspond[j] = false;
							}
						}
					}
					break;
				case 8: // t u v
					for (int j = 0; j < wSize; j++) { // 단어가 돌아가면서 한 글자씩 비교
						if (correspond[j] == true) {
							if (words[j].charAt(i) < 't' || words[j].charAt(i) > 'v') {
								correspond[j] = false;
							}
						}
					}
					break;
				case 9: // w x y z
					for (int j = 0; j < wSize; j++) { // 단어가 돌아가면서 한 글자씩 비교
						if (correspond[j] == true) {
							if (words[j].charAt(i) < 'w') {
								correspond[j] = false;
							}
						}
					}
					break;

				}

			}// for end
			
			int answer = 0;
			for(int i=0; i<wSize; i++){
				if(correspond[i] == true)
					answer++;
			}
			System.out.println("#" + tc + " " + answer);
			

		}

		br.close();
	}
}
