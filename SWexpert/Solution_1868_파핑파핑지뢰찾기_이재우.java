package Solution;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_1868_파핑파핑지뢰찾기_이재우 {
	static String map[][];
	static boolean visit[][];
	static int cnt, minn;
	static int n;
	
	public static class point{
		int x;
		int y;
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			n = s.nextInt();
			map = new String[n][n];
			visit = new boolean[n][n];
			minn = n*n;
					
			for (int i = 0; i < map.length; i++) {
				map[i] = s.next().split("");
			}
			
			cnt = 0;
			ArrayList<point> arr = new ArrayList<>();
			
			for (int i = 0; i < map.length; i++) 
				for (int j = 0; j < map[i].length; j++) 
					if(cntAround(i, j) == 0) 
						arr.add(new point(i,j));

			for(point g : arr) 
				if(map[g.x][g.y].equals(".")) {
					cnt++;
					visit[g.x][g.y] = true;
					click(g.x,g.y);
				}
			
			for (int i = 0; i < map.length; i++) 
				for (int j = 0; j < map[i].length; j++) 
					if(map[i][j].equals(".") && !visit[i][j]) {
						cnt++;
						visit[i][j] = true;
						click(i,j);
					}
			System.out.println("#"+test+" "+cnt);
		}
	}
	
	static int dx[] = {-1,-1,-1,0,0,1,1,1};
	static int dy[] = {-1,0,1,-1,1,-1,0,1};
	
	public static void click(int i, int j) {
		if(map[i][j].equals(".")) {
			int cct = cntAround(i,j);
			visit[i][j] = true;
						
			map[i][j] = cct+"";
			for (int h = 0; h < 8; h++) {
				int ni = i + dx[h];
				int nj = j + dy[h];
				if(ni<0 || nj<0 || ni>=n || nj>=n || visit[ni][nj]) continue;
				
				if(cct == 0)
					click(ni,nj);
			}
		}
	}		

	public static int cntAround(int i, int j) {
		int cnnt = 0;
		for (int k = 0; k < 8; k++) {
			int ni = i + dx[k];
			int nj = j + dy[k];
			if(ni<0 || nj<0 || ni>=n || nj>=n) continue;
			
			if(map[ni][nj].equals("*"))
				cnnt++;
		}
		
		return cnnt;
	}

}
