

import java.util.Scanner;

public class plus123 {
	static int arr[] = new int[12];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		gogo();
		
		for (int test = 1; test <= t; test++) {
			int n = s.nextInt();
			System.out.println(arr[n]);
		}
	}

	public static void gogo() {
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		for (int i = 4; i < arr.length; i++) {
			arr[i] = arr[i-3]+arr[i-2]+arr[i-1];
		}
		
	}
}
