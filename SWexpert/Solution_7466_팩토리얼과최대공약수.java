import java.util.Scanner;

public class Solution_7466_팩토리얼과최대공약수 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			int n, k;
			n = s.nextInt();
			k = s.nextInt();
			
			int answer = 1;
			if(n>=k) answer = k;
			else {
				int i = n;
				while(i>0) {
					if(k==1) break;
					if(k%i == 0) {
						answer *= i;
						k = k/i;
						if(i>=k) i=k;
						else i--;
					}
					else i--;
				}
			}
			System.out.println("#"+test+" "+answer);
		}
	}
}
