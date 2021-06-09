package com.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_Programmers_오픈채팅방 {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();
		ArrayList<String> message = new ArrayList<String>();

		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };

		for (int i = 0; i < record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i], " ");
			String behave = st.nextToken();

			if (behave.equals("Enter")) { // 입장 시
				String id = st.nextToken();
				String nickName = st.nextToken();
				map.put(id, nickName);
				message.add(id + "님이 들어왔습니다.");
			} else if (behave.equals("Leave")) { // 나갈 때
				String id = st.nextToken();
				message.add(id + "님이 나갔습니다.");
			} else { // 닉네임 변경
				String id = st.nextToken();
				String nickName = st.nextToken();
				map.remove(id);
				map.put(id, nickName);
			}

		}

		String[] answer = new String[message.size()];

		for (int i = 0; i < message.size(); i++) {
			StringTokenizer st = new StringTokenizer(message.get(i), "님");
			String id = st.nextToken();
			String behave = st.nextToken();
			
			answer[i] = map.get(id) + "님" + behave;
			System.out.println(answer[i]);
		}

	}

}
