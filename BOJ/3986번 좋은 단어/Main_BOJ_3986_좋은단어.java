package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_BOJ_3986_좋은단어 {

	public static boolean solve(int length, char[] input) {
		if (length % 2 != 0)
			return false;

		Stack<Character> stack = new Stack<Character>();
		stack.add(input[0]);
		char top = ' ';

		for (int i = 1; i < length; i++) {
			if (stack.isEmpty()) {
				stack.add(input[i]);
				continue;
			} else
				top = stack.peek();

			if (input[i] == top) {
				stack.pop();
			} else
				stack.add(input[i]);
		}

		if (stack.isEmpty())
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;

		for (int i = 1; i <= N; i++) {
			char[] str = br.readLine().toCharArray();

			if (solve(str.length, str)) {
				answer++;
			}
		}

		System.out.println(answer);

		br.close();
	}

}
