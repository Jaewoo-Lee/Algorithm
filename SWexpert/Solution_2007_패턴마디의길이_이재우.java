package Solution;
import java.util.Scanner;

public class Solution_2007_패턴마디의길이_이재우 {
	static boolean flag;
	static int cnt;
	static String arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int test = 1; test <= t; test++) {

			arr = sc.next().split("");
			int it1 = 0;
			int it2 = 1;

			while (it2 < 30) {
				flag = true;
				cnt = 0;
				for (int i = it2; i < arr.length; i++) {
					if (arr[it1].equals(arr[i])) {
						it2 = i;
						break;
					}
				}
				check(it2);
				if (flag) {
					System.out.println("#"+test+" "+it2);
					break;
				}
				else {
					it2++;
				}
			}
		}//tc
	}//main
	
	public static void check(int it2) {
		for (int i = 0; i < arr.length; i+=it2) {
			for (int j = 0; j < it2; j++) {
				if(i+j >=30) return;
				if (arr[i + j].equals(arr[j+it2])) 	
					continue;
				else {
					flag = false;
					return;
				}
			}
		} 
	}
}//class
