package Solution;
import java.util.Scanner;

public class Solution_5213_진수의홀수약수_이재우 {
	static long arr[] = new long[1000001];
	static long piled[] = new long[1000001];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int i = 1; i <= 1000000; i+=2) {
			for (int j = 1; i*j <= 1000000; j++) {
				arr[i*j] += i;
			}
		}

		
		piled[1] = 1;
		for (int i = 2; i <= 1000000; i++) {
			piled[i] = piled[i-1]+arr[i];
		}

		
		for (int test = 1; test <= t; test++) {
			int l = s.nextInt();
			int r = s.nextInt();
			
			long sum = 0;
			sum = piled[r] - piled[l-1];
			
			System.out.println("#"+test+" "+sum);
		}
	}//main
	
}//class
