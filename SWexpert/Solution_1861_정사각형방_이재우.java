import java.util.Scanner;

public class Solution_1861_정사각형방_이재우 {
	static int cnt;
	static int maxx;
	static int mNum;
	static int n;
	static int map[][];
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			n = s.nextInt();
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = s.nextInt();
				}
			}
			
			maxx = -1;
			mNum = -1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cnt = 1;
					start(i, j,i,j, cnt);
					
				}
			}
			
			System.out.println("#"+test+" "+mNum+" "+maxx);
		}
	}

	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,-1,0,1};
	public static void start(int i, int j,int a, int b, int cnt) {
		for (int k = 0; k < 4; k++) {
			int nx = dx[k]+a;
			int ny = dy[k]+b;
			
			if(nx<0||ny<0||nx>=n||ny>=n) continue;
			if(map[nx][ny] == map[a][b]+1)
				start(i,j,nx,ny,cnt+1);			
		}
		if(cnt > maxx) {
			maxx = cnt;
			mNum = map[i][j];
		}
		else if(cnt == maxx) {
			mNum = mNum<map[i][j]? mNum:map[i][j];
		}
	}
}
