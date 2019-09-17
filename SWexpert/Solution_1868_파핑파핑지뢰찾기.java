import java.util.Scanner;

public class Solution_1868_파핑파핑지뢰찾기 {
	static char[][] map;
	static boolean[][] visit;
	static int n, done;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			n = s.nextInt();
			int minn = -1;
			int cur = -1;
			
			map = new char[n][n];
			visit = new boolean[n][n];
			done = 0;
			for (int i = 0; i < n; i++) {
				String str = s.next();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j] == '*') done++;
				}
			} //input end

			int click_cnt=0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j] == '*') continue;
					if(!visit[i][j]&&count(i,j) == 0) {
						click_cnt++;
						click(i,j);
					}
				}
			}//다 돌았다
			
			click_cnt+=(n*n)-done;
			System.out.println("#"+test+" "+click_cnt);
		}
	}
	
	public static void click(int x, int y) {//  '.' && visit:false 보장
		visit[x][y] = true;
		done++;
		if(count(x,y) != 0) return;
		for (int i = 0; i < 8; i++) {
			int tx = x+dx[i];
			int ty = y+dy[i];
			
			if(tx<0 || tx>=n) continue;
			if(ty<0 || ty>=n) continue;
			if(map[tx][ty] == '.' && !visit[tx][ty]) {
				click(tx, ty);
			}
		}
	}
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,-1,1,-1,0,1};
	public static int count(int x, int y) {
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			int tx = x+dx[i];
			int ty = y+dy[i];
			
			if(tx<0 || tx>=n) continue;
			if(ty<0 || ty>=n) continue;
			if(map[tx][ty] == '*') cnt++; 
		}
		return cnt;
	}
}
