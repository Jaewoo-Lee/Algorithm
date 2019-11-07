package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1494_사랑의카운슬러_이재우 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int t = Integer.parseInt(str);
		
		for (int test = 1; test <= t; test++) {
			str = br.readLine();
			int n = Integer.parseInt(str);
			
			long arr[][] = new long[n/2][2];
			
			for (int i = 0; i < n; i+=2) {
				str = br.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				long x1 = Integer.parseInt(st.nextToken());
				long y1 = Integer.parseInt(st.nextToken());
				
				str = br.readLine();
				st = new StringTokenizer(str, " ");
				long x2 = Integer.parseInt(st.nextToken());
				long y2 = Integer.parseInt(st.nextToken());
				
				arr[i/2][0] = x1-x2;
				arr[i/2][1] = y1-y2;
			}//arr완성
			
			long sx = 0;
			long sy = 0;
			
			for (int i = 0; i < arr.length; i++) {
				sx+=arr[i][0];
				sy+=arr[i][1];
			}
			
			long result = sx*sx;
			result+=(sy*sy);
//			result += y3*y3;
			System.out.println("#"+test+" "+result);
			
		}
	}
}
