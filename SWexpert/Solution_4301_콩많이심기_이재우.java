import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4301_콩많이심기_이재우 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		
		for (int test = 1; test <= t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			boolean[][] map = new boolean[n][m];
			boolean[] dx = {true, true,false,false};
			
			for (int i = 0; i < n; i++) {
				if(i%4==0||i%4==1) {
					int a = 0;
					for (int j = 0; j < m; j++) {
						map[i][j] = dx[(a++)%4];
					}
				}
				else {
					int a = 2;
					for (int j = 0; j < m; j++) {
						map[i][j] = dx[(a++)%4];
					}
				}
			}
			int cnt=0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(map[i][j]) cnt++;
				}
			}
			
			System.out.println("#"+test+" "+cnt);
		}
	}
}
