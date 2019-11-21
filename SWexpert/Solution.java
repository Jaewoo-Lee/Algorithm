import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			char[][] map = new char[x][y];
			int gNum = 0;
			for (int i = 0; i < x; i++) {
				String temp = br.readLine();
				for (int j = 0; j < y; j++) {
					map[i][j] = temp.charAt(j);
					if(temp.charAt(j) == '@') gNum++;
				}
			}//input end
			
			if(gNum==0) {
				System.out.println("#" + test + " " + "NO");
				continue;
			}
			
			
			int cnt=1;
			int cx=0;
			int cy=0;
			int maxx = x*y*15;
			
			int dx[] = {1,-1,0,0};
			int dy[] = {0,0,1,-1};
			int rand = 1;
			int m = 2;
			int memory = 0;
			boolean flag = true;
			while(cnt<=maxx && flag) {
				switch(map[cx][cy]) {
				case '<':
					m=3;
					break;
				case '>':
					m=2;
					break;
				case '^':
					m=1;
					break;
				case 'v':
					m=0;
					break;
				case '_':
					if(memory==0) m=2;
					else m=3;
					break;
				case '|':
					if(memory==0) m=0;
					else m=1;
					break;
				case '?':
					for(int h=0;h<4;h++){
                        int nx=cx+dx[h];
                        int ny=cy+dy[h];
                        if(nx<0||ny<0||nx>=x||ny>=y) continue;
                        if(map[nx][ny]=='@'){
                            flag = false;
                        }
                    }
					break;
                    
				case '.':
					break;
				case '@':
					flag = false;
					break;
				case '+':
					memory=(memory+1)%16;
					break;
				case '-':
					memory=(memory+15)%16;
					break;
				default :
					memory = map[cx][cy]-'0';
					break;
				}
				
				cx = cx+dx[m];
				cy = cy+dy[m];
				
				if(cx==-1) cx=x-1;
				else if(cx == x) cx=0;
				if(cy==-1) cy=y-1;
				else if(cy == y) cy=0;
				
				cnt++;
			}
			
			if(!flag) {
				System.out.println("#"+test+" "+"YES");
			}
			else {
				System.out.println("#"+test+" "+"NO");
			}
		}
	}
}
