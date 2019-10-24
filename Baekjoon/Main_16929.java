import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16929 {
	public static String[][] map;
	public static int[][] visit;
	public static int n, m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new String[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().trim().split("");
		}

		visit = new int[n][m];
		flag = false;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				
				sx = i;
				sy = j;
				visit[i][j]+=10;
				start(i, j);
				visit[i][j]-=10;
				
				
				if (flag)
					break;
			}
			if (flag)
				break;
		}

		System.out.println(flag ? "Yes" : "No");
	}

	static int sx, sy;
	static boolean flag;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void start(int i, int j) {
		if (visit[i][j]==10&&i == sx && j == sy) {
			flag = true;
			return;
			
		}
		for (int k = 0; k < 4; k++) {
			int nx = dx[k] + i;
			int ny = dy[k] + j;

			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;
			
			if (visit[nx][ny]==10) start(nx,ny);
			if (visit[nx][ny]==1) {
				continue;
			}

			if (map[i][j].equals(map[nx][ny])) {
				visit[nx][ny]++;
				start(nx, ny);
				visit[nx][ny]--;
			}
			else continue;
		}
	}
}
