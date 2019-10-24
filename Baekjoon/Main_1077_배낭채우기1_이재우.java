import java.util.Scanner;

public class Main_1077_배낭채우기1_이재우 {
	public static int[][] bo;
	public static int[] memo;
	public static int n, w;
	public static int gmax;

	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		n = s.nextInt();
		w = s.nextInt();
		
		bo = new int[n+1][2];
		int gmin = 0;
		for (int i = 1; i <= n; i++) {
			int m = s.nextInt();
			int g = s.nextInt();
			
			bo[i][0] = m;
			bo[i][1] = g;
		}//input end
		
		memo = new int[w+1];
		gmax=-1;
		
		start(n, w);
		
		for (int i = 0; i < memo.length; i++) {
			if(memo[i]>gmax) gmax=memo[i];
		}
		System.out.println(gmax);
		
	}//main

	public static void start(int n, int w) {
		for (int i = 0; i <= w; i++) {
			for (int j = 1; j < bo.length; j++) {
				if(i-bo[j][0]<0)continue;
				memo[i] = memo[i-bo[j][0]]+bo[j][1] < memo[i]? memo[i]:memo[i-bo[j][0]]+bo[j][1];
				
			}
		}
	}
	
	
}//class
