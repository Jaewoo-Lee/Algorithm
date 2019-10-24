import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3143_가장빠른문자열타이핑_이재우 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String a = st.nextToken();
			String b = st.nextToken();

//			System.out.println(a.indexOf(b));
			int cnt = 0;
			int loop = 0;

			while (a.length() >= b.length()&&loop<a.length()) {
				loop++;
				int pl = a.indexOf(b);
				if(pl == -1) continue;
				cnt += pl + 1;

				a = a.substring(pl+b.length());
//			System.out.println(a);
			}
			cnt+=a.length();
			
			System.out.println("#"+test+" "+cnt);

		}

	}
}
