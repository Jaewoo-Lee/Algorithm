import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_5672_올해의조련사_이재우 {
	public static String[] line;
	public static String result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		
		for (int test = 1; test <= t; test++) {
			int n = Integer.parseInt(br.readLine().trim());
			
			line = new String[n];
			result = "";
			for (int i = 0; i < line.length; i++) {
				line[i] = br.readLine().trim();
				result+=line[i];
			}
			
			gogo("",0,line.length-1);
			System.out.println("#"+test+" "+result);
		}
	}

	public static void gogo(String str, int i1, int i2) {
		while(i1<=i2) {
			if(line[i1].charAt(0)<line[i2].charAt(0)) {
				str+=line[i1];
				i1++;
			}
			else if(line[i1].charAt(0)>line[i2].charAt(0)) {
				str+=line[i2];
				i2--;
			}
			else {
				int ttt = 0;
				while((i1+ttt)<=(i2-ttt)&& line[i1+ttt].equals(line[i2-ttt])) {
					ttt++;
				}
				if((i1+ttt)>(i2-ttt)) ttt--;
				if(line[i1+ttt].charAt(0)<line[i2-ttt].charAt(0)) {
					str+=line[i1];
					i1++;
				}
				else {
					str+=line[i2];
					i2--;
				}
			}
		}
		
		if(str.length()==line.length)
			bigyo(str);
	}

	public static void bigyo(String str) {
		int iter=0;
		if (str.equals(result)) {
			return;
		}
		while(iter<=str.length()-1) {
			if(str.charAt(iter)<result.charAt(iter)) {
				result = str;
//				System.out.println(result);
				break;
			}
			else if(str.charAt(iter)>result.charAt(iter)) {
//				System.out.println(result);
				break;
			}
			iter++;
		}
	}
}
