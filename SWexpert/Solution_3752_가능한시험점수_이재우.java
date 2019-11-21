import java.util.HashSet;
import java.util.Scanner;

public class Solution_3752_가능한시험점수_이재우 {
	static HashSet<Integer> hs; 
	static int sum;
	static int n;
	static int score[];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		for (int test = 1; test <= t; test++) {
			n = s.nextInt();
			hs = new HashSet<>();
			hs.add(0);
			for (int i = 0; i < n; i++) {
				int temp= s.nextInt();
				HashSet<Integer> clone = (HashSet<Integer>) hs.clone();
				for(Integer n:clone) {
					hs.add(n+temp);
				}
			}
			
			System.out.println("#"+test+" "+hs.size());
		}
	}
}
