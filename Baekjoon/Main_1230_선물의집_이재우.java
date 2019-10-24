import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1230_선물의집_이재우 {
	public static int[][] map;
	public static boolean[][] visit;
	public static int n;
	public static int maxx;
	
	public static int[] dx = {1,0,-1,0};//하좌상우
	public static int[] dy = {0,-1,0,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		
		map = new int[n][n];
		visit = new boolean[n][n];
		maxx = -1;
		for (int i = 0; i < n; i++) {
			String temp = br.readLine().trim();
			for (int j = 0; j < n; j++) {
				map[i][j] = temp.charAt(2*j)-'0';
			}
		}//input end
		
		if(map[0][0]==2) start(0,0,1);
		else start(0,0,0);
		
		System.out.println(maxx);
	}
	public static void start(int x, int y, int cnt) {
		visit[x][y] = true;
		if(x==n-1&&y==n-1) {
			maxx = maxx<cnt? cnt:maxx;
			visit[x][y] = false;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0||nx>=n||ny<0||ny>=n) continue;
			if(map[nx][ny]==1) continue;
			if(visit[nx][ny]) continue;
			
			if(map[nx][ny]==2) start(nx,ny,cnt+1);
			else start(nx,ny,cnt);
		}
		visit[x][y] = false;
	}
}
