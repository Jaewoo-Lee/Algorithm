import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1733_오목_이재우 {
	public static int[][] map;
	public static int winner;
	public static int wx,wy;
	
	public static void main(String[] args) throws Exception {
		map = new int[20][20];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 1; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			for (int j = 1; j < 20; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//input end
		
		
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				if(map[i][j] == 1 || map[i][j]==2) {
					if(chkG(i,j)||chkS(i,j)||chkDu(i,j)||chkDd(i,j)) {
						System.out.println(winner);
						System.out.println(wx+" "+wy);
						return;
					}
				}
			}
		}
		System.out.println("0");
	}//main

	public static int[] dx= {-1,-1,-1,0,0,1,1,1};
	public static int[] dy= {-1,0,1,-1,1,-1,0,1};
	
	public static boolean chkG(int i, int j) {
		Queue<pos> que = new LinkedList<pos>();
		int cnt = 1;
		boolean visit[][] = new boolean[20][20];
		int onetwo = map[i][j];
		
		que.add(new pos(i, j));
		visit[i][j] = true;
		
		while(!que.isEmpty()) {
			pos temp = que.poll();
			int ni = temp.x+dx[3];
			int nj = temp.y+dy[3];
			
			if(ni<20&&ni>0&&nj<20&&nj>0) {
				if(!visit[ni][nj]) {
					if(map[ni][nj]==onetwo) {
						que.add(new pos(ni, nj));
						visit[ni][nj] = true;
						cnt++;
					}
				}
			}
			
			
			ni = temp.x+dx[4];
			nj = temp.y+dy[4];
			
			if(ni<20&&ni>0&&nj<20&&nj>0) {
				if(!visit[ni][nj]) {
					if(map[ni][nj]==onetwo) {
						que.add(new pos(ni, nj));
						visit[ni][nj] = true;
						cnt++;
					}
				}
			}
		}
		
		if(cnt == 5) {
			winner = onetwo;
			wx = i;
			wy = j;
			return true;
		}
		return false;
	}
	public static boolean chkS(int i, int j) {
		Queue<pos> que = new LinkedList<pos>();

		int cnt = 1;
		boolean visit[][] = new boolean[20][20];
		int onetwo = map[i][j];
		
		que.add(new pos(i, j));
		visit[i][j] = true;
		
		while(!que.isEmpty()) {
			pos temp = que.poll();
			int ni = temp.x+dx[1];
			int nj = temp.y+dy[1];
			
			if(ni<20&&ni>0&&nj<20&&nj>0) {
				if(!visit[ni][nj]) {
					if(map[ni][nj]==onetwo) {
						que.add(new pos(ni, nj));
						visit[ni][nj] = true;
						cnt++;
					}
				}
			}
			
			
			ni = temp.x+dx[6];
			nj = temp.y+dy[6];
			
			if(ni<20&&ni>0&&nj<20&&nj>0) {
				if(!visit[ni][nj]) {
					if(map[ni][nj]==onetwo) {
						que.add(new pos(ni, nj));
						visit[ni][nj] = true;
						cnt++;
					}
				}
			}
		}
		
		if(cnt == 5) {
			winner = onetwo;
			wx = i;
			wy = j;
			return true;
		}
		return false;
	}
	public static boolean chkDu(int i, int j) {
		Queue<pos> que = new LinkedList<pos>();
		

		int cnt = 1;
		boolean visit[][] = new boolean[20][20];
		int onetwo = map[i][j];
		
		que.add(new pos(i, j));
		visit[i][j] = true;
		
		while(!que.isEmpty()) {
			pos temp = que.poll();
			int ni = temp.x+dx[2];
			int nj = temp.y+dy[2];
			
			if(ni<20&&ni>0&&nj<20&&nj>0) {
				if(!visit[ni][nj]) {
					if(map[ni][nj]==onetwo) {
						que.add(new pos(ni, nj));
						visit[ni][nj] = true;
						cnt++;
					}
				}
			}
			
			
			ni = temp.x+dx[5];
			nj = temp.y+dy[5];
			
			if(ni<20&&ni>0&&nj<20&&nj>0) {
				if(!visit[ni][nj]) {
					if(map[ni][nj]==onetwo) {
						que.add(new pos(ni, nj));
						visit[ni][nj] = true;
						
						cnt++;
					}
				}
			}
		}
		
		if(cnt == 5) {
			winner = onetwo;
			wx = i+4;
			wy = j-4;
			return true;
		}
		return false;
	}
	public static boolean chkDd(int i, int j) {
		Queue<pos> que = new LinkedList<pos>();

		int cnt = 1;
		boolean visit[][] = new boolean[20][20];
		int onetwo = map[i][j];
		
		que.add(new pos(i, j));
		visit[i][j] = true;
		
		while(!que.isEmpty()) {
			pos temp = que.poll();
			int ni = temp.x+dx[0];
			int nj = temp.y+dy[0];
			
			if(ni<20&&ni>0&&nj<20&&nj>0) {
				if(!visit[ni][nj]) {
					if(map[ni][nj]==onetwo) {
						que.add(new pos(ni, nj));
						visit[ni][nj] = true;
						cnt++;
					}
				}
			}
			
			
			ni = temp.x+dx[7];
			nj = temp.y+dy[7];
			
			if(ni<20&&ni>0&&nj<20&&nj>0) {
				if(!visit[ni][nj]) {
					if(map[ni][nj]==onetwo) {
						que.add(new pos(ni, nj));
						visit[ni][nj] = true;
						cnt++;
					}
				}
			}
		}
		
		if(cnt == 5) {
			winner = onetwo;
			wx = i;
			wy = j;
			return true;
		}
		return false;
	}
	

}//class

class pos{
	int x;
	int y;
	
	public pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
} 
