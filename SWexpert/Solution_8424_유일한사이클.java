import java.util.Scanner;

public class Solution_8424_유일한사이클 {
	static int[][] map;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= test; test++) {
			int n = s.nextInt();
			
			map = new int[n+1][n+1];
			
			int x,y;
			for (int i = 0; i < n; i++) {
				x = s.nextInt();
				y = s.nextInt();
				
				map[x][y] = 1;
				map[y][x] = 1;
			}
			
			int start = 0;
			for (int i = 1; i <= n; i++) {
				int cnt = 0;
				for (int j = 1; j <= n; j++) {
					if(map[i][j] == 1) cnt++;
				}
				
				if(cnt >= 2) {
					start = i;
					break;
				}
			}
			
			int lcnt = 0;
			int goal = 0;
			while(goal == start) {
				
			}
		}
	}
}	
