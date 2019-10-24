import java.util.Scanner;

public class Main_아기상어 {
	static int n;
	static int[][] map;
	static int[][] nmap;
	static int baby_x;
	static int baby_y;
	static int baby_m;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {1,0,-1,0};
	
	static int maxx;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		
		map = new int[n][n];
		maxx = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = s.nextInt();
				if(map[i][j] == 9) {
					baby_x = i;
					baby_y = j;
				}
				else if(map[i][j] < 9) {
					maxx = maxx>map[i][j]? maxx:map[i][j];
				}
			}
		}// input end
		
//		System.out.println();
		int time = 0;
		while(maxx>0) {
			
		}
		
		System.out.println(time);
		
	}
}
 