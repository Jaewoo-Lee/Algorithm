import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_체스판_이재우 {
	public static char[][] map;
	public static int minn;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		map = new char[n][m];
		minn = 64;
		for (int i = 0; i < n; i++) {
			String temp = br.readLine().trim();
			for (int j = 0; j < m; j++) {
				map[i][j] = temp.charAt(j);
			}
		}//input end
		
		for (int i = 0; i <= n-8; i++) {
			for (int j = 0; j <= m-8; j++) {
				int cand = chk(i,j);
				
				if(minn > cand) minn = cand;
			}
		}
		
		System.out.println(minn);
	}
	public static int chk(int i, int j) {
		//black white
		int bw=0;
		for (int a = i; a < i+8; a+=2) {
			for (int b = j; b < j+8; b+=2) {
				if(map[a][b]!='B') bw++;
				if(map[a][b+1]!='W') bw++;
			}
			for (int b = j; b < j+8; b+=2) {
				if(map[a+1][b]!='W') bw++;
				if(map[a+1][b+1]!='B') bw++;
			}
		}
		
		//white black
		int wb=0;
		for (int a = i; a < i+8; a+=2) {
			for (int b = j; b < j+8; b+=2) {
				if(map[a][b]!='W') wb++;
				if(map[a][b+1]!='B') wb++;
			}
			for (int b = j; b < j+8; b+=2) {
				if(map[a+1][b]!='B') wb++;
				if(map[a+1][b+1]!='W') wb++;
			}
		}

		return bw<wb? bw:wb;
	}
}
