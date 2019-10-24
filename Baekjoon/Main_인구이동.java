import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_인구이동 {
	static int[][] map;
	static int n, m, l, r;
	static int[][] visit;
	static boolean flag; // 인구이동 일어났는지 기록하는 변수
	static v[] union; //연합국 좌표 기록
	static int unionIdx;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt();
		l = s.nextInt();
		r = s.nextInt();
		
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = s.nextInt();
			}
		}//input end
		
		answer = 0;
		que = new LinkedList();
		
		
		visit = new int[n][n];
		union = new v[n*n];
		while(true) {
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visit[i][j] = 0;
				}
			}
//			visit = new int[n][n];
			flag = false;
//			union = new v[n*n]; // 이거 때문에 시간초과 났었음 시부레
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(visit[i][j] == 0) {
						visit[i][j] = 1;
						que.add(new v(i,j));
						union[0] = new v(i,j);
						unionIdx = 1;
						bfs();
						
						if(unionIdx == 1) continue;
						
						for (int k = 0; k < unionIdx; k++) {
							map[union[k].x][union[k].y] = newPop;
							flag = true;
						}
					}
						
				}
			}
			if(!flag) break;
			answer++;
		}
		
		System.out.println(answer);
	}

	static int[] dx = {0,1,-1,0};
	static int[] dy = {1,0,0,-1};
	public static void bfs() {
		int nNum = 0;
		int pNum = 0;
		while(!que.isEmpty()) {
			int x = que.peek().x;
			int y = que.peek().y;
			
			nNum++;
			pNum += map[x][y];
			
			que.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx < 0 || nx >= n) continue;
				if(ny < 0 || ny >= n) continue;
				if(visit[nx][ny] == 1) continue;
				
				int diff = map[x][y]-map[nx][ny];
				if(diff < 0) diff*=(-1);
				if(diff >= l && diff <= r) {
					visit[nx][ny] = 1;
					v ver = new v(nx, ny);
					que.add(ver);
					union[unionIdx] = ver; 
					unionIdx++;
				}
			}
		}
		
		newPop = pNum/nNum; // 새로 분배되는 인구 수
	}

	static Queue<v> que;
	static int answer;
	static int newPop;
}

class v{
	int x;
	int y;
	public v(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
