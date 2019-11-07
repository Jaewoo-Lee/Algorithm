package Solution;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1256_K번째접미어_이재우 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t= s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			int k = s.nextInt();
			String str = s.next();
			
			
			String hh[] = new String[str.length()];
			for (int i = 0; i < hh.length; i++) {
				hh[i] = str.substring(i);
			}
			
			Arrays.sort(hh);
			
			System.out.println("#"+test+" "+hh[k-1]);
		}
	}

}
