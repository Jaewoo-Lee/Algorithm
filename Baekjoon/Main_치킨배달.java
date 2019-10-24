import java.util.Scanner;

public class Main_치킨배달 {
	static int[] com;
	static int idx;
	static int[][] map;
	static int[][] chi; // 치킨집
	static int n, m;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt();
		m = s.nextInt();
		
		map = new int[n][n];
		chi = new int[n*n][2];
		idx = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int temp = s.nextInt();
				map[i][j] = temp;
				if(temp == 2) {
					chi[idx][0] = i;
					chi[idx][1] = j;
					idx++;
				}
			}
		} //input end
		
		// combination
		com = new int[m];
		combi(m, 0, 0);
		
		System.out.println(answer);
	}
	public static void combi(int i, int a, int b) {
		if(i == a) {
			start();
			return;
		}
		
		for (int j = b; j < idx; j++) {
			com[a] = j;
			combi(i, a+1, j+1);
		}
	}
	static int answer = 5000;
	public static void start() {
		int stat = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]==1) {// 집이면
					int local = 101;
					for (int k = 0; k < m; k++) {
						int dis = 0;
						
						int tx = i-chi[com[k]][0];
						int ty = j-chi[com[k]][1];
						
						dis+= tx>0? tx:(-1)*tx;
						dis+= ty>0? ty:(-1)*ty;
						
						if(dis < local) local = dis;
					}
					
					stat += local;
				}
			}
		}
		
		if(answer > stat) answer = stat;
	}
}
