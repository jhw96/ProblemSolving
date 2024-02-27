package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BOJ_10845_ť {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> q = new LinkedList<Integer>();
		int last = -1; // ť�� ������ �� ����� ���� ����

		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			String command = st.nextToken();
			int num = 0;

			switch (command) {

			case "push": // ť�� �� �Է�
				num = Integer.parseInt(st.nextToken());
				q.add(num);
				last = num;
				break;

			case "pop": // ť �� �� ���� �� ���
				if (q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.poll());
				break;

			case "size": // ť ������ Ȯ��
				System.out.println(q.size());
				break;

			case "empty": // ť�� ������� Ȯ��
				if (q.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);
				break;

			case "front": // ť�� �� �� ���
				if (q.isEmpty())
					System.out.println(-1);
				else
					System.out.println(q.peek());
				break;

			case "back": // ť�� �� �� ���
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
