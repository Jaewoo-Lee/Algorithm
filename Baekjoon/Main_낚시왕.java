import java.util.Scanner;

public class Main_낚시왕 {
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
		int summ = 0;
		
		for (int t = 1; t <= c; t++) { // 한 turn
			for (int i = 1; i <= r; i++) {
				if(map[i][t].size != 0) {
					summ += map[i][t].size;
					System.out.println(t+"초에 "+map[i][t].size+"짜리 잡아서 총 "+summ);
					map[i][t].size = 0;
					break;
				}
			}// 잡혔음
			
			// 이동하자
			for (int i = 1; i <= r; i++) { 
				int tt = 0;
				for (int j = 1; j <= c; j++) { // map을 뒤져서
					if(map[i][j].size != 0) { // 상어가 있으면
						int move = map[i][j].spd;
						if(map[i][j].dir == 1) {// 위로 
							if(i-1 >= move) { // 방향 안 바꿔도 되
								if(map[i-move][j].size < map[i][j].size) { // 더 큰 상어 없으면
									map[i-move][j].dir = map[i][j].dir;
									map[i-move][j].size = map[i][j].size;
									map[i-move][j].spd = map[i][j].spd;
								}
								map[i][j].size = 0;
							}
							else { //방향 바꿔야되
								tt = i-move;
								int cnt = 0;
								if(tt <= 0) {
									tt *= -1;
									tt += 2;
									cnt++;
								}
								if(tt > r) {
									tt -= (r-1);
									cnt++;
								}
								
								if(map[tt][j].size < map[i][j].size) {
									map[tt][j].size = map[i][j].size;
									map[tt][j].spd = map[i][j].spd;
									if(cnt ==1) map[tt][j].dir = 2;
								}
								if(i != tt) map[i][j].size = 0;
								else map[tt][j].dir = 1;
							}
							
						}
						else if(map[i][j].dir == 2) {
							if(r-i > move) {
								if(map[i+move][j].size < map[i][j].size) { // 더 큰 상어 없으면
									map[i+move][j].dir = map[i][j].dir;
									map[i+move][j].size = map[i][j].size;
									map[i+move][j].spd = map[i][j].spd;
								}
								map[i][j].size = 0;
							}
							else { //방향 바꿔야되
								tt = i+move;
								int cnt = 0;
								if(tt > r) {
									tt = 2*r - i - move;
									cnt++;
								}
								if(tt <= 0) {
									tt *= -1;
									tt += 2;
									cnt++;
								}
								
								if(map[tt][j].size < map[i][j].size) { // 더 큰 상어 없으면
									map[tt][j].size = map[i][j].size;
									map[tt][j].spd = map[i][j].spd;
									if(cnt ==1) map[tt][j].dir = 1;
									else map[tt][j].dir = 2;
								}
								if(i != tt) map[i][j].size = 0;
							}
						}
						else if(map[i][j].dir == 3) { //우
							if(c-j > move) {
								if(map[i][j+move].size < map[i][j].size) { // 더 큰 상어 없으면
									map[i][j+move].dir = map[i][j].dir;
									map[i][j+move].size = map[i][j].size;
									map[i][j+move].spd = map[i][j].spd;
								}
								map[i][j].size = 0;
							}
							else { //방향 바꿔야되
								tt = j+move;
								int cnt = 0;
								if(tt > c) {
									tt = 2*c - tt;
									cnt++;
								}
								if(tt <= 0) {
									tt *= -1;
									tt += 2;
									cnt++;
								}
								
								if(map[i][tt].size < map[i][j].size) {
									map[i][tt].size = map[i][j].size;
									map[i][tt].spd = map[i][j].spd;
									if(cnt ==1) map[i][tt].dir = 4;
									else map[tt][j].dir = 3;
								}
								if(j != tt) map[i][j].size = 0;
							}
						}
						else {
							if(j-1 > move) {
								if(map[i][j-move].size < map[i][j].size) { // 더 큰 상어 없으면
									map[i][j-move].dir = map[i][j].dir;
									map[i][j-move].size = map[i][j].size;
									map[i][j-move].spd = map[i][j].spd;
								}
								map[i][j].size = 0;
							}
							else { //방향 바꿔야되
								tt = j-move;
								int cnt = 0;
								if(tt <= 0) {
									tt *= -1;
									tt += 2;
									cnt++;
								}
								if(tt > c) {
									tt = 2*c - tt;
									cnt++;
								}
								
								if(map[i][tt].size < map[i][j].size) {
									map[i][tt].size = map[i][j].size;
									map[i][tt].spd = map[i][j].spd;
									if(cnt ==1) map[i][tt].dir = 3;
									else map[tt][j].dir = 4;
								}
								if(j != tt) map[i][j].size = 0;
							}
							
						}
					}
				}
			}
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
