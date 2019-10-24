import java.util.Scanner;

public class Main_사다리조작 {
	static int n,m,h;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		n = s.nextInt();
		m = s.nextInt();
		h = s.nextInt();
		
		boolean[][] map = new boolean[h+1][n+1];
		for (int i = 0; i < m; i++) {
			int t1 = s.nextInt();
			int t2 = s.nextInt();
			
			map[t1][t2] = true;
		}
		
		int answer = 0;
		
		if(m == 0) answer = 0;
		else if(m*2 >= (n-1)*h) {
			answer = -1;
		}
		else {
			int[] pres = new int[n+1];
			for (int i = 1; i <= n; i++) {
				int a = i;
				for (int j = 1; j <= h; j++) {
					if(map[j][a]) a++;
					else if(a>1 && map[j][a-1]) a--;
				}
				pres[i] = a;
			}
			
//			System.out.println();
			
			for (int i = 1; i <= n; i++) {
				if(pres[i] == i) continue;
				else {
					int b = i;
					for (int j = i+1; j <= n; j++) {
						if(pres[j] == i) {
							b = j; break;
						
						}
					}
					
					int temp = pres[b];
					pres[b] = pres[i];
					pres[i] = temp;
					answer++;
					
					if(answer>3) {answer = -1; break;}
				}
			}
		}
		
		System.out.println(answer);
	}
}
