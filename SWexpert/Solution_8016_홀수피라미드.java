import java.util.Scanner;

public class Solution_8016_Ȧ���Ƕ�̵� {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int t =  s.nextInt();
		for (int test = 1; test <= t; test++) {
			long m = s.nextLong();
			
			//m*m��° Ȧ�� -> 2*m*m -1 
			long temp = m*m;
			long temp2 = 2*temp;
			long right = temp2 -1;
			
			long temp3 = 4*(m-1);
			long left = right - temp3;
			
			System.out.println("#"+test+" "+left+" "+right);
		}
	}
}
