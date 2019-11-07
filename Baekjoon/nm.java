

import java.util.Scanner;

public class nm {
	static int n,m;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		
		for (int i = 1; i <= n; i++) {
			String num = "";
			go(num+i+" ", 1);
		}
	}

	public static void go(String string, int i) {
		if(i == m) 
			System.out.println(string);
		else {
			for (int j = 1; j <= n; j++) {
				go(string+j+" ",i+1);
			}
		}
	}
}
