import java.util.HashSet;
import java.util.Scanner;

public class Solution_4366_정식이의은행업무_이재우 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		s.nextLine();
		for (int test = 1; test <= t; test++) {
			String ejs = s.nextLine();
			String sjs = s.nextLine();
			
			eeee(ejs);
			ssss(sjs);
			
			System.out.println("#"+test+" "+result);
		}
	}

	public static void ssss(String sjs) {
		long temp = 0;
		long jari = 1;
		for (int i = sjs.length()-1; i >=0; i--) {
			temp+= (sjs.charAt(i)-'0')*jari;
			jari*=3;
		}
		
		jari = 1;
		for (int i = sjs.length()-1; i >=0; i--) {
			if(sjs.charAt(i)=='0') {
				if(ee.contains(temp+(jari*1))){
					result = temp+(jari*1);
					return;
				}
				if(ee.contains(temp+(jari*2))) {
					result = temp+(jari*2);
					return;
				}
			}
			else if(sjs.charAt(i)=='1') {
				if(ee.contains(temp+(jari*1))){
					result = temp+(jari*1);
					return;
				}
				if(ee.contains(temp-(jari*1))) {
					result = temp-(jari*1);
					return;
				}
			}
			else {
				if(ee.contains(temp-(jari*1))){
					result = temp-(jari*1);
					return;
				}
				if(ee.contains(temp-(jari*2))) {
					result = temp-(jari*2);
					return;
				}
			}
			jari*=3;
		}
	}

	public static long result;
	public static HashSet<Long> ee;
	public static void eeee(String ejs) {
		ee = new HashSet<Long>();
		
		long temp = 0;
		for (int i = 0; i < ejs.length(); i++) {
			temp+= (ejs.charAt(i)-'0')*(1<<(ejs.length()-1-i));
		}
		
		for (int i = 0; i < ejs.length(); i++) {
			if(ejs.charAt(i)=='1') {
				ee.add(temp-(1<<(ejs.length()-1-i)));
			}
			else {
				ee.add(temp+(1<<(ejs.length()-1-i)));
			}
		}
			
	}
}
