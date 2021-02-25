import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ_13300_방배정 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] studentCount = new int[7][2]; // 학년별 성별에 따른 사람 수
		// 0: 여자, 1: 남자

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int gender = Integer.parseInt(st.nextToken()); // 성별
			int grade = Integer.parseInt(st.nextToken()); // 학년
			studentCount[grade][gender]++;
		}

		int answer = 0;
		for (int grade = 1; grade <= 6; grade++) {
			for (int gender = 0; gender < 2; gender++) {
				while(studentCount[grade][gender] > 0) {
					studentCount[grade][gender] -= K;
					answer++;
				}
			}
		}
		
		System.out.println(answer);

		br.close();
	}

}
