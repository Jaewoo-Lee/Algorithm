

import java.util.Scanner;

public class stair_num {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		long arr[] = new long[101];
		int cha[] = new int[105];
		cha[0] = -1;
		cha[1] = -2;
		cha[2] = -3;
		arr[1] = 9;
		arr[2] = 17;
		for (int i = 3; i <= n; i++) {
			cha[i+1] = cha[i]+cha[i-1];
			arr[i] = (2*arr[i-1] + cha[i-3]+cha[i-2])%1000000000;
		}
		
		System.out.println(arr[n]);
	}
}
