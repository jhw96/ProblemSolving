import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_14696_딱지놀이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 어린이들이 가지는 카드 종류에 따른 개수 배열
			int[] countA = new int[5];
			int[] countB = new int[5];

			int a = Integer.parseInt(st.nextToken());

			// A어린이 카드 개수
			int[] A = new int[a];
			for (int j = 0; j < a; j++) {
				A[j] = Integer.parseInt(st.nextToken());
				countA[A[j]] += 1;
			}
			// B어린이 카드 개수
			st = new StringTokenizer(br.readLine(), " ");
			int b = Integer.parseInt(st.nextToken());
			int[] B = new int[b];
			for (int j = 0; j < b; j++) {
				B[j] = Integer.parseInt(st.nextToken());
				countB[B[j]] += 1;
			}

			for (int j = 4; j >= 1; j--) {
				int diff = countA[j] - countB[j];
				if (diff > 0) {
					System.out.println("A");
					break;
				} else if (diff < 0) {
					System.out.println("B");
					break;
				} else {
					if (j != 1)
						continue;
					else
						System.out.println("D");
				}
			}

		}

		br.close();
	}

}
