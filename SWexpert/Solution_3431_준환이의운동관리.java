

import java.util.Scanner;

public class Solution_3431_준환이의운동관리 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int test = 1; test <= t; test++) {
			long L = s.nextLong();
			long U = s.nextLong();
			long X = s.nextLong();
			
			if(U<X) {
				System.out.println("#"+test+" -1");
				continue;
			}
			else if(X>L) {
				System.out.println("#"+test+" 0");
			}
			else
				System.out.println("#"+test+" "+(L-X));
		}
	}
}
