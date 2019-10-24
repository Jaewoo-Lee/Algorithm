import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2105_모의SW역량테스트_디저트카페_이재우 {
	public static int[][] map; 
	public static boolean[] visit; 
	public static int n; 
	public static int maxx; 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		
		for (int test = 1; test <= t; test++) {
			n = Integer.parseInt(br.readLine().trim());
			
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//사각형 꼭대기 기준으로 생각 == 꼭대기에서 항상 출발
			//map[0][1]   ~  map[0][n-1]
			//map[n-2][1] ~  map[n-2][n-1]
			
			/*
			 * 사각형 == 3점 찍으면 나머지 하나 자동 생성 
			 * -> 출발점(i,j)은 내가 정하고, (i+k,j-k)인 점 하나, (i+h, j+h)점 하나만 정하면 
			 * 											(단, 0<k,h)
			 * 나머지 한 점 자동으로 정해진다
			 * 
			 * 정해진 점 따라 visit 체크만 하면 됨
			 * 
			 */
			maxx = -1;
			for (int i = 0; i < n-2; i++) {
				for (int j = 1; j < n-1; j++) {
					start(i,j);
				}
			}
			
			System.out.println("#"+test+" "+maxx);
			
		}
	}
	public static void start(int i, int j) {
		for (int k = 1; i+k<n&&j-k>=0; k++) {
			for (int h = 1; i+h<n&&j+h<n; h++) {
				if(i+k+h>=n || j-k+h>=n) continue;
				int cnt = check(i,j,i+k,j-k,i+h,j+h,i+k+h,j-k+h);
				
//				System.out.print(cnt+" ");
				
				if(cnt > maxx) maxx=cnt;
			}
		}
		
	}
	public static int check(int x0, int y0, int x1, int y1, int x2, int y2, int x3, int y3) {
		visit = new boolean[101];
		int cnt = 1;
		
		visit[map[x0][y0]] = true;
		int x=x0;
		int y=y0;
//		System.out.println(x + " " + y);
		while(x!=x1&&y!=y1) {
			++x;
			--y;
			if(visit[map[x][y]])
				return -1;
			visit[map[x][y]]=true;
			cnt++;
//			System.out.println(x + " " + y);
		}
		while(x!=x3&&y!=y3) {
			++x;
			++y;
			if(visit[map[x][y]])
				return -1;
			visit[map[x][y]]=true;
			cnt++;
//			System.out.println(x + " " + y);
		}
		while(x!=x2&&y!=y2) {
			--x;
			++y;
			if(visit[map[x][y]])
				return -1;
			visit[map[x][y]]=true;
//			System.out.println(x + " " + y);
			cnt++;
		}
		while(x!=x0+1&&y!=y2+1) {
			--x;
			--y;
			if(visit[map[x][y]])
				return -1;
			visit[map[x][y]]=true;
			cnt++;
//			System.out.println(x + " " + y);
		}
		
		return cnt;
	}
}
