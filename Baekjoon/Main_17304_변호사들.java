import java.util.HashSet;
import java.util.Scanner;

public class Main_17304_변호사들 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		
		if(n>m) {
			System.out.println("NO");
			return;
		} //사람보다 신뢰쌍이 적으면 안된다 (비둘기집의 원리의 대우 <-맞나...?)
		
		int[] temp1 = new int[n+1];
		int[] temp2 = new int[n+1];
		int tt1 = n;
		int tt2 = n;
		
		HashSet<String> set = new HashSet<String>();
		
		for (int i = 1; i <= m; i++) {
			int t1 = s.nextInt();
			int t2 = s.nextInt();
			
			if(temp1[t1] == 0) {
				temp1[t1] = 1;
				tt1--;
			}
			if(temp2[t2] == 0) {
				temp2[t2] = 1;
				tt2--;
			}
			if(!set.contains(t2+""+t1))
				set.add(t1+""+t2);
			else {
				System.out.println("NO");
				return;
			}
		}
		if(tt1!=0 || tt2!=0) {
			System.out.println("NO");
			return;
		}
		
		
		
		System.out.println("YES");
		return;
	}
}
