import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_7829_보물왕태혁_D4 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for(int tc=1; tc<=T; tc++) {
			int t = Integer.parseInt(br.readLine());
			int[] numbers = new int[t];
			
			st = new StringTokenizer(br.readLine()," ");
			
			for(int i=0; i<t; i++)
				numbers[i] = Integer.parseInt(st.nextToken());
			
			Arrays.sort(numbers);
			
			int result = numbers[0] * numbers[numbers.length - 1];
			System.out.println("#" + tc + " " + result);
		}
		
		br.close();
	}
}
