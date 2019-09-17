import java.util.Scanner;

public class Solution_8104_조만들기 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= t; ++test) {
			int n = s.nextInt();
			int k = s.nextInt();
			
			System.out.print("#"+test);
			for (int i = 1; i <= k; i++) {
				int sum = 0;
				int st = i;
				boolean f = false;
			
				while (st <= n*k) {
					sum += st;
					if(f) {
						st+=2*i-1;
						f= false;
					}
					else {
						st+=k+(k-2*i)+1;
						f=true;
					}
				}
				System.out.print(" "+sum);
			}
			System.out.println();
		}
	}
}
