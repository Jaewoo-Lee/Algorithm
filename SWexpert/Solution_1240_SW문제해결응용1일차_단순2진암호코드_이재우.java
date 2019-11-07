package Solution;
import java.util.Scanner;

public class Solution_1240_SW문제해결응용1일차_단순2진암호코드_이재우 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test=1; test<=t; test++) {
			int n = s.nextInt();
			int M = s.nextInt();
			String row = ""; 
			
			for (int i=0; i<n; i++) {
				String ss = s.next();
				if (row == "" && ss.contains("1"))
					row = ss;
			}
			
			int lastIndex = row.lastIndexOf('1');
			row = row.substring(lastIndex-55, lastIndex+1);
			
//			System.out.println(row);
			
			int a[] = new int[8];
			for(int i=0; i<8; i++) {
				switch(row.substring(i*7, i*7+7)) {
						case "0001101":
							a[i]=0; 
							break;
						case "0011001": 
							a[i]=1; 
							break;
						case "0010011": 
							a[i]=2; 
							break;
						case "0111101": 
							a[i]=3;
							break;
						case "0100011": 
							a[i]=4; 
							break;
						case "0110001": 
							a[i]=5; 
							break;
						case "0101111": 
							a[i]=6; 
							break;
						case "0111011": 
							a[i]=7; 
							break;
						case "0110111": 
							a[i]=8; 
							break;
						case "0001011": 
							a[i]=9; 
							break;
				}
			}
			int result = 0;
			int check = (a[0]+a[2]+a[4]+a[6])*3+a[1]+a[3]+a[5]+a[7];
			if( check>9 && check%10==0 ) {
				result = a[0]+a[1]+a[2]+a[3]+a[4]+a[5]+a[6]+a[7];
			}
			System.out.printf("#%d %d\n", test, result);
		}
	}
}
