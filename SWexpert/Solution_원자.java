import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class el{
	double x,y;
	int d,k;

	public el(double x, double y, int d, int k) {
		this.x = x;
		this.y = y;
		this.d = d;
		this.k = k;
	}
}

public class Solution_¿øÀÚ {
	static double[] dx = {0,0,-0.5, 0.5};
	static double[] dy = {0.5,-0.5,0, 0};
	
	static int n;
	static int energy;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		for (int test = 1; test <= t; test++) {
			energy = 0;
			double time = 0;
			n = s.nextInt();
			
			ArrayList<el> list = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				double x = s.nextDouble();
				double y = s.nextDouble();
				int dir = s.nextInt();
				int k = s.nextInt();
				
				list.add(new el(x,y,dir,k));
			}
			
			double t1,t2;
			int t3,t4;
			while(time <= 1001) {
				time+=0.5;
				HashSet<String> pos = new HashSet<>();
				int plus = 0;
				
				for (int i = 0; i < list.size(); i++) {
					t1 = list.get(i).x;
					t2 = list.get(i).y;
					t3 = list.get(i).d;
					
					if(t1>1000 || t2 >1000 || t1<-1000 || t2<-1000) list.remove(i);
					else {
						list.get(i).x = t1+dx[t3];
						list.get(i).y = t2+dy[t3];
						String str = "x"+list.get(i).x+"y"+list.get(i).y+"i"+i+"e"+list.get(i).k;
						
						System.out.println(str);
						
						int idx = str.indexOf("i");
						System.out.println(str.substring(0, idx));
						if(pos.contains(str.substring(0, idx))) {
							energy+=list.get(i).k;
							plus++;
							if(plus == 1) {
								plus += 1;
																
								int idx2 = str.indexOf("e");
								String ss = str.substring(idx2+1);
								System.out.println(ss);
								energy+=Integer.parseInt(ss);
							}
							System.out.println(time+" "+energy);
							list.remove(i);
						}
						else pos.add(str);
					}
				}
				
			}
			
			System.out.println("#"+test+" "+energy);
			
		}
	}
}


