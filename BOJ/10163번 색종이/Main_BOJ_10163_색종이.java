import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_10163_색종이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[101][101];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// 왼쪽 위 꼭지점
			int sY = Integer.parseInt(st.nextToken());
			int sX = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			for (int y = sY; y < sY + height; y++) {
				for (int x = sX; x < sX + width; x++) {
					map[y][x] = i;
				}
			}
		}

		int[] count = new int[N + 1];
		
		for(int y=0; y<101; y++) { // 색종이들 보이는 면적 넓이 구하기
			for(int x=0; x<101; x++) {
				if(map[y][x] != 0) {
					count[map[y][x]]++;
				}
			}
		}
		
		for(int i=1; i<=N; i++)
			System.out.println(count[i]);
		
		

		br.close();
	}

}
