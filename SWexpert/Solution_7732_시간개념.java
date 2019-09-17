import java.util.Scanner;

public class Solution_7732_½Ã°£°³³ä {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			String temp = s.next().trim();
			int[] prsn = new int[3];
			for (int i = 0; i < 3; i++) {
				prsn[i] = Integer.parseInt(""+temp.charAt(i*3)+temp.charAt(3*i+1));
			}
			
			temp = s.next().trim();
			int[] prms = new int[3];
			for (int i = 0; i < 3; i++) {
				prms[i] = Integer.parseInt(""+temp.charAt(i*3)+temp.charAt(3*i+1));
			}
			// input complete
			
			int[] answer = {00,00,00};
			if(prms[2]>=prsn[2]) {
				answer[2] = prms[2]-prsn[2]+answer[2];
			}
			else {
				answer[2] = prms[2]-prsn[2]+60+answer[2];
				answer[1] = -1;
			}
			if(prms[1]>=prsn[1]) {
				answer[1] = prms[1]-prsn[1]+answer[1];
			}
			else {
				answer[1] = prms[1]-prsn[1]+60+answer[1];
				answer[0] = -1;
			}
			if(prms[0]>=prsn[0]) {
				answer[0] = prms[0]-prsn[0]+answer[0];
			}
			else {
				answer[0] = prms[0]-prsn[0]+24+answer[0];
			}
			if(answer[0] < 0) answer[0]+=24;
			// calculate complete
			
			//System.out.printf("#%d %2d:%2d:%2d\n", test, answer[0], answer[1], answer[2]);
			System.out.print("#"+test+" ");
			System.out.print(String.format("%02d", answer[0]));
			System.out.print(":");
			System.out.print(String.format("%02d", answer[1]));
			System.out.print(":");
			System.out.println(String.format("%02d", answer[2]));
		}
	}
}
