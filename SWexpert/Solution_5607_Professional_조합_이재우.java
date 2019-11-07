package Solution;
import java.util.Scanner;

public class Solution_5607_Professional_조합_이재우 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		for (int test = 0; test < t; test++) {
			int n = s.nextInt();
			int r = s.nextInt();

			long pac1, pac2, pac3;

			pac1 = 1;
			pac2 = 1;
			pac3 = 1;
			
			for (int i = 1; i <= n; i++) {
				pac1=pac1*i%1234567891;
			}
			for (int i = 1; i <= r; i++) {
				pac2=pac2*i%1234567891;
			}
			for (int i = 1; i <= n-r; i++) {
				pac3=pac3*i%1234567891;
			}

			long result = pac1*mul(pac2, 1234567889)%1234567891;
			result = result*mul(pac3, 1234567889)%1234567891;

			System.out.println("#"+(test+1)+" "+result);

		}
	}


	

	public static long mul(long pac2, int b) {
		if(b == 0) return 1;
		if(b == 1) return pac2;
		if (b % 2 == 0) {
			long temp = mul(pac2, b / 2);
			return (temp % 1234567891 * temp % 1234567891) % 1234567891;
		}
		else
			return mul(pac2, b - 1) * pac2 % 1234567891;

	}
}
