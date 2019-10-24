import java.util.Scanner;

public class Solution_4796_의석이의우뚝선산_이재우 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			int n = s.nextInt();
			
			int[] mt = new int[n+5];
			
			for (int i = 0; i < n; i++) {
				mt[i] = s.nextInt();
			}//input end
			
			int cnt = 0;
			int up = 0;
			int dn = 0;
			
			int i = 0;
			while(i<n-1) {
				if(mt[i]<mt[i+1]) {
					while(mt[i]<mt[i+1]) {
						up++;
						i++;
						if(i==n-1) break;
					}
					if(i==n-1) break;
					while(mt[i]>mt[i+1]) {
						dn++;
						i++;
						if(i==n-1) break;
					}
					
					cnt+=(up*dn);
					up=0;
					dn=0;
					if(i==n-1) break;
					continue;
				}
				i++;
				if(i==n-1) break;
			}
			System.out.println("#"+test+" "+cnt);
		}
	}
}
