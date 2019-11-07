package Solution;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_6719_성수의프로그래밍강좌시청_이재우 {
	public static void main(String[] args) {
		int t;
		Scanner s = new Scanner(System.in);
		
		t = s.nextInt();
		
		for (int test = 0; test < t; test++) {
			int n, k;
			n = s.nextInt();
			k = s.nextInt();
			
			ArrayList<Integer> arr = new ArrayList<>(); //stack
			
			for (int i = 0; i < n; i++) {
				arr.add(s.nextInt());				
			}
			
			arr.sort(null);
			
			float sum = 0;
			float now = 0;
			
			for (int i = 0; i < k; i++) {
				sum=arr.get(arr.size()-k+i);
				now = (float)(sum+now)/2;
			}
			
			float result = now;
			
			System.out.printf("#%d %.6f\n", test+1, result);
		}
	}
}
