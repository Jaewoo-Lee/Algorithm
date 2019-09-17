import java.util.Scanner;

public class Solution_1284_수도요금 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for (int test = 1; test <= t; test++) {
			long p,q,r,s,w;
			
			p= sc.nextInt();
			q= sc.nextInt();
			r= sc.nextInt();
			s= sc.nextInt();
			w= sc.nextInt();
			
			long a;
			long b;
			
			a = p*w;
			b = q;
			if(w>r) {
				long temp_m = (w-r);
				long temp = temp_m*s;
				b+=temp;
			}
			
			System.out.println("#"+test+" "+(a<b? a:b));
		}
	}
	
}
