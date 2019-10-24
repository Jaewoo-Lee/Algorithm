import java.util.Scanner;

public class Solution_4340_파이프연결_이재우 {
	public static int[][] map;
	public static boolean[][] visit;
	public static int cnt;
	public static int n;
	public static int minn;

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();

		for (int test = 1; test <= t; test++) {
			n = s.nextInt();
			map = new int[n][n];
			s.nextLine();
			for (int i = 0; i < map.length; i++) {
				String temp = s.nextLine();
				for (int j = 0; j < map.length; j++) {
					map[i][j] = temp.charAt(j*2)-'0';
				}
			} // input end

			minn = 10000;
			visit = new boolean[n][n];
			visit[0][0] = true;
			start(0, 0, 1, 1);

			System.out.println("#" + test + " " + minn);

		}
	}

	public static int dx[] = { 0, 0, 1, -1, 0 };
	public static int dy[] = { 0, 1, 0, 0, -1 }; // 우 하 상 좌

	public static void start(int i, int j, int flow, int cnt) {
		if (i == n - 1 && j == n - 1) {
			if (map[n - 1][n - 1] == 1 && flow == 1) {
				if (cnt < minn)
					minn = cnt;
			} else if (map[n - 1][n - 1] == 6 && flow == 2) {
				if (cnt < minn)
					minn = cnt;
			}
			return;
		}

		if (map[i][j] == 1 || map[i][j] == 2) {
			int ni = i + dx[flow];
			int nj = j + dy[flow];

			if (ni < 0 || ni >= n || nj < 0 || nj >= n)
				return;
			if (!visit[ni][nj] && map[ni][nj] != 0) {

				visit[ni][nj] = true;
				start(ni, nj, flow, cnt + 1);
				visit[ni][nj] = false;
			}
		} 
		else if (flow == 1 || flow == 4) {
			if (i + 1 < n) {
				if (!visit[i + 1][j] && map[i+1][j] != 0) {
					visit[i + 1][j] = true;
					start(i + 1, j, 2, cnt + 1);// 하
					visit[i + 1][j] = false;
				}
			}
			if (i - 1 >= 0) {
				if (!visit[i - 1][j] && map[i-1][j] != 0) {
					visit[i - 1][j] = true;
					start(i - 1, j, 3, cnt + 1);// 상
					visit[i - 1][j] = false;
				}
			}
		} else {
			if (j + 1 < n) {
				if (!visit[i][j + 1] && map[i][j+1] != 0) {
					visit[i][j + 1] = true;
					start(i, j + 1, 1, cnt + 1);// 우
					visit[i][j + 1] = false;
				}
			}
			if (j - 1 >= 0) {
				if (!visit[i][j - 1] && map[i][j-1] != 0) {
					visit[i][j - 1] = true;
					start(i, j - 1, 4, cnt + 1);// 좌
					visit[i][j - 1] = false;
				}
			}
		}
	}
}
