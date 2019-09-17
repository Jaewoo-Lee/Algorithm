import java.util.HashSet;
import java.util.Scanner;

public class Solution_7829_º¸¹°¿ÕÅÂÇõ {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			int n = s.nextInt();
			
			long dap = 0;
			HashSet<Integer> mm = new HashSet<Integer>();
			
			for (int i = 0; i < n; i++) {
				int temp = s.nextInt();
				mm.add(temp);
			}
			
			Object[] str = mm.toArray();
			if(n%2==1) {
				dap = Integer.parseInt(str[n/2].toString());
				dap*=dap;
			}
			else {
				dap = Integer.parseInt(str[n/2].toString());
				dap*=Integer.parseInt(str[n/2+1].toString());
			}
			System.out.println("#"+test+" "+dap);
				
		}
	}
}
