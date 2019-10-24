import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4613_러시아국기같은깃발_이재우 {
	public static char[][] map;
	public static int n;
	public static int m;
	public static int minn;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		
		for (int test = 1; test <= t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			map = new char[n][m];
			int cnt = 0;
			minn = -1;
			for (int i = 0; i < n; i++) {
				String temp = br.readLine().trim();
				if(i==0) {
					for (int j = 0; j < m; j++) {
						map[i][j] = temp.charAt(j);
						if(map[i][j]!='W') cnt++;
					}
				}
				else if(i==n-1) {
					for (int j = 0; j < m; j++) {
						map[i][j] = temp.charAt(j);
						if(map[i][j]!='R') cnt++;
					}
				}
				else{
					for (int j = 0; j < m; j++) {
						map[i][j] = temp.charAt(j);
					}
				}
			}//input end
			
			//n=1 ~ n=n-2까지만 따지면 된다
			
			go(1,cnt,false, false);//1번 줄 차례 white 안끝
			go(1,cnt,true, false);//흰색 끝
			
			System.out.println("#"+test+" "+minn);
		}
			
	}

	public static void go(int nn,int count,boolean wend, boolean bend) {
		if(nn==n-2&&wend==false) return;
		
		
		if(!wend) {//white 안끝났으면 in
			for (int i = 0; i < m; i++) {
				if(map[nn][i]!='W') count++;
			}
			go(nn+1, count, false, false);//아직 white 안끝
			go(nn+1, count, true, false);//이제 white 끝
		}
		else if(!bend) {//white는 끝났고, blue가 안끝났으면 in
			for (int i = 0; i < m; i++) {
				if(map[nn][i]!='B') count++;
			}
			if(nn+1==n-1) {
				if(minn==-1) {
					minn = count;
					return;
				}
				minn=minn<count? minn:count;
				return;
			}
			go(nn+1, count, true, false);//blue 안끝
			go(nn+1, count, true, true);//blue 끝
		}
		else {
			for (int i = nn; i < n-1; i++) {
				for (int j = 0; j < m; j++) {
					if(map[i][j]!='R') count++;
				}
			}
			if(minn==-1) {
				minn = count;
				return;
			}
			minn=minn<count? minn:count;
			return;
		}
		
	}
}
