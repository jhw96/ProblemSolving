package com.programmers;

import java.util.LinkedList;
import java.util.Queue;

class word {
	String value;
	int index;
	
	word(String value, int index) {
		this.value = value;
		this.index = index;
	}
	
	String getValue() {
		return value;
	}
	
	int getIndex() {
		return index;
	}
	
}

public class Solution_Programmers_단어변환 {

	static int answer;


	public static void BFS(String begin, String end, String[] words) {
		Queue<word> q = new LinkedList<word>();

		int length = words.length;
		int[] used = new int[length + 1];
		q.add(new word(begin,length));
		used[length] = 0;

		while (!q.isEmpty()) {
			word top = q.poll();
			int topDepth = used[top.getIndex()];
//			System.out.println(top.getValue() + " : " + topDepth);

			if (top.getValue().equals(end)) {
				answer = used[top.getIndex()];
				break;
			}

			for (int i = 0; i < length; i++) {
				if (used[i] == 0) {
					String next = words[i];
					int strLength = words[i].length();
					int cnt = 0;

					for (int j = 0; j < strLength; j++) {
						if (top.getValue().charAt(j) != next.charAt(j))
							cnt++;
					}

					if (cnt == 1) { // 한글자 차이나면 큐에 넣기
						used[i] = used[top.getIndex()] + 1;
						q.add(new word(next, i));
					}

				}
			}

		}

	} // BFS end

	public static void main(String[] args) {
		String begin = "hit";
		String end = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		BFS(begin, end, words);
		
		System.out.println(answer);
		
	}

}
