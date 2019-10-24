import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_2283_RGB마을_이재우 {
    public static int n;
    public static int maxx;
    public static int[][] house;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
         
        house = new int[n+1][3];
         
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
             
            house[i][0] = Integer.parseInt(st.nextToken());//R
            house[i][1] = Integer.parseInt(st.nextToken());//G
            house[i][2] = Integer.parseInt(st.nextToken());//B
        }//input end
        
        dp();
        int result = Math.min(Math.min(memo[n][0], memo[n][1]),memo[n][2]);
        System.out.println(result);
         
    }
    public static int memo[][];
	public static void dp() {
		memo=new int[n+1][3];
		memo[1][0] = house[1][0];
		memo[1][1] = house[1][1];
		memo[1][2] = house[1][2];
		
		for (int i = 2; i < memo.length; i++) {
			memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2])+house[i][0];
			memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2])+house[i][1];
			memo[i][2] = Math.min(memo[i-1][1], memo[i-1][0])+house[i][2];
		}
	}
 
    
         
}