package Solution;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1251_SW문제해결응용4일차_하나로_이재우 {
	public static int[] p;	// 부모를 저장할 배열
	public static int[] rank;	// 깊이
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for (int test = 1; test <= t; test++) {
			int n = s.nextInt(); //정점의 개수
			
			double arr[][] = new double[n][2];
			for (int i = 0; i < n; i++) {
				arr[i][0] = s.nextInt();
			}
			for(int i = 0; i<n;i++) {
				arr[i][1] = s.nextInt();
			}//좌표 받았고
			
			double se = s.nextDouble();//세율
			
			double graph[][] = new double[n][n];
			for (int i = 0; i < graph.length; i++) {
				for (int j = 0; j < graph[i].length; j++) {
					if(i==j || graph[i][j] != 0) continue;
					else {
						double nop = arr[i][0]-arr[j][0];
						double mit = arr[i][1]-arr[j][1];
						double temp = nop*nop + (mit*mit);
						graph[i][j] = temp;
						graph[j][i] = temp;
					}
				}
			}//간선 단가 계산
			
			
			int E = n*(n-1)/2;
			int nn=0;
			Edge[] G = new Edge[E];	// 간선의 정보를 저장할 배열 = 간선배열, E= 간선 개수
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					if(i==j) new Edge(i, j, 0);
					G[nn++] = new Edge(i, j, graph[i][j]);
				}
			}
			
			p = new int[n];	// 부모를 저장할 배열
			rank = new int[p.length];	// 깊이
			
			for (int i = 0; i < p.length; i++) {
				makeSet(i);
			}
			
			// 가중치를 기준으로 간선배열을 정렬한다
			Arrays.sort(G);	// compareTo 구현해야한다
			
			long sum=0;
			// 반복(간선이 N-1개 선택할 때까지)
			for (int i = 0, cnt = 0; i < E && cnt < n; i++) {
				// 가중치가 낮은 간선을 선택한다, 사이클이 발생하지 않는 정점
				Edge e = G[i];
				int pa = findSet(e.a);
				int pb = findSet(e.b);
				if(pa != pb) {	// 다른 집합일 때 (사이클이 발생하지 않음) 만 합치기
					union(pa, pb);	// 두 정점의 집합을 하나의 집합으로 합침
					sum+=e.val;
					cnt++;
				}
			}
			
			System.out.printf("#%d %.0f\n",test,(sum*se));
			
		}//tc
	}//main
	public static class Edge implements Comparable<Edge> {
		int a;	// 정점1
		int b;	// 정점2
		double val;	// 가중치
		public Edge(int a, int b, double val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}
		
		@Override
		public int compareTo(Edge e) {	// 간선의 가중치를 기준으로 정렬한다
			return Double.compare(this.val, e.val);
		}
	}	// end of class Edge
	
	/** 멤버 x를 포함하는 새로운 집합을 생성 */
	public static void makeSet(int x) {
		p[x] = x;	// 부모를 저장, 자기자신의 index or -1
	}
	
	/** 멤버 x, y를 포함하는 두 집합을 통합(서로 다른 집합일 때만 합쳐야함) */
	public static void union(int x, int y) {
		link(findSet(x), findSet(y));
	}
	
	/** 멤버 x를 포함하는 집합을 찾아서 대표자를 리턴 */
	public static int findSet(int x) {
		if (p[x] == x) {
			return x;
		} else {
			p[x] = findSet(p[x]);	// path Compression 대표자를 찾으면 저장
			return p[x];
		}
	}
	
	/** x대표자와 y대표자의 집합을 합침 */
	public static void link(int px, int py) {
		if(rank[px] > rank[py]) {
			p[py] = px;	// 작은 쪽을 큰쪽에 붙인다
		} else {
			p[px] = py;
			if(rank[px] == rank[py]) {
				rank[py]++;	// 두 대표자의 랭크값이 같은 경우는 랭크값이 1 증가한다
			}
		}
	}
}//class
