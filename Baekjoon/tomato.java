import java.util.Scanner;

public class tomato {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		
		int dx[] = {1,0,0,-1,0,0};
		int dy[] = {0,1,0,0,-1,0};
		int dz[] = {0,0,1,0,0,-1};
		
		
		int m = s.nextInt();
		int n = s.nextInt();
		int h = s.nextInt();
		
		int arr[][][] = new int[h][n][m];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					arr[i][j][k] = s.nextInt();
				}
			}
		}
		int cnt=0;
		int day = 0;
		boolean flag = false;
		while(cnt++<m*n*h) {
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < m; k++) {
						if(arr[i][j][k] == 1) {
							flag = false;
							for (int g = 0; g < 6; g++) {
								
								int ni = i+dz[g];
								int nj = j+dx[g];
								int nk = k+dy[g];
								
								
								if(ni<0||nj<0||nk<0||ni>=h||nj>=n||nk>=m)
									continue;
								
								if(arr[ni][nj][nk] == -1) continue;
								else if(arr[ni][nj][nk] == 1)continue;
								else{
									arr[ni][nj][nk] = 1;
									flag = true;
								}
							}
							if(flag) day++;
						}
					}
				}
			}
		}
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if(arr[i][j][k] != 1) {
						System.out.println("-1");
						return;
					}
				}
			}
		}
		
		
		System.out.println(day);
		
	}
}
