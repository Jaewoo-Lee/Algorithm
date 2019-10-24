import java.util.Scanner;

public class Main_°¨½Ã {
	static int[][] map;
	static int nothing; 
	static int cam_no;
	static int[][] cam;
	static int n, m;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt();
		m = s.nextInt();
		
		map = new int[n][m];
		nothing = 0;
		cam_no = 0;
		int idx = 0;
		cam = new int[64][3]; // type,x,y
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int temp = s.nextInt();
				if(temp == 0) nothing++;
				else if(temp>0 && temp <6) {
					cam_no++;
					cam[idx][0] = temp;
					cam[idx][1] = i;
					cam[idx][2] = j;
					idx++;
				}
				map[i][j] = temp;
			}
		}
		//input end
		
		min = 70;
		permu(cam_no, 0);
		System.out.println(min);
		
	}
	
	static int min;
	static int[] dir;
	public static void permu(int a, int b) {
		if(a == b) {
			rotate();
			return;
		}
		else if(b == 0) dir = new int[cam_no];
		
		for (int j = 1; j <= 4; j++) {
			dir[b] = j;
			permu(a, b+1);
		}
	}
	
	static boolean[][] tmap;
	public static void rotate() {
		tmap = new boolean[n][m];
		
		for (int i = 0; i < cam_no; i++) {
			switch(cam[i][0]) {
				case 1:
					cam1(cam[i][1], cam[i][2], dir[i]); break;
				case 2:
					cam2(cam[i][1], cam[i][2], dir[i]); break;
				case 3:
					cam3(cam[i][1], cam[i][2], dir[i]); break;
				case 4:
					cam4(cam[i][1], cam[i][2], dir[i]); break;
				case 5:
					cam5(cam[i][1], cam[i][2]); break;
			}
		}
		
		check();
		
		return;
	}


	public static void cam1(int i, int j, int di) {
		int gox = 0;
		int goy = 0;
		if(di == 1) { gox = 0; goy = 1;}
		else if(di == 2) { gox = -1; goy = 0;}
		else if(di == 3) { gox = 0; goy = -1;}
		else if(di == 4) { gox = 1; goy = 0;}

		int ni=i;
		int nj=j;
		
		while(true) {
			ni+=gox;
			nj+=goy;
			
			if(ni>=n || ni<0) break;
			if(nj>=m || nj<0) break;
			if(map[ni][nj] == 6) break;
			
			tmap[ni][nj] = true;
		}
	}
	public static void cam3(int i, int j, int di) {
		int gox = 0;
		int goy = 0;
		int gox2 = 0;
		int goy2 = 0;
		
		if(di == 1) { gox = 0; goy = 1; gox2 = -1; goy2 = 0;}
		else if(di == 2) { gox = -1; goy = 0;gox2 = 0; goy2 = -1;}
		else if(di == 3) { gox = 0; goy = -1;gox2 = 1; goy2 = 0;}
		else if(di == 4) { gox = 1; goy = 0; gox2 = 0; goy2 = 1;}
		
		int ni=i;
		int nj=j;

		while(true) {
			ni+=gox;
			nj+=goy;
			
			if(ni>=n || ni<0) break;
			if(nj>=m || nj<0) break;
			if(map[ni][nj] == 6) break;
			
			tmap[ni][nj] = true;
		}
		
		
		ni=i;
		nj=j;

		while(true) {
			ni+=gox2;
			nj+=goy2;
			
			if(ni>=n || ni<0) break;
			if(nj>=m || nj<0) break;
			if(map[ni][nj] == 6) break;
			
			tmap[ni][nj] = true;
		}
	}
	public static void cam5(int i, int j) {
		int gox = 0;
		int goy = 0;
		int gox2 = 0;
		int goy2 = 0;
		int di = 1;
		
		if(di == 1) { gox = 0; goy = 1; gox2 = -1; goy2 = 0;}
		else if(di == 2) { gox = -1; goy = 0;gox2 = 0; goy2 = -1;}
		else if(di == 3) { gox = 0; goy = -1;gox2 = 1; goy2 = 0;}
		else if(di == 4) { gox = 1; goy = 0; gox2 = 0; goy2 = 1;}
		
		int ni=i;
		int nj=j;
		
		while(true) {
			ni+=gox;
			nj+=goy;
			
			if(ni>=n || ni<0) break;
			if(nj>=m || nj<0) break;
			if(map[ni][nj] == 6) break;
			
			tmap[ni][nj] = true;
		}
		
		
		ni=i;
		nj=j;
		
		while(true) {
			ni+=gox2;
			nj+=goy2;
			
			if(ni>=n || ni<0) break;
			if(nj>=m || nj<0) break;
			if(map[ni][nj] == 6) break;
			
			tmap[ni][nj] = true;
		}
		gox*=-1;
		goy*=-1;
		
		ni=i;
		nj=j;

		while(true) {
			ni+=gox;
			nj+=goy;
			
			if(ni>=n || ni<0) break;
			if(nj>=m || nj<0) break;
			if(map[ni][nj] == 6) break;
			
			tmap[ni][nj] = true;
		}
		
		gox2*=-1;
		goy2*=-1;
		
		ni=i;
		nj=j;

		while(true) {
			ni+=gox2;
			nj+=goy2;
			
			if(ni>=n || ni<0) break;
			if(nj>=m || nj<0) break;
			if(map[ni][nj] == 6) break;
			
			tmap[ni][nj] = true;
		}
	}
	public static void cam4(int i, int j, int di) {
		int gox = 0;
		int goy = 0;
		int gox2 = 0;
		int goy2 = 0;
		
		if(di == 1) { gox = 0; goy = 1; gox2 = -1; goy2 = 0;}
		else if(di == 2) { gox = -1; goy = 0;gox2 = 0; goy2 = -1;}
		else if(di == 3) { gox = 0; goy = -1;gox2 = 1; goy2 = 0;}
		else if(di == 4) { gox = 1; goy = 0; gox2 = 0; goy2 = 1;}
		
		int ni=i;
		int nj=j;
		
		while(true) {
			ni+=gox;
			nj+=goy;
			
			if(ni>=n || ni<0) break;
			if(nj>=m || nj<0) break;
			if(map[ni][nj] == 6) break;
			
			tmap[ni][nj] = true;
		}
		
		
		ni=i;
		nj=j;
		
		while(true) {
			ni+=gox2;
			nj+=goy2;
			
			if(ni>=n || ni<0) break;
			if(nj>=m || nj<0) break;
			if(map[ni][nj] == 6) break;
			
			tmap[ni][nj] = true;
		}
		
		gox*=-1;
		goy*=-1;
		
		ni=i;
		nj=j;

		while(true) {
			ni+=gox;
			nj+=goy;
			
			if(ni>=n || ni<0) break;
			if(nj>=m || nj<0) break;
			if(map[ni][nj] == 6) break;
			
			tmap[ni][nj] = true;
		}
	}
	public static void cam2(int i, int j, int di) {
		int gox = 0;
		int goy = 0;
		
		if(di == 1 || di == 3) { gox = 0; goy = 1;}
		else if(di == 2 || di == 4) { gox = -1; goy = 0;}

		int ni=i;
		int nj=j;

		while(true) {
			ni+=gox;
			nj +=goy;
			
			if(ni>=n || ni<0) break;
			if(nj>=m || nj<0) break;
			if(map[ni][nj] == 6) break;
			
			tmap[ni][nj] = true;
		}
		
		gox*=-1;
		goy*=-1;
		
		ni=i;
		nj=j;

		while(true) {
			ni+=gox;
			nj+=goy;
			
			if(ni>=n || ni<0) break;
			if(nj>=m || nj<0) break;
			if(map[ni][nj] == 6) break;
			
			tmap[ni][nj] = true;
		}
	}


	public static void check() {
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] == 0 && !tmap[i][j]) temp++;
			}
		}
		
		if(min>temp) min = temp;
		
		return;
	}
	
}
