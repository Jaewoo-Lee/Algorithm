import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_2577_회전초밥_이재우 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
		int n = Integer.parseInt(st.nextToken());//접시 수
		int d = Integer.parseInt(st.nextToken());//초밥 가짓수
		int k = Integer.parseInt(st.nextToken());//연속 초밥 수
		int c = Integer.parseInt(st.nextToken());//쿠폰번호
		
		int[] rail = new int[n];
		int[] sushi = new int[d+1];
		int[] set = new int[k];
		int idx = 0;
		int maxx = -1;
		int cur = 0;
		
		for (int i = 0; i < n; i++) {
			rail[i] = Integer.parseInt(br.readLine().trim());
		}//input end
		
		
		for (int i = 0; i < n+k; i++) {
			sushi[set[idx]]--; //window에서 사라진거 뺴고
			if(set[idx]>0&&sushi[set[idx]]<=0) {
				if(set[idx]==c) cur++;
				cur--;
			}
			set[idx] = rail[i%n];
			sushi[rail[i%n]]++;
			if(set[idx]>0&&sushi[set[idx]]!=0) {
				if(set[idx]==c||sushi[set[idx]]>1) cur--;
				cur++;
			}
			idx = (idx+1)%k;
			
			
			if(maxx < cur+1) maxx = cur+1;
		}
		
		System.out.println(maxx);
	}
}
