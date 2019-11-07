package Solution;
import java.util.Scanner;

public class Solution_1244_SW문제해결응용2일차_최대상금_이재우 {
	static int result = -1;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();

		for (int test = 1; test <= t; test++) {
			String arr[] = s.next().split("");
			int arrn[] = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				arrn[i] = (int) Integer.parseInt(arr[i]);
			}
			int ch = s.nextInt();
			//if(ch == 10) ch = 4;
			result = -1;
			start(arrn, ch);
			System.out.printf("#%d %d\n", test, result);
		} // tc
	}// main

	public static void start(int ar[], int chn) {
		if (chn == 0) {
			int fin = 0;
			for (int i = 0; i < ar.length; i++) {
				fin = fin * 10 + ar[i];
			}
			result = result < fin ? fin : result;
		} else {
			for (int i = 0; i < ar.length; i++) {
				for (int j = i + 1; j < ar.length; j++) {
					
					if(ar[i] > ar[j])
						continue;
					
					Boolean flag = true;
					int temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
					if ((chn - 1) % 2 == 0) {
						for (int k = 0; k < ar.length - 1; k++) {
							if (ar[k] < ar[k + 1]) {
								flag = false;
								break;
							}
						}
						if(flag) chn=1;
					}

					start(ar, chn - 1);
					temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
		}
	}
}// class
