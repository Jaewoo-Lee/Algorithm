import java.util.Scanner;

public class Main_1082_화염에서탈출_이재우 {
	static String map[][];
	static boolean visit[][];

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int r = s.nextInt();
		int c = s.nextInt();

		map = new String[r][c];
		visit = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			String temp = s.next();
			map[i] = temp.split("");
		}

		int sque[][] = new int[5000][2];
		int bque[][] = new int[5000][2];
		int bh = -1, br = 0;
		int sh = -1, sr = 0;
		int bx = 0, by = 0;
		int sx = 0, sy = 0;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j].equals("S")) {
					visit[i][j] = true;
					sque[sr][0] = i;
					sque[sr++][1] = j;
				} else if (map[i][j].equals("*")) {
					visit[i][j] = true;
					bque[br][0] = i;
					bque[br++][1] = j;
				}
			}
		}

		int m = 0;
		while(true) {
			m++;
			int b_cnt = br-bh-1;
			
			for (int i = 0; i < b_cnt; i++) {
				bx = bque[++bh][0];
				by = bque[bh][1];
				
				for (int ii = 0; ii < 4; ii++) {
					int nx = bx + mx[ii];
					int ny = by + my[ii];
				
					if (nx < 0 || ny < 0 || nx >= r || ny >= c)
						continue;
					if (map[nx][ny].equals("X") || map[nx][ny].equals("*") || map[nx][ny].equals("D"))
						continue;
					
					visit[nx][ny] = true;
					map[nx][ny] = "*";
					bque[br][0] = nx;
					bque[br++][1] = ny;
				}
			}//불!!!!!!!!!
			
			boolean flag = false;
			int s_cnt = sr-sh-1;
			for (int i = 0; i < s_cnt; i++) {
				sx = sque[++sh][0];
				sy = sque[sh][1];
				
				for (int ii = 0; ii < 4; ii++) {
					int nx = sx + mx[ii];
					int ny = sy + my[ii];
				
					if (nx < 0 || ny < 0 || nx >= r || ny >= c)
						continue;
					if (map[nx][ny].equals("X") || visit[nx][ny])
						continue;
					
					if(map[nx][ny].equals("D")) {
						flag = true;
						System.out.println(m);
						return;
					}
					
					visit[nx][ny] = true;
					map[nx][ny] = "S";
					sque[sr][0] = nx;
					sque[sr++][1] = ny;
				}
			}//휴먼!!!!!!!!!!!!!!!
			
			if(sr-sh-1 == 0) {
				System.out.println("impossible");
				return;
			}
		}
	}// main

	static int mx[] = { 1, 0, -1, 0 };
	static int my[] = { 0, -1, 0, 1 };
}// class
