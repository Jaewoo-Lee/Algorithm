import java.util.Scanner;

public class Main_sack {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int map[][] = new int[101][101];
		
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int x = s.nextInt();
			int y = s.nextInt();
			
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					if(map[x+j][y+k] == 0) {
						cnt++;
						map[x+j][y+k] = 1;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}
