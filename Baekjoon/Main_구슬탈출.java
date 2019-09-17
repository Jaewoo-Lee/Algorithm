import java.util.Scanner;

public class Main_±∏ΩΩ≈ª√‚ {
	static char[][] map;
	static char[][] map2, map3;
	static int ox=0,oy=0;
	static int n,m;
	static int minn;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		m = s.nextInt();
		
		map = new char[n][m];
		String str = "";
		s.nextLine();
		
		int rx=0,ry=0;
		int bx=0,by=0;
		for (int i = 0; i < n; i++) {
			str = s.nextLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'R') {
					rx = i;
					ry = j;
				}
				else if(map[i][j] == 'B') {
					bx=i;
					by =j;
				}
				else if(map[i][j] == 'O') {
					ox = i;
					oy = j;
				}
			}
		}
		//input end
		
		minn = 1000;
		move(rx,ry,bx,by,0,map);
		
		if(minn > 10) System.out.println("-1");
		else System.out.println(minn);
	}
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void move(int nrx,int nry, int nbx, int nby, int cnt, char[][] map2) {
		if(cnt>10) return;
		if(nbx==ox && nby==oy) return;
		if(nrx==ox && nry==oy) {
			if(minn>cnt)
				minn = cnt;
		}
		
		for (int i = 0; i < 4; i++) {
			int nnrx = nrx;
			int nnry = nry;
			int nnbx = nbx;
			int nnby = nby;
			
			char[][] map3 = new char[n][m];
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < m; j2++) {
					map3[j][j2] = map2[j][j2];
				}
			}

			for (int j = 0; j <= 10; j++) {
				if(nnbx == ox && nnby == oy) return;
				if(nnrx==ox && nnry==oy) {
					for (int j2 = 0; j2 <= 10; j2++) {
						if(map3[nnbx+(dx[i]*j2)][nnby+(dy[i]*j2)] == '#') break;
						if(nnbx+(dx[i]*j2)==ox&&nnby+(dy[i]*j2) == oy) return;
					}
					
					if(minn>cnt+1) {
						minn = cnt+1;
						return;
					}
				}
				if(map3[nnrx+dx[i]][nnry+dy[i]] == '.' || (nnrx+dx[i]==ox&&nnry+dy[i] == oy)) {
					if(nnrx==ox && nnry==oy) ;
					else {
						map3[nnrx][nnry] = '.';
						nnrx+=dx[i];
						nnry+=dy[i];
						map3[nnrx][nnry] = 'R';
					}
				}
				if(map3[nnbx+dx[i]][nnby+dy[i]] == '.' || (nnbx+dx[i]==ox&&nnby+dy[i] == oy)) {
					map3[nnbx][nnby] = '.';
					nnbx+=dx[i];
					nnby+=dy[i];
					map3[nnbx][nnby] = 'B';
				}
			}
			
			System.out.println("=========="+cnt+"============");
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < m; j2++) {
					System.out.print(map3[j][j2]);
				}
				System.out.println();
			}
			System.out.println();
			
			if(nnrx == nrx && nnry == nry && nnbx == nbx && nnby == nby) continue;
			move(nnrx, nnry, nnbx, nnby, cnt+1, map3);
		}
	}
}
