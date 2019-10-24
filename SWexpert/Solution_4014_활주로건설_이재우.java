import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설_이재우 {
	public static int[][] map;
	public static int[] gchk;
	public static int[] schk;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
	
		for (int test = 1; test <= t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			map = new int[n][n];
			gchk = new int[n];
			schk = new int[n];
			
			for (int i = 0; i < n; i++) {
				st= new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
			
			
		}
	}
}
