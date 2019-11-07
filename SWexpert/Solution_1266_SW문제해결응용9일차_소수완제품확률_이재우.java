package Solution;
import java.util.Scanner;

public class Solution_1266_SW문제해결응용9일차_소수완제품확률_이재우 {
	static double pa;
	static double pb;
	static int com[] = new int[19];  //{1,18,153,816,3060,8568,18564,31824,43758,48620,43758,31824,18564,8568,3060,816,153,18,1};
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int i = 0; i < 10; i++) {
			int tmep = comb(i);
			com[i] = tmep;
			com[18-i] = tmep;
		}
		
		for (int test = 1; test <= t; test++) {
			int a = s.nextInt();
			int b = s.nextInt();
			
			pa = (double) a/100;
			pb = (double) b/100;
			
			double result = 1-(aNotSo()*bNotSo());
			
			System.out.printf("#%d %.6f\n",test, result);	
			
		}
	}	
	
	public static int comb(int i) {
		if(i == 0) return 1;
		else if(com[i-1] != 0){
			return com[i-1]*(18-i+1)/i;
		}
		return 0;
	}
	
	
	public static double aNotSo() {
		double pp = aSo(2)+aSo(3)+aSo(5)+aSo(7)+aSo(11)+aSo(13)+aSo(17);
		return 1-pp;
	}

	public static double bNotSo() {
		double pp = bSo(2)+bSo(3)+bSo(5)+bSo(7)+bSo(11)+bSo(13)+bSo(17);
		return 1-pp;
	}


	public static double aSo(int i) {// ppp = com[i]*pa^i*(1-pa)^(18-i)
		double ppp = com[i];
		for (int j = 0; j < i; j++) {
			ppp*=pa;
		}
		for (int j = 0; j < 18-i; j++) {
			ppp*=(1-pa);
		}
		return ppp;
	}
	
	public static double bSo(int i) {
		double ppp = com[i];
		for (int j = 0; j < i; j++) {
			ppp*=pb;
		}
		for (int j = 0; j < 18-i; j++) {
			ppp*=(1-pb);
		}
		return ppp;
	}

	
}
