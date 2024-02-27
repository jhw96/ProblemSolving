package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_10845_큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> q = new LinkedList<Integer>();
		int last = -1; // 큐의 마지막 값 출력을 위한 변수

		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			String command = st.nextToken();
			int num = 0;

			switch (command) {

			case "push": // 큐에 값 입력
				num = Integer.parseInt(st.nextToken());
				q.add(num);
				last = num;
				break;

			case "pop": // 큐 맨 앞 제거 및 출력
				if (q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.poll());
				break;

			case "size": // 큐 사이즈 확인
				System.out.println(q.size());
				break;

			case "empty": // 큐가 비었는지 확인
				if (q.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;

			case "front": // 큐의 맨 앞 출력
				if (q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.peek());
				break;

			case "back": // 큐의 맨 뒤 출력
				if (q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(last);
				break;
			}
		}

		br.close();
	}

}
