import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.omg.CORBA.INTERNAL;

public class Solution_4261_빠른휴대전화키패드_이재우 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String s = st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			String[] temp = new String[n];

			int cnt=0;
			for (int i = 0; i < temp.length; i++) {
				temp[i] = st.nextToken();
				if(temp[i].length() != s.length()) {
					continue;
				}
				String tmp = "";
				for (int j = 0; j < temp[i].length(); j++) {
					switch(temp[i].charAt(j)) {
					case 'a':
					case 'b':
					case 'c':
						tmp+="2";break;
					case 'd':
					case 'e':
					case 'f':
						tmp+="3";break;
					case 'g':
					case 'h':
					case 'i':
						tmp+="4";break;
					case 'j':
					case 'k':
					case 'l':
						tmp+="5";break;
					case 'm':
					case 'n':
					case 'o':
						tmp+="6";break;
					case 'p':
					case 'q':
					case 'r':
					case 's':
						tmp+="7";break;
					case 't':
					case 'u':
					case 'v':
						tmp+="8";break;
					case 'w':
					case 'x':
					case 'y':
					case 'z':
						tmp+="9";break;
					}
				}
				if(tmp.equals(s)) {
					cnt++;
				}
			}
			System.out.println("#"+test+" "+cnt);
			
		}
	}
}
