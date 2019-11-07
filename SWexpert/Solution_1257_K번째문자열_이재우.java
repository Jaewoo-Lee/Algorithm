package Solution;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution_1257_K번째문자열_이재우 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t= s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			int k = s.nextInt();
			String str = s.next();
//			str+=" ";
			
			HashSet<String> hs = new HashSet<>();
			int cnt = 0;
			for (int i = 0; i <= str.length(); i++) {
				for (int j = i+1; j <= str.length(); j++) {
					hs.add(str.substring(i,j));
				}
			}
			Object[] arr = hs.toArray();
//			System.out.println("#"+test+" "+arr[k-1]);
			Arrays.sort(arr);
			System.out.println("#"+test+" "+arr[k-1]);
			
			
		}
	}
}
