import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1824_혁진이의프로그램검증_이재우 {
	public static char[][] map;
	public static int cnt;
	public static int x;
	public static int y;
	public static int maxx;
	public static int[] dx = { 1, -1, 0, 0 };
	public static int[] dy = { 0, 0, 1, -1 };
	public static int memory;
	public static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			map = new char[x][y];
			int gNum=0;
			for (int i = 0; i < x; i++) {
				String temp = br.readLine();
				for (int j = 0; j < y; j++) {
					map[i][j] = temp.charAt(j);
					if(temp.charAt(j) == '@') gNum++;
				}
			} // input end
			
			if(gNum==0) {
				System.out.println("#" + test + " " + "NO");
				continue;
			}

			cnt = 1;
			int cx = 0;
			int cy = 0;
			maxx = x * y*15;

			memory = 0;
			flag = false;

			move(0, 0, 0, 2);

			if (flag) {
				System.out.println("#" + test + " " + "YES");
			} else {
				System.out.println("#" + test + " " + "NO");
			}
		}

	}

	public static void move(int cx, int cy, int cnt, int m) {
		if (cnt > maxx)
			return;
		if (map[cx][cy] == '@') {
			flag = true;
			return;
		}
		switch (map[cx][cy]) {
		case '<':
			m = 3;
			cx = cx + dx[m];
			cy = cy + dy[m];

			if (cx == -1)
				cx = x - 1;
			else if (cx == x)
				cx = 0;
			if (cy == -1)
				cy = y - 1;
			else if (cy == y)
				cy = 0;

			move(cx, cy, cnt + 1, 3);
			break;
		case '>':
			m = 2;
			cx = cx + dx[m];
			cy = cy + dy[m];

			if (cx == -1)
				cx = x - 1;
			else if (cx == x)
				cx = 0;
			if (cy == -1)
				cy = y - 1;
			else if (cy == y)
				cy = 0;

			move(cx, cy, cnt + 1, 2);
			break;
		case '^':
			m = 1;
			cx = cx + dx[m];
			cy = cy + dy[m];

			if (cx == -1)
				cx = x - 1;
			else if (cx == x)
				cx = 0;
			if (cy == -1)
				cy = y - 1;
			else if (cy == y)
				cy = 0;

			move(cx, cy, cnt + 1, 1);
			break;
		case 'v':
			m = 0;
			cx = cx + dx[m];
			cy = cy + dy[m];

			if (cx == -1)
				cx = x - 1;
			else if (cx == x)
				cx = 0;
			if (cy == -1)
				cy = y - 1;
			else if (cy == y)
				cy = 0;

			move(cx, cy, cnt + 1, 0);
			break;
		case '_':
			if (memory == 0)
				m = 2;
			else
				m = 3;

			cx = cx + dx[m];
			cy = cy + dy[m];

			if (cx == -1)
				cx = x - 1;
			else if (cx == x)
				cx = 0;
			if (cy == -1)
				cy = y - 1;
			else if (cy == y)
				cy = 0;

			move(cx, cy, cnt + 1, m);
			break;
		case '|':
			if (memory == 0)
				m = 0;
			else
				m = 1;

			cx = cx + dx[m];
			cy = cy + dy[m];

			if (cx == -1)
				cx = x - 1;
			else if (cx == x)
				cx = 0;
			if (cy == -1)
				cy = y - 1;
			else if (cy == y)
				cy = 0;

			move(cx, cy, cnt + 1, m);
			break;
		case '?':
			for (int i = 0; i < 4; i++) {
				cx = cx + dx[i];
				cy = cy + dy[i];

				if (cx == -1)
					cx = x - 1;
				else if (cx == x)
					cx = 0;
				if (cy == -1)
					cy = y - 1;
				else if (cy == y)
					cy = 0;
				
				move(cx,cy,cnt+1,i);
			}
			break;
		case '.':
			cx = cx + dx[m];
			cy = cy + dy[m];

			if (cx == -1)
				cx = x - 1;
			else if (cx == x)
				cx = 0;
			if (cy == -1)
				cy = y - 1;
			else if (cy == y)
				cy = 0;
			move(cx, cy, cnt + 1, m);
			break;
		case '@':
			flag = false;
			break;
		case '+':
			memory = (memory + 1) % 16;
			cx = cx + dx[m];
			cy = cy + dy[m];

			if (cx == -1)
				cx = x - 1;
			else if (cx == x)
				cx = 0;
			if (cy == -1)
				cy = y - 1;
			else if (cy == y)
				cy = 0;

			move(cx, cy, cnt + 1, m);
			break;
		case '-':
			memory = (memory + 15) % 16;
			cx = cx + dx[m];
			cy = cy + dy[m];

			if (cx == -1)
				cx = x - 1;
			else if (cx == x)
				cx = 0;
			if (cy == -1)
				cy = y - 1;
			else if (cy == y)
				cy = 0;
			move(cx, cy, cnt + 1, m);
			break;
		default:
			memory = map[cx][cy] - '0';
			cx = cx + dx[m];
			cy = cy + dy[m];

			if (cx == -1)
				cx = x - 1;
			else if (cx == x)
				cx = 0;
			if (cy == -1)
				cy = y - 1;
			else if (cy == y)
				cy = 0;

			move(cx, cy, cnt + 1, m);
			break;

		}
	}

}
