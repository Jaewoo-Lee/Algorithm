import java.util.HashSet;
import java.util.Scanner;

public class Main_era {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		for (int i = 2; i <= n; i++) {
			hs.add(i);
		}

		int k = s.nextInt();
		int m = 2;
		int cnt=1;
		while (hs.size() > 0) {
			for (int i = 1; i * m <= n; i++) {
				if(hs.contains(i*m)) {
					if(cnt++ == k) {
						System.out.println(i*m);
						return;
					}
					hs.remove(i*m);
				}
			}
			m++;
		}
	}
}
