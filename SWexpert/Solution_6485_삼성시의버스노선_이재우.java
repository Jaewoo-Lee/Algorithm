import java.util.Scanner;

public class Solution_6485_삼성시의버스노선_이재우 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			int arr[] = new int[5001];
			int n = s.nextInt();
			for (int i = 0; i < n; i++) {
				int j = s.nextInt();
				int k = s.nextInt();
				
				for (int p = j; p <= k; p++) {
					arr[p]++;
				}
			}
			int pp = s.nextInt();
			System.out.print("#"+test+" ");
			for (int l = 0; l < pp; l++) {
				int tt =s.nextInt();
				System.out.print(arr[tt]+" ");
			}
			System.out.println();
			
		}
	}
}
