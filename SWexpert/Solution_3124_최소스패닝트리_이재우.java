package Solution;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_3124_최소스패닝트리_이재우 {
	public static int node[];
	public static int vall[];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		for (int test = 1; test <= t; test++) {
			int jj = s.nextInt();
			int gs = s.nextInt();
			
			node = new int[jj+1];
			vall = new int[node.length];
			
			gan gr[] = new gan[gs+1];
			
			for (int i = 1; i <= gs; i++) {
				gr[i] = new gan(s.nextInt(),s.nextInt(), s.nextInt());
			}
			
			//크루스컬  : 서로소 집합 사용
			//모든 정점을 원소 1개짜리로
			for (int i = 1; i < node.length; i++) {
				makeset(i);
			}
			
			//가중치로 정렬
			Arrays.sort(gr, 1, gr.length-1);
			long sum = 0;
			
			for (int i = 1,cnt=0; i <= gs&&cnt<jj; i++) {
				gan g = gr[i];
				int pa = findset(g.a);
				int pb = findset(g.b);
				
				if(pa !=pb) {
					union(pa, pb);
//					System.out.println(g.a + "-" + g.b + " " + g.val);
					cnt++;
					sum+=g.val;
				}
			}
			System.out.println("#"+test+" "+sum);
		}//tc
	}//main
	
	public static int findset(int b) {
		if(node[b] == b) 
			return b;
		else 
			return findset(node[b]);
	}

	public static void union(int pa, int pb) {
		link(findset(pa), findset(pb));
	}

	public static void link(int i, int j) {
		if(vall[i]>vall[j]) {
			node[j] = i;
		}
		else {
			node[i] = j;
			if(vall[i]==vall[j]) {
				vall[j]++;
			}
		}
		
	}

	public static void makeset(int i) {
		node[i] = i;
	}

	public static class gan implements Comparable<gan>{
		int a,b,val;

		public gan(int a, int b, int val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}

		@Override
		public int compareTo(gan o) {
			return this.val - o.val;
		}
		
	}
}//class
