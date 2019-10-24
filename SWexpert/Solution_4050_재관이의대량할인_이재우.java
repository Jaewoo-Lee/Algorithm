import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4050_재관이의대량할인_이재우 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		
		for (int test = 1; test <= t; test++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			
			int sum = 0;
			int[] list = new int[n];
			
			for (int i = 0; i < n; i++) {
				int temp = Integer.parseInt(st.nextToken());
				sum+=temp;
				list[i] = temp;
			}
			
			Arrays.sort(list);
			int minus = 0;
			for (int i = list.length-3; i >= 0; i-=3) {
				minus+=list[i];
			}
			
			System.out.println("#"+test+" "+(sum-minus));
		}
	}
}
