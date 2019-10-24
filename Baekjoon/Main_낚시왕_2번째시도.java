import java.util.Scanner;

public class Main_낚시왕_2번째시도 {
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, 1, -1};
	static shark[][] map;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int r = s.nextInt();
		int c = s.nextInt();
		int m = s.nextInt();
		
		map = new shark[r+1][c+1];
		
		for (int i = 0; i < m; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			
			int spd = s.nextInt();
			int dir = s.nextInt();
			int size = s.nextInt();
			
			if(dir == 1 || dir == 2) {
				spd = spd % (2*r-2);
			}
			else {
				spd = spd % (2*c-2);
			}
			map[x][y] = new shark(spd,dir,size);
		}
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if(map[i][j] == null) map[i][j] = new shark(0,0,0);
			}
		}
		long summ = 0;
		
		int per = 0;
		while(per <= c) {
//			System.out.println("+++++++++++++++++++++++++++");
//			for (int i = 1; i <= r; i++) {
//				for (int j = 1; j <= c; j++) {
//					System.out.print(map[i][j].size + " ");
//				}
//				System.out.println();
//			}
			
			// 낚시왕 이동
			per++;
			if(per > c) break;
			
			// 상어잡이
			for (int i = 1; i <= r; i++) {
				if(map[i][per].size > 0) {
					summ+=map[i][per].size;
					map[i][per].size = 0;
					break;
				}
			}
			
			// 상어 이동
			shark[][] nmap = new shark[r+1][c+1];
			for (int i = 1; i <= r; i++) {
				for (int j = 1; j <= c; j++) {
					nmap[i][j] = new shark(0,0,0);
				}
			}
			for (int i = 1; i <= r; i++) {
				for (int j = 1; j <= c; j++) {
					if(map[i][j].size > 0) {
						int v = map[i][j].spd;
						int tx = i;
						int ty = j;
						int td = map[i][j].dir;
						while(v>0) {
							tx+=dx[td];
							ty+=dy[td];
							if(tx==1 && td==1) {
								td = 2;
							}
							else if(ty==1 && td==4) {
								td = 3;
							}
							else if(tx==r && td==2) {
								td = 1;
							}
							else if(ty==c && td==3) {
								td = 4;
							}
							v--;
						}
						
						if(nmap[tx][ty].size == 0) {
							nmap[tx][ty].dir = td;
							nmap[tx][ty].size = map[i][j].size;
							nmap[tx][ty].spd = map[i][j].spd;
						}
						else if(nmap[tx][ty].size < map[i][j].size) {
							nmap[tx][ty].dir = td;
							nmap[tx][ty].size = map[i][j].size;
							nmap[tx][ty].spd = map[i][j].spd;
						}
						
						map[i][j].size = 0;
					}
				}
			}
			
			map = nmap;
			
		}
		
		System.out.println(summ);
	}
}
class shark{
	int dir = 0;
	int spd = 0;
	int size = 0;
	shark(int spd , int dir , int size){
		this.dir = dir;
		this.spd = spd;
		this.size = size;
	}
}