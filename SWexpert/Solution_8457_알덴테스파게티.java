import java.util.Scanner;

public class Solution_8457_�˵��׽��İ�Ƽ {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			int n = s.nextInt();
			int b = s.nextInt();
			int e = s.nextInt();
			
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				int m = s.nextInt();
				
				for (int j = b-e; j <= b+e; j++) {
					if(j%m == 0) {
						cnt++;
						break;
					}
				}
			}
			
			System.out.println("#"+test+" "+cnt);
		}
	}
}
