import java.util.Scanner;

public class Solution_8658 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		for (int test = 1; test <= t; test++) {
			int max = -1;
			int min = 10000000;
			
			for (int i = 0; i < 10; i++) {
				int temp = s.nextInt();
				int sum = 0;
				while(temp!=0) {
//					System.out.println(temp);
					sum+=temp%10;
					temp=temp/10;
				}
//				System.out.println(sum);
				if(sum > max) max = sum;
				if(sum < min) min = sum;
				
			}
			System.out.println("#"+test+" "+max+" "+min);
		}
	}
}
