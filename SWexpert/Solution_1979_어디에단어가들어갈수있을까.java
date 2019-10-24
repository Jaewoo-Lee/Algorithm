import java.util.Scanner;

public class Solution_1979_어디에단어가들어갈수있을까 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		for (int test = 1; test <= t; test++) {
			int n = s.nextInt();
			int k = s.nextInt();
			
			int temp = 0;
			int answer = 0;
			
			int[][] map = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				temp=0;
				for (int j = 0; j < n; j++) {
					map[i][j] = s.nextInt();
					if(map[i][j] == 1) temp++;
					else {
						if(temp==k) answer++;
						temp=0;
					}
				}
				
				if(temp == k) answer++;
			}
			
		
			for (int j = 0; j < n; j++) {
				temp=0;
				for (int i = 0; i < n; i++) {
					if(map[i][j] == 1) temp++;
					else {
						if(temp == k) answer++;
						temp=0;
					}
				}
				if(temp == k) answer++;
			}
			
			System.out.println("#"+test+" "+answer);
		}
	}
}
