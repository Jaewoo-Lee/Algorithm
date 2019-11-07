package Solution;

import java.util.Scanner;

public class Solution_7234_안전기지_이재우 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		int dx[] = {-2,-1,0,1,2, 0, 0,0,0};
		int dy[] = { 0, 0,0,0,0,-2,-1,1,2};

		for (int test = 1; test <= t; test++) {
			int maxx = -1;
			int n = s.nextInt();
			int b = s.nextInt();
			
			int map[][] = new int[n+1][n+1];
			
			for (int i = 0; i < b; i++) {
				int x = s.nextInt();
				int y = s.nextInt();
				
				for (int j = 0; j < dx.length; j++) {
					int nx = x+dx[j];
					int ny = y+dy[j];
					
					if(nx<=0 || ny<=0 || nx>n || ny>n) continue;
					
					map[nx][ny]++;
					if(maxx < map[nx][ny]) maxx = map[nx][ny];
				}
			}
			
			System.out.println("#"+test+" "+maxx);
		}
	}
}
