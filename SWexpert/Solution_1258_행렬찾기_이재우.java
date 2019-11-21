import java.util.ArrayList;
import java.util.Scanner;

public class Solution_1258_행렬찾기_이재우 {
	static int map[][];
	static int n;
	static boolean visit[][];
	
	public static class point{
		int x;
		int y;
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public point() {
		}
		
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			n = s.nextInt();
			map = new int[n][n];
			visit = new boolean[n][n];
			ArrayList<point> arr = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = s.nextInt();
				}
			}

			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j] != 0 && !visit[i][j]) {
						cnt++;
						int tx = 0, ty = 0;
						while(j+ty <n && map[i][j+ty] != 0) {
							ty++;
						}
						while(i+tx < n && map[i+tx][j] != 0) {
							tx++;
						}
						
						arr.add(new point(tx, ty));
						
						for (int k = i; k < i+tx; k++) {
							for (int kk = j; kk < j+ty; kk++) {
								visit[k][kk] = true;
							}
						}
					}//condition
				}//column
			}//row
			System.out.print("#"+test+" "+cnt+" ");
			
			//arr정렬하자
			for (int i = 0; i < arr.size(); i++) {
				for (int j = 0; j < arr.size()-1; j++) {
					int temp1 = (arr.get(j)).x*(arr.get(j)).y;
					int temp2 = (arr.get(j+1)).x*(arr.get(j+1)).y;
					if(temp1>temp2) {
						point temp = new point();
						temp = arr.get(j+1);
						arr.remove(j+1);
						arr.add(j, temp);
					}
					else if(temp1 == temp2 && (arr.get(j)).x > (arr.get(j+1)).x) {
						point temp = new point();
						temp = arr.get(j+1);
						arr.remove(j+1);
						arr.add(j, temp);
					}
					
				}
			}//정렬 끝
			
			for (point ff : arr) {
				System.out.print(ff.x+" "+ff.y+" ");
			}
			System.out.println();
			
		}//test case
	}//main
}//class
