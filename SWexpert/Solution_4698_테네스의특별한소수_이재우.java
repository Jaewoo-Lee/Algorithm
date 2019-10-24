import java.util.Scanner;

public class Solution_4698_테네스의특별한소수_이재우 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		int pr[] = new int[1000001];

		pr[0] = 1;
		pr[1] = 1;
		for (int j = 2; j * j <= 1000000; j++) {
			for (int k = 2; j * k <= 1000000; k++) {
				
				if (pr[j * k] == 0) {
					pr[j*k] = 1;
				}
			}
		}

		for (int test = 1; test <= t; test++) {
			int cnt = 0;

			int d = s.nextInt();
			int a = s.nextInt();
			int b = s.nextInt();


			for (int i = a; i <= b; i++) {
				if (pr[i] == 0 && (i + "").contains(d + ""))
					cnt++;
			}

			System.out.println("#" + test + " " + cnt);
		}
	}

	public static boolean prime(int i) {
		if (i < 2)
			return false;

		return true;
	}
}
