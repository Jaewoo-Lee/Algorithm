import java.util.Scanner;

public class Solution_5643_Professional_키순서_이재우 {
	static int[][] a;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			int n = s.nextInt();
			int m = s.nextInt();
			
			a = new int[n+1][n+1];
			
			for (int i = 1; i < a.length; i++) {
				a[i][0] = -1;//큰 친구 목록을 [0]에 저장
			}
			
			for (int i = 0; i < m; i++) {//비교회수만큼 반복
				int small = s.nextInt();
				int tall = s.nextInt();
				
				a[small][tall] = 1;
			}//input 끝
			
			
			for (int i = 1; i < a.length; i++) {
				up(i); //나보다 큰 애들을 순회
			}
			
			for (int i = 1; i < a.length; i++) {
				for (int j = 1; j < a.length; j++) {
					a[0][i] += a[j][i];
				}
			}
			
			int cnt=0;
			for (int i = 0; i < a.length; i++) {
				if(a[0][i] + a[i][0] == n-1) {
					cnt++;
				}
			}
			
			System.out.println("#"+test+" "+cnt);

		}//tc
	}//main
	public static void up(int v) {
		if(a[v][0] != -1){
			return;
		}
		
		for (int i = 1; i < a.length; i++) {
			if(a[v][i]==1) {
				up(i);
				for (int j = 0; j < a.length; j++) {
					a[v][i] = a[i][v] | a[v][i];
				}
			}
		}
		int sum = 0;// v정점보다 큰 친구들의 숫자를 셈
		for (int i = 0; i < a.length; i++) {
			sum+=a[v][i];
		}
		a[v][0] = sum; //인접행렬의 0번째 칸을 사용
		
	}
}//class