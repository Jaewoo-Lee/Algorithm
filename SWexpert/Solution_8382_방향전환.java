import java.util.Scanner;

public class Solution_8382_방향전환 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		for (int test = 1; test <= t; test++) {
			int x1 = s.nextInt();
			int y1 = s.nextInt();
			int x2 = s.nextInt();
			int y2 = s.nextInt();
			
			int tempx = x1>x2? x1-x2:x2-x1;
			int tempy = y1>y2? y1-y2:y2-y1;
			
			System.out.print("#"+test+" ");
			
			int cha=0;
			int gong=0;
			
			if(tempx == tempy) {
				System.out.println(tempx+tempy);
			}
			else if(tempx>tempy) {
				cha = tempx-tempy;
				gong = tempy;
				int r = gong*2+4*(cha/2);
				if(cha%2 == 1) r+=1;
				System.out.println(r);
			}
			else {
				cha = tempy-tempx;
				gong = tempx;
				int r = gong*2+4*(cha/2);
				if(cha%2 == 1) r+=1;
				System.out.println(r);
			}
			
			
		}
	}
}
