import java.util.Scanner;

public class Main_chon {
	static int gr[][] ;
	static boolean visit[];
	static int one;
	static int two;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		one = s.nextInt();
		two = s.nextInt();
		
		gr = new int[n+1][n+1];
		visit = new boolean[n+1];
		
		int temp = s.nextInt();
		for (int i = 0; i < temp; i++) {
			int t = s.nextInt();
			int f = s.nextInt();
			
			gr[t][f] = 1;
			gr[f][t] = 1;
		}
		
		visit[one] = true;
		for (int i = 1; i < gr.length; i++) {
			if(gr[one][i] != 0 && !visit[i]) {
				visit[i] = true;
				dfs(one, i, 1);
			}
		}
		System.out.println("-1");
		return;
		
	}

	public static void dfs(int st, int de, int j) {
		if(de == two) {
			System.out.println(j);
			System.exit(0);
		}
		for (int j2 = 1; j2 < gr.length; j2++) {
			if(gr[de][j2] == 1 && !visit[j2]) {
				visit[j2] = true;
				dfs(de, j2, j+1);
			}
			
		}
		
	}
}
