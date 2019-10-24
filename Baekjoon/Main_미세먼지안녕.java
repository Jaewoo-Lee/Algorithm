import java.util.Queue;
import java.util.Scanner;

public class Main_미세먼지안녕 {
	static int[][] map;
	static int n,m,t;
	static int ux, dnx;
	static int remain;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt();
		m = s.nextInt();
		t = s.nextInt();
		
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = s.nextInt();
			}
		}//input end
		ux=100;
		for (int i = 0; i < n; i++) {
			if(map[i][0]==-1) {
				ux=i;
				dnx=i+1;
				break;
			}
		}
		
		int time = 0;
		while(time != t) {
			// defusion
			int[][] nmap = new int[n][m];
			nmap[ux][0] = -1;
			nmap[dnx][0] = -1;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(map[i][j] > 0) {
						int num = 0;
						for (int k = 0; k < 4; k++) {
							int nx = i+dx[k];
							int ny = j+dy[k];
							
							if(nx < 0 || nx>= n) continue;
							if(ny < 0 || ny>= m) continue;
							if(map[nx][ny] == -1) continue;
							
							num++;
							nmap[nx][ny] += map[i][j]/5;
						}
						nmap[i][j] += map[i][j] - num*(map[i][j]/5);
					}
				}
			}
			
			map = nmap;
			
			// circulation
			for (int i = dnx+1; i < n-1; i++) {
				map[i][0] = map[i+1][0];
			}
			for (int j = 0; j < m-1; j++) {
				map[n-1][j] = map[n-1][j+1];
			}
			for (int i = n-1; i > dnx; i--) {
				map[i][m-1] = map[i-1][m-1];
			}
			for (int j = m-1; j > 1; j--) {
				map[dnx][j] = map[dnx][j-1];
			}
			map[dnx][1] = 0;
			
			for (int i = ux-1; i > 0 ; i--) {
				map[i][0] = map[i-1][0];
			}
			for (int j = 0; j < m-1; j++) {
				map[0][j] = map[0][j+1];
			}
			for (int i = 0; i < ux; i++) {
				map[i][m-1] = map[i+1][m-1];
			}
			for (int j = m-1; j > 1; j--) {
				map[ux][j]= map[ux][j-1];
			}
			map[ux][1] = 0;
			
			time++;
		}
		
		remain = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] > 0)
					remain+=map[i][j];
			}
		}
		
		System.out.println(remain);
	}
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
}
