import java.util.Scanner;

public class Solution_5432_쇠막대기자르기 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		for (int test = 1; test <= t; test++) {
			String str = s.nextLine();
			char pre = '!';
			char now = '!';
 			int cnt = 0;
 			int stack = 0;
			for (int i = 0; i < str.length(); i++) {
				pre = now;
				now = str.charAt(i);
				
				if(pre=='(' && now==')') {
					cnt+= --stack;
				}
				else if(pre !='(' && now==')') {
					cnt++;
					stack--;
				}
				else if(now=='(') {
					stack++;
				}
			}
			System.out.println("#"+test+" "+cnt);
		}
	}
}
