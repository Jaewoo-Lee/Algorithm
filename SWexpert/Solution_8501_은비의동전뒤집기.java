import java.util.Scanner;

public class Solution_8501_은비의동전뒤집기 {
	static long[][] m;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		m = new long[1001][2];
		m[2][0] = 1;
		m[2][1] = 3;
		
		m[3][0] = 5;
		m[3][1] = 13;
		
		long temp = 6;
		
		for (int i = 4; i < 1001; i++) {
			m[i][0] = m[i-1][0]+temp+m[i-1][1]+temp;
			m[i][0]+= ((i-1)*m[i-2][1])%1000000007;
			m[i][0]+= ((i-1)*(i-2)*m[i-3][0])%1000000007;
			m[i][0] = m[i][0]%1000000007;
			
			temp*=i;
			m[i][1] = (temp-m[i][0])%1000000007;
		}
		
		for (int test = 1; test <= t; test++) {
			int n = s.nextInt();
			
			System.out.println("#"+test+" "+m[n][0]);
		}
	}
}
