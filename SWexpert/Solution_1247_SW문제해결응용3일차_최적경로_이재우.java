package Solution;
import java.util.Scanner;

public class Solution_1247_SW문제해결응용3일차_최적경로_이재우 {
	static boolean visit[];
	static int route;
	static int n;
	static int arr[][];
	static int zx; 
	static int zy;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			n = s.nextInt();
			visit = new boolean[n];
			arr = new int[n][2];
			
			int hx = s.nextInt(); //회사
			int hy = s.nextInt();
			zx = s.nextInt(); //집
			zy = s.nextInt();
			
			for (int i = 0; i < n; i++) {
				arr[i][0] = s.nextInt();
				arr[i][1] = s.nextInt();
			} //고객 정보
						
			route = 100000;
			
			for (int i = 0; i < n; i++) {
				visit[i] = true;
				start(hx, hy, arr[i][0], arr[i][1], 0);	
				visit[i] = false;		
			}
			
			System.out.println("#"+test+" "+route);
		}
	}
	
	public static void start(int sx, int sy, int dx, int dy, int tRoute) {
		boolean flag = true;
		int t1 = Math.abs(sx-dx);
		int t2 = Math.abs(sy-dy);
		tRoute+=(t1+t2);
		
		for (int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				flag = true;
				start(dx,dy,arr[i][0], arr[i][1], tRoute);
				visit[i] = false;
				flag = false;
			}
		}
		
		if(flag) home(dx,dy,zx,zy,tRoute);
		return;
	}

	public static void home(int dx, int dy, int zx, int zy, int tRoute) {
		int t1 = Math.abs(dx-zx);
		int t2 = Math.abs(dy-zy);
		
		if(route > tRoute+t1+t2) route = tRoute+t1+t2;
	}
}
