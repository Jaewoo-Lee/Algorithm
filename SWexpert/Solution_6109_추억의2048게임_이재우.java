import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6109_추억의2048게임_이재우 {
	public static int[][] map;
	public static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		
		for (int test = 1; test <= t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			n = Integer.parseInt(st.nextToken());
			String di = st.nextToken();
			
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}//input end
			
			if(di.equals("up"))
				up();
			else if(di.equals("down")) 
				dn();
			else if(di.equals("right")) 
				rr();
			else if(di.equals("left")) 
				ll();
				
			//출력	
			System.out.println("#"+test);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}
	}

	public static void rr() {
		for (int i = 0; i < n; i++) {
			//먼저 공백 없애기
			int[] ttemp = map[i].clone();
			int iiter = n-1;
			for (int j = n-1; j >= 0; j--) {
				if(ttemp[j]==0) continue;
				map[i][iiter] = ttemp[j];
				iiter--;
			}
			for (int j = iiter; j >= 0; j--) {
				map[i][j] = 0;
			}
			
			//이제 합치기
			int idx = 0;
			int[] temp = new int[n];
			boolean[] visit = new boolean[n];
			for (int j = n-1; j > 0;) {
				if(map[i][j]==map[i][j-1]) {
					visit[j] = true;
					visit[j-1] = true;
					temp[j]=0;
					temp[j-1]=2*map[i][j];
					j-=2;
				}
				else {
					if(!visit[j]) {
						visit[j] = true;
						temp[j]=map[i][j];
					}
					j--;
				}
			}
			if(!visit[0]) {
				temp[0] = map[i][0];
			}//계산 끝
			
			//이제 땡기기
			int iter = n-1;
			
			for (int j = n-1; j >= 0; j--) {
				if(temp[j]==0) continue;
				map[i][iter]=temp[j];
				iter--;
			}
			for (int k = iter; k >= 0; k--) {
				map[i][k] = 0;
			}
		
		}
		
	}

	public static void ll() {
		for (int i = 0; i < n; i++) {
			//먼저 공백 없애기
			int[] ttemp = map[i].clone();
			int iiter = 0;
			for (int j = 0; j < n; j++) {
				if(ttemp[j]==0) continue;
				map[i][iiter] = ttemp[j];
				iiter++;
			}
			for (int j = iiter; j < n; j++) {
				map[i][j] = 0;
			}
			
			// 합
			int idx = 0;
			int[] temp = new int[n];
			boolean[] visit = new boolean[n];
			for (int j = 0; j < n-1;) {
				if(map[i][j]==map[i][j+1]) {
					visit[j] = true;
					visit[j+1] = true;
					temp[j]=0;
					temp[j+1] = 2*map[i][j];
					j+=2;
				}
				else {
					if(!visit[j]) {
						visit[j] = true;
						temp[j]=map[i][j];
					}
					j++;
				}
			}
			
			if(!visit[n-1]) {
				temp[n-1] = map[i][n-1];
			}//계산 끝
			
			//이제 땡기기
			int iter = 0;
			
			for (int j = 0; j < n; j++) {
				if(temp[j]==0) continue;
				map[i][iter]=temp[j];
				iter++;
			}
			for (int k = iter; k < n; k++) {
				map[i][k] = 0;
			}
		}
	}

	public static void dn() {
		for (int j = 0; j < n; j++) {
			//먼저 공백 없애기
			int[] ttemp = new int[n];
			for (int i = 0; i < ttemp.length; i++) {
				ttemp[i] = map[i][j];
			}
			int iiter = 0;
			for (int i = 0; i < n; i++) {
				if(ttemp[i]==0) continue;
				map[iiter][j] = ttemp[i];
				iiter++;
			}
			for (int i = iiter; i < n; i++) {
				map[i][j] = 0;
			}
			
			//이제 합치기
			int idx = 0;
			int[] temp = new int[n];
			boolean[] visit = new boolean[n];
			for (int i = n-1; i > 0;) {
				if(map[i][j]==map[i-1][j]) {
					visit[i] = true;
					visit[i-1] = true;
					temp[i]=0;
					temp[i-1]=2*map[i][j];
					i-=2;
				}
				else {
					if(!visit[i]) {
						visit[i] = true;
						temp[i]=map[i][j];
					}
					i--;
				}
			}
			if(!visit[0]) {
				temp[0] = map[0][j];
			}//계산 끝
			
			//이제 땡기기
			int iter = n-1;
			
			for (int i = n-1; i >= 0; i--) {
				if(temp[i]==0) continue;
				map[iter][j]=temp[i];
				iter--;
			}
			for (int k = iter; k >= 0; k--) {
				map[k][j] = 0;
			}
		
		}
	}

	public static void up() {
		for (int j = 0; j < n; j++) {
			//먼저 공백 없애기
			int[] ttemp = new int[n];
			for (int i = 0; i < ttemp.length; i++) {
				ttemp[i] = map[i][j];
			}
			int iiter = 0;
			for (int i = 0; i < n; i++) {
				if(ttemp[i]==0) continue;
				map[iiter][j] = ttemp[i];
				iiter++;
			}
			for (int i = iiter; i < n; i++) {
				map[i][j] = 0;
			}
			
			//이제 합치기
			int idx = 0;
			int[] temp = new int[n];
			boolean[] visit = new boolean[n];
			for (int i = 0; i < n-1;) {
				if(map[i][j]==map[i+1][j]) {
					visit[i] = true;
					visit[i+1] = true;
					temp[i]=0;
					temp[i+1]=2*map[i][j];
					i+=2;
				}
				else {
					if(!visit[i]) {
						visit[i] = true;
						temp[i]=map[i][j];
					}
					i++;
				}
			}
			if(!visit[n-1]) {
				temp[n-1] = map[n-1][j];
			}//계산 끝
			
			//이제 땡기기
			int iter = 0;
			
			for (int i = 0; i < n; i++) {
				if(temp[i]==0) continue;
				map[iter][j]=temp[i];
				iter++;
			}
			for (int k = iter; k < n; k++) {
				map[k][j] = 0;
			}
		}
	}
}
