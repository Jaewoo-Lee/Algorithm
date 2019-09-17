import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_7733_치즈도둑 {
	static int[][] map;
	static int n;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= t; ++test) {
			n = s.nextInt();
			map = new int[n][n];
			s.nextLine();
			
			for (int i = 0; i < n; i++) {
				String str = s.nextLine();
				StringTokenizer st = new StringTokenizer(str," ");
				int j = 0;
				while (st.hasMoreTokens()) {
					map[i][j++] = Integer.parseInt(st.nextToken());
				}
			}// input end			
			
			int cal_max = (n*n)%2==1? ((n*n)+1)>>1 : (n*n)>>1;  // 이론 상 최대 값
			int cur_max = 0;
			int day = 0;
			
			while(cur_max != cal_max && day<=100) {
				visit = new boolean[n][n];
				int temp = count(day++);
				if(temp > cur_max) cur_max = temp;
				if(temp == 0) break;
			}
			
			System.out.println("#"+test+" "+cur_max);
		}
	}

	static boolean[][] visit;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	
	public static int count(int day) {
		int cnt=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visit[i][j]&&map[i][j]>day) {
					visit[i][j] = true;
					dfs(day, i,j,cnt++);
				}
			}
		}
		
		return cnt;
	}

	public static void dfs(int day, int x, int y, int cnt) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || ny <0) continue;
			if(nx>=n || ny >=n) continue;
			if(map[nx][ny]<=day || visit[nx][ny]) continue;
			
			visit[nx][ny] = true;
			dfs(day, nx,ny, cnt);
		}
	}
}
