import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_3378_스타일리쉬들여쓰기_이재우 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		
		for (int test = 1; test <= t; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int scnt = 0;
			int jcnt = 0;
			int dcnt = 0;
			
			int r=0;//소
			int c=0;//중
			int s=0;//대
			
			boolean rb=false;
			boolean cb=false;
			boolean sb=false;
			
			HashMap<String, Integer> hm = new HashMap<>();
			
			for (int i = 1; i <= n; i++) {
				int dotcnt = 0;
				String temp = br.readLine().trim();
				int j = 0;
				while(temp.charAt(j)=='.') {
					dotcnt++;
					j++;
				}
				//r*scnt + c*jcnt + s*dcnt = dotcnt;
				
				hm.put(scnt+""+jcnt+""+dcnt, dotcnt);
				
				if(scnt==1&&jcnt==1&&dcnt==1&&dotcnt==3) {
					r=1;
					c=1;
					s=1;
					rb=true;
					cb=true;
					sb=true;
					continue;
				}
				if(scnt==1&&jcnt==1&&dcnt==0&&dotcnt==2) {
					r=1;
					c=1;
					rb=true;
					cb=true;
					continue;
				}
				if(scnt==1&&jcnt==0&&dcnt==1&&dotcnt==2) {
					r=1;
					s=1;
					rb=true;
					sb=true;
					continue;
				}
				if(scnt==0&&jcnt==1&&dcnt==1&&dotcnt==2) {
					c=1;
					s=1;
					cb=true;
					sb=true;
					continue;
				}
				if(scnt==1&&jcnt==1&&dcnt==1&&dotcnt==60) {
					r=20;
					c=20;
					s=20;
					rb=true;
					cb=true;
					sb=true;
					continue;
				}
				if(scnt==0&&jcnt==1&&dcnt==1&&dotcnt==40) {
					c=20;
					s=20;
					cb=true;
					sb=true;
					continue;
				}
				if(scnt==1&&jcnt==0&&dcnt==1&&dotcnt==40) {
					r=20;
					s=20;
					rb=true;
					sb=true;
					continue;
				}
				if(scnt==1&&jcnt==1&&dcnt==0&&dotcnt==40) {
					r=20;
					c=20;
					rb=true;
					cb=true;
					continue;
				}
				
				if(scnt!=0&&jcnt==0&&dcnt==0) {
					r = dotcnt/scnt;
					rb=true;
				}
				if(jcnt!=0&&scnt==0&&dcnt==0) {
					c = dotcnt/jcnt;
					cb=true;
				}
				if(dcnt!=0&&scnt==0&&jcnt==0) {
					s = dotcnt/dcnt;
					sb=true;
				}
				
				if(rb&&cb&&dcnt!=0) {
					s = (dotcnt-r*scnt-c*jcnt)/dcnt;
					sb=true;
				}
				if(sb&&cb&&scnt!=0) {
					r = (dotcnt-c*jcnt-s*dcnt)/scnt;
					rb=true;
				}
				if(rb&&sb&&jcnt!=0) {
					c = (dotcnt-r*scnt-s*dcnt)/jcnt;
					cb=true;
				}
				
				for (; j < temp.length(); j++) {
					if(temp.charAt(j)=='(') scnt++;
					else if(temp.charAt(j)=='{')  jcnt++;
					else if(temp.charAt(j)=='[') dcnt++;
					else if(temp.charAt(j)==')') scnt--;
					else if(temp.charAt(j)=='}') jcnt--;
					else if(temp.charAt(j)==']') dcnt--;
				}
			}//깜쁠리뜨
			
//			System.out.println(r+" "+c+" "+s);
			
			scnt=0;
			jcnt=0;
			dcnt=0;
			
			System.out.print("#"+test+" ");
			for (int i = 0; i < m; i++) {
				boolean ff = true;
				String temp = br.readLine().trim();
				if (!hm.isEmpty()){
					if(hm.containsKey(scnt+""+jcnt+""+dcnt)) {
						System.out.print(hm.get(scnt+""+jcnt+""+dcnt)+" ");
						ff=false;
					}
				}
				if(ff) {
					if(!rb&&scnt!=0) {
						System.out.print("-1 ");
						ff=false;
					}
					else if(!cb&&jcnt!=0) {
						System.out.print("-1 ");
						ff=false;
					}
					else if(!sb&&dcnt!=0) {
						System.out.print("-1 ");
						ff=false;
					}
				}
				if(ff)
					System.out.print(r*scnt + c*jcnt + s*dcnt+" ");
				
				for (int j = 0; j < temp.length(); j++) {
					if(temp.charAt(j)=='(') scnt++;
					else if(temp.charAt(j)=='{')  jcnt++;
					else if(temp.charAt(j)=='[') dcnt++;
					else if(temp.charAt(j)==')') scnt--;
					else if(temp.charAt(j)=='}') jcnt--;
					else if(temp.charAt(j)==']') dcnt--;
				}
			}
			System.out.println();
		}
	}
}
