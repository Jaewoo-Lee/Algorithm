import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_연구소3 {
	static int[][] map;
	static int n, m;
	static boolean[][] active; // 활성화 되었는가
	static int[][] mlist;      // 바이러스가 올 수 있는 위치 리스트
	static int idx;
	static int[] clist;        // 초기에 활성화된 바이러스 리스트
	static int minn;           // minimum
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt();
		m = s.nextInt();
		
		map = new int[n][n];
		
		mlist = new int[10][2];
		idx = -1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int temp = s.nextInt();
				map[i][j] = temp;
				if(temp == 2) {
					mlist[++idx][0] = i;
					mlist[idx][1] = j;
				}
			}
		} // input end
		
		minn = n*n;
		stmin = n*n; // static min : answer
		
		// combination
		clist = new int[m];
		combi(m, 0, -1);
		
		if(stmin == n*n) stmin = -1;
		
		System.out.println(stmin);
	}
	
	
	static int stmin;
	static Queue<ver> que;
	public static void combi(int total, int chosen, int current) {
		if(total == chosen) {
			active = new boolean[n][n];
			que = new LinkedList();
			
//			for (int i = 0; i <= idx; i++) {
//				active[mlist[i][0]][mlist[i][1]] = true;
//			}
//			
			for (int i = 0; i < m; i++) {
				active[mlist[clist[i]][0]][mlist[clist[i]][1]] = true;
				que.add(new ver(mlist[clist[i]][0], mlist[clist[i]][1], 0));
			}
			
			int curMin = defusion();  // current minimum
//			System.out.println(curMin);
			if(curMin< stmin) stmin = curMin;
			return;
		}
		
		for (int i = current+1; i <= idx; i++) {
			clist[chosen] = i;
			combi(total, chosen+1, i);
		}
	}

	public static int defusion() {
		int time = 0;
//		int[][] mmm = new int[n][n];
		while(!que.isEmpty() && time <= minn) {
			int i = que.peek().x;
			int j = que.peek().y;
			int ti = que.peek().t;
			
			que.poll();
			
//			System.out.println("======================");
//			for (int k = 0; k < n; k++) {
//				for (int k2 = 0; k2 < n; k2++) {
//					System.out.print(mmm[k][k2]+" ");
//				}
//				System.out.println();
//			}
			
			for (int k = 0; k < 4; k++) {
				int nx = i+dx[k];
				int ny = j+dy[k];
				
				if(nx < 0 || nx >= n) continue;
				if(ny < 0 || ny >= n) continue;
				if(map[nx][ny] == 1) continue;
				if(active[nx][ny]) continue;
				if(map[nx][ny] == 2) {
					active[nx][ny] = true;
					que.add(new ver(nx, ny, ti+1));
					continue;
				}
				
				active[nx][ny] = true;
//				mmm[nx][ny] = ti+1;
				que.add(new ver(nx, ny, ti+1));
				time=ti+1;
			}
			
		}
		
		if(check()) minn = minn>time? time:minn;
		
		return minn;
		
	}
	
	public static boolean check() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!active[i][j] && map[i][j] != 1)
					return false;
			}
		}
		return true;
	}
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
}
class ver{
	int x;
	int y;
	int t;
	
	public ver(int x, int y, int t) {
		this.x = x;
		this.y = y;
		this.t = t;
	}
}