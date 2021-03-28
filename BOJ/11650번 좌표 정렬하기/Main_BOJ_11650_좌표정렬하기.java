import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BOJ_11650_좌표정렬하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] pointer = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			pointer[i][0] = Integer.parseInt(st.nextToken());
			pointer[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(pointer, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) { // x좌표가 같으면
					// y좌표 오름차순
					return o1[1] - o2[1];
				} else { // x좌표가 다르면
					return o1[1] - o2[1];
				}
			}
		});
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++)
				System.out.print(pointer[i][j] + " ");
			System.out.println();
		}

		br.close();
	}

}
