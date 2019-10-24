import java.util.Scanner;

public class Solution_7088_은기의송아지세기_이재우 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			int n = s.nextInt();
			int q = s.nextInt();
			
			int[][] arr = new int[n+1][4];
			int temp1=0;
			int temp2=0;
			int temp3=0;
			
			for (int i = 1; i <= n; i++) {
				int temp = s.nextInt();
				if(temp == 1) {
					arr[i][1]= ++temp1;
					arr[i][2]=temp2;
					arr[i][3]=temp3;
				}
				else if(temp == 2) {
					arr[i][2]= ++temp2;
					arr[i][1]=temp1;
					arr[i][3]=temp3;
				}
				else {
					arr[i][3]= ++temp3;
					arr[i][1]=temp1;
					arr[i][2]=temp2;
				}
			}
			
			System.out.println("#"+test+" ");

			for (int i = 0; i < q; i++) {
				int tt = s.nextInt();
				int gg = s.nextInt();
				
				System.out.print((arr[gg][1]-arr[tt-1][1])+" "+(arr[gg][2]-arr[tt-1][2])+" "+(arr[gg][3]-arr[tt-1][3])+"\n");
			}
		}
	}
}
