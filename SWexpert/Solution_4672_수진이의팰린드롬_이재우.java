import java.util.HashSet;
import java.util.Scanner;

public class Solution_4672_수진이의팰린드롬_이재우 {
	public static int cnt;
	public static String[] str;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int t = s.nextInt();
		for (int test = 1; test <= t; test++) {
			str = s.next().split("");
			cnt = str.length;
			
			point[] arr = new point[10];
			int index = -1;
			for (int i = 0; i < str.length; i++) {
				boolean flag = true;
				for (int j = 0; j <= index; j++) {
					if(arr[j].val.equals(str[i])) {
						arr[j].count++;
						flag = false;
						break;
					}
				}
				if(flag) {
					arr[++index] = new point(str[i], 1);
				}
			}
			
			for (int i = 0; i <= index; i++) {
				count(arr[i].count);
			}

			System.out.println("#" + test + " " + cnt);
		}
	}
	public static void count(int a) {
		int cal = a*(a-1)/2;
		cnt+=cal;
		return;
	}
}

class point{
	String val;
	int count;
	public point(String val, int count) {
		this.val = val;
		this.count = count;
	}
	
	
}
