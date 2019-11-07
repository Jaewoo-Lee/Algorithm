package Solution;
import java.util.Scanner;

public class Solution_1213_String_이재우 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int test = 1; test <= 10; test++) {
			int t = sc.nextInt();
			String check = sc.next();
			
			int idx=0;
			int cnt = 0;
			String sub = sc.next().substring(idx);
			while(true) {
				sub = sub.substring(idx);
				if(sub.contains(check)) {
					cnt++;
					idx=sub.indexOf(check)+1;
				}
				else break;
			}
			System.out.println("#"+test+" "+cnt);
		}
	}
}
