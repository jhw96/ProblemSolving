package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Programmers_Solution_베스트앨범 {

	static class Node {
		ArrayList<int[]> list = new ArrayList<int[]>();

		public Node(int idx, int play) {
			list.add(new int[] { idx, play });
		}
	}

	public static void main(String[] args) { // 장르 별로 가장 많이 재생된 노래를 두개씩 모아서 베스트 앨범 만들기
		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
		int[] plays = { 500, 600, 150, 800, 2500 };
		HashMap<String, Integer> genrePlay = new HashMap<String, Integer>(); // 장르별 재생수
		HashMap<String, Node> eachPlay = new HashMap<String, Node>(); // 각 장르에서 재생 수
		ArrayList<Integer> tmpAnswer = new ArrayList<Integer>(); // 임시 답, 나중에 int[] 형으로 바꿔야함
		for (int i = 0; i < genres.length; i++) {
			String nowGenre = genres[i];
			if (genrePlay.containsKey(nowGenre)) { // 이미 계산되어 있는 장르라면
				int value = genrePlay.get(nowGenre);
				genrePlay.put(nowGenre, value + plays[i]); // 현재 재생 수 더해주기

				eachPlay.get(nowGenre).list.add(new int[] { i, plays[i] }); // 현재 장르의 고유번호와 재생수 저장

			} else { // 처음 계산하는 장르라면
				genrePlay.put(nowGenre, plays[i]);
				eachPlay.put(nowGenre, new Node(i, plays[i]));
			}
		}

		// 장르 별 재생 수
		Set<String> keys = genrePlay.keySet();
		int size = keys.size();
//			System.out.println("장르 갯수 : " + size);

		for (int i = 0; i < size; i++) {
			int max = 0;
			String maxKey = "";
			Iterator<String> itr = keys.iterator();
			while (itr.hasNext()) {
				String nowKey = itr.next();
				if (genrePlay.get(nowKey) > max) { // 최대 재생 앨범 찾음
					max = genrePlay.get(nowKey);
					maxKey = nowKey;
				}
			}

			ArrayList<int[]> tmp = eachPlay.get(maxKey).list;
			Collections.sort(tmp, new Comparator<int[]>() {

				public int compare(int[] o1, int[] o2) {
					if (o1[1] == o2[1]) { // 재생 수가 같으면
						return o1[0] - o2[0];
					}
					return o2[1] - o1[1];
				}

			});

			int cnt = 0;
			for (int j = 0; j < tmp.size(); j++) {
				if (cnt >= 2)
					break;
				tmpAnswer.add(tmp.get(j)[0]);
				cnt++;
			}

			genrePlay.put(maxKey, -1); // 최고 곡 2개 뽑아낸 장르는 방문처리
		}
		int[] answer = new int[tmpAnswer.size()];
		
		for(int i=0; i<tmpAnswer.size(); i++)
			answer[i] = tmpAnswer.get(i);

		System.out.println(Arrays.toString(answer));

	} // main end

} // class end
