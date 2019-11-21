import java.util.Scanner;

public class Solution_1493_수의새로운연산_이재우 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int test = 1; test <= t; test++) {
			int i = s.nextInt();
			int j = s.nextInt();
			
			int addr_i[] = addr(i);
			int addr_j[] = addr(j);
			
			int n_addr[] = new int[2];
			n_addr[0] = addr_i[0]+addr_j[0];
			n_addr[1] = addr_i[1]+addr_j[1];
			
			System.out.println("#"+test+" "+val(n_addr[0], n_addr[1]));
		}
	}

	public static int val(int i, int j) {
		int result = 0;
		for (int k = 1; k <= i; k++) {
			result+=k;
		}
		for (int k = 1; k < j; k++) {
			result+=(i++);
		}
		
		return result;
		
	}

	public static int[] addr(int i) {
		int x = 1;
		int y = 1;
		
		int result[] = new int[2];
		
		while(i > 0) {
			i-=x;
			x++;
		}
		
		result[0] = x+i-1;
		result[1] = y-i;
		
				
		return result;
	}
}
