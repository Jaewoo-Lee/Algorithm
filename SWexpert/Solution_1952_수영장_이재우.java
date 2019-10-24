import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장_이재우 {
	public static int minn;
	public static int cost;
	public static int day,mon,thr,year;
	public static int[] plan;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		
		for (int test = 1; test <= t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			day = Integer.parseInt(st.nextToken());
			mon = Integer.parseInt(st.nextToken());
			thr = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine().trim(), " ");
			plan = new int[12];
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			//input end
			
			minn = 1000000;
			cal(0,0);
			
			System.out.println("#"+test+" "+minn);
		}
	}
	public static void cal(int month, int money) {
		if(month > 11) {
			if(minn > money) minn = money;
			return;
		}
		
		cal(month+1,money+mon);
		cal(month+3,money+thr);
		cal(month+1,money+plan[month]*day);
		cal(month+12,money+year);
		
		
	}
}
