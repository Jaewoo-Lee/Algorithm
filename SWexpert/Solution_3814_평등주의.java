import java.util.Scanner;

public class Solution_3814_평등주의 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			int n = s.nextInt();
			int k = s.nextInt();
			
			int temp, a, b;
			int[] cha = new int[n-1];
			a = s.nextInt();
			for (int i = 0; i < n; i++) {
				b = s.nextInt();
				temp = b;
				cha[i] = a-b;
				a = b;
			}
			// input end
			
			int maxx = 0;
			int smax = 0;
			while(k > 0) {
				for (int i = 0; i < n-1; i++) {
					int abs = 0;
					if(cha[i] < 0) abs = cha[i]*-1;
					else abs = cha[i];
					
					if(abs > maxx) {
						smax = maxx;
						maxx = abs;
					}
				}
				
				
				
				
				k--;
			}
		}
	}
}
