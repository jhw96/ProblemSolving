import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ_2999_비밀이메일 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int strLength = str.length();
		int R = 0, C = 0;

		for (int i = 1; i <= strLength; i++) {
			C = strLength / i;
			if (strLength % i == 0) {
				if (C >= i)
					R = i;
				else if (C < i)
					break;
			}
		}
		System.out.println(R);
		C = strLength / R;
		char[][] newStr = new char[R][C];
		int index = 0;
		for (int x = 0; x < C; x++) {
			for (int y = 0; y < R; y++) {
				newStr[y][x] = str.charAt(index++);
			}
		}
		
		for(int y=0; y<R; y++) {
			for(int x=0; x<C; x++)
				System.out.print(newStr[y][x]);
		}

		br.close();
	}

}
