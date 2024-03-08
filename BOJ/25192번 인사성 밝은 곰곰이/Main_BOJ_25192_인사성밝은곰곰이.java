package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_BOJ_25192_¿ŒªÁº∫π‡¿∫∞ı∞ı¿Ã {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		Set<String> set = new HashSet<String>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();

			if ("ENTER".equals(str))
				set.clear();
			else if (!set.contains(str)) {
				set.add(str);
				answer++;
			}

		}

		System.out.println(answer);

		br.close();
	}

}
