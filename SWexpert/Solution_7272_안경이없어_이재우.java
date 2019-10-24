import java.util.Scanner;

public class Solution_7272_안경이없어_이재우 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			String[] temp1 = s.next().split("");
			String[] temp2 = s.next().split("");
			
			if(temp1.length != temp2.length) {
				System.out.println("#"+test+" DIFF");
				continue;
			}
			
			boolean ff = true;
			for (int i = 0; i < temp1.length; i++) {
				if(temp1[i].equals("A")||temp1[i].equals("D")||temp1[i].equals("O")||temp1[i].equals("P")||temp1[i].equals("Q")||temp1[i].equals("R")) {
					temp1[i] = "1";
				}
				else if(temp1[i].equals("B"))
					temp1[i] = "2";
				else
					temp1[i] = "0";
			
				if(temp2[i].equals("A")||temp2[i].equals("D")||temp2[i].equals("O")||temp2[i].equals("P")||temp2[i].equals("Q")||temp2[i].equals("R")) {
					temp2[i] = "1";
				}
				else if(temp2[i].equals("B"))
					temp2[i] = "2";
				else
					temp2[i] = "0";
				
				if(!temp1[i].equals(temp2[i])) {
					System.out.println("#"+test+" DIFF");
					ff = false;
					break;
				}
			}
			
			if(ff)
				System.out.println("#"+test+" SAME");
		
		}
	}
}
