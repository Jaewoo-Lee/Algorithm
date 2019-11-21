import java.util.ArrayList;
import java.util.Scanner;

public class Solution_5986_새샘이와세소수_이재우 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		ArrayList<Integer> pool = new ArrayList<Integer>();
		pool.add(2);
		pool.add(3);
		pool.add(5);
		for (int i = 7; i < 1000; i++) {
			if(i%2!=0||i%3!=0||i%5!=0)
				pool.add(i);
		}
		
		for (int i = 2; i < 500; i++) {
			for (int j = 2; i*j < 1000; j++) {
				pool.remove(new Integer(i*j));
			}
		}
		
		int t = s.nextInt();
		for (int test = 1; test <= t; test++) {
			int n = s.nextInt();
			int cnt = 0;
			
			for (int i = 0; pool.get(i) <= n;) {
				int temp1 = n;
				for (int k = i;pool.get(k)<=n;) {
					int temp2 = temp1-pool.get(i);
					temp2-=pool.get(k);
					if(pool.indexOf(temp2) >= k)
						cnt++;
					if(++k >= pool.size())
						break;
				}
				if(++i >= pool.size())
					break;
			}
			
			System.out.println("#"+test+" "+cnt);
		}
	}
}
