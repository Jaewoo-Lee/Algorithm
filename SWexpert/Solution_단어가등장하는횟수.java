import java.util.Scanner;

public class Solution_단어가등장하는횟수 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		s.nextLine();
		for (int test = 1; test <= t; test++) {
			String full = s.nextLine();
			String unit = s.nextLine();
			
			int fl = full.length();
			int ul = unit.length();
			
			int cnt = 0;
			
			int i = 0;
			for (; i <= fl-ul; i++) {
				if(full.charAt(i) == unit.charAt(0)) {
					int j = 0;
					while(j != ul) {
						if(full.charAt(j+i) != unit.charAt(j)) break;
						j++;
					}
					if(j == ul) cnt++;
				}
			}
			System.out.println("#"+test+" "+cnt);
		}
	}
}
