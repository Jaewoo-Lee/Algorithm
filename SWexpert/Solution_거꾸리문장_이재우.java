package Solution;

import java.util.Scanner;

public class Solution_거꾸리문장_이재우 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		while(true) {
			String str[] = s.next().split(" ");
			String result = "";
			for (int i = 0; i < str.length; i++) {
				String charr[] = str[i].split("");
				
				for (int j = 0; j < charr.length; j++) {
					if(charr[j].equals("!")
							|| charr[j].equals(".")
							|| charr[j].equals(",")
							|| charr[j].equals("?")) {
						result += charr[j];
						continue;
					}
					result = charr[j] + result;
				}
				System.out.print(" ");
			}
			
			System.out.print(result);
		}
	}
}
