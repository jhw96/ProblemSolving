package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_1436_¿µÈ­°¨µ¶¼ò {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int n = 1;
		int num = 666;

		while (n < N) {
			num++;
			String str = Integer.toString(num);

			if (str.contains("666"))
				n++;

		}
		
		System.out.println(num);

		br.close();
	}

}
