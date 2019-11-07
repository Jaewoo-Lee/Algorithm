package Solution;
import java.util.Scanner;

public class Solution_6913_동철이의프로그래밍대회_이재우 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			int n = s.nextInt();
			int m = s.nextInt();
			
			int arr[][] = new int[n][m];
			int check[] = new int[n];

			int maxx = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					int temp = s.nextInt();
					if(temp == 1) {
						check[i]++;
						if(maxx<check[i]) maxx = check[i];

					}
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < check.length; i++) {
				if(maxx == check[i]) cnt++;
			}
			
			System.out.println("#"+test+" "+cnt+" "+maxx);
		}
	}
}
