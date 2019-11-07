import java.util.HashMap;
import java.util.Scanner;

public class Main_treasure_final {
	static boolean visit[][];
	static String map[][];
	static int ga, se;
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,-1,0, 1}; //하 좌 상 우
	static int maxx, minn;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		se = s.nextInt();
		ga = s.nextInt();
		visit = new boolean[se][ga];
		maxx = -1;
		minn = 5000;
		
		map = new String[se][ga];
		for (int i = 0; i < se; i++) {
			map[i] = s.next().split("");
		}
		
		for (int i = 0; i < se; i++) {
			for (int j = 0; j < ga; j++) {
				if(map[i][j].equals("W")) {
//					System.out.println("pass");
					continue;
				}
				visit[i][j] = true;
				move(i,j,0);
//				System.out.println(minn+" "+maxx);
				if(minn<maxx) minn = maxx;
				visit[i][j] = false;
			}
		}
		
		System.out.println(minn);
	}
	public static void move(int i, int j, int k) {
		for (int g = 0; g < 4; g++) {
			int nx = i+dx[g];
			int ny = j+dy[g];
			
			if(nx<0 || ny<0 || nx>=se || ny>=ga) continue;
			if(map[nx][ny].equals("W") || visit[nx][ny]) continue;
			
			visit[nx][ny] = true;
			move(nx, ny, k+1);
			visit[nx][ny] = false;
		}
		//max구해야된다
		if(k>maxx) maxx = k;
//		System.out.print(k+" ");
	}
}
