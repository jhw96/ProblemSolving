import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_6485_삼성시의버스노선_D3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[][] FromTo = new int[N][2]; // 0:버스가 다니는 곳 시작 1: 버스가 다니는 곳 끝

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 2; j++)
					FromTo[i][j] = Integer.parseInt(st.nextToken());
			}

			int P = Integer.parseInt(br.readLine()); // 버스정류장 개수
			int[][] busStop = new int[P][2]; // 0 : 원래 index, 1 : 입력받는 버스 번호

			for (int i = 0; i < P; i++) {
				busStop[i][1] = Integer.parseInt(br.readLine());
				
				for (int j = 0; j < N; j++) { // 버스정류장 번호 입력받음과 동시에 바로 카운팅하기
					for (int k = FromTo[j][0]; k <= FromTo[j][1]; k++) { 
						if (k == busStop[i][1])
							busStop[i][0]++;
					}
				}

			}
			
			System.out.print("#" + tc + " ");
			for(int i=0; i<P; i++)
				System.out.print(busStop[i][0] + " ");
			System.out.println();

		}

		br.close();
	} // main end

} // class end