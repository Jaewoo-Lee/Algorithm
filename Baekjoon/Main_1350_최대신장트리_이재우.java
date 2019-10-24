import java.util.Arrays;
import java.util.Scanner;

public class Main_1350_최대신장트리_이재우 {
	public static int[] p;
	public static int[] rank;

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); //정점
		int E = sc.nextInt(); //간선 
		
		p = new int[V+1];
		rank = new int[p.length+1];
		
		Edge G[] = new Edge[E]; //간선 배열
		for (int i = 0; i < E; i++) {
			G[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		//크루스컬 : 서로소 집합 활용
		//모든 정점을 원소1개짜리 집합으로 만든다
		for (int i = 1; i < p.length; i++) {
			makeset(i);
		}
		
		//가중치를 기준으로 간선배열을 정렬
		Arrays.sort(G); // compareTo 구현
		
		int result = 0;
		
		//반복(간선이 N-1개 선택할  때까지)
		for (int i = 0; i < E; i++) {
			Edge e = G[i];
			int pa= findset(e.a);
			int pb= findset(e.b);
			
			
			if(pa != pb) {
				union(pa, pb);//같은 집합으로 하나의 집합으로 합침
				result+=e.val;
			}
		}
		//가중치가 낮은 간선을 선택, 사이클이 발생하지 않는 정점
		System.out.println(result);
	
	}//main
	
	public static void makeset(int x) {
		p[x] = x;
		//초기값 이미 0이므로 rank[x] = 0은 의미가 없다
	}
	public static void printset() { //p랑 랭크를 출력
		System.out.print("index : ");
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%2d", i);
		}
		System.out.println();
		System.out.print("parent: ");
		for (int i = 0; i < p.length; i++) {
			System.out.printf("%2d", p[i]);
		}
		System.out.println();
		System.out.print("rank  : ");
		for (int i = 0; i < rank.length; i++) {
			System.out.printf("%2d", rank[i]);
		}
		System.out.println();
		System.out.println();
	}
	public static int findset(int x) {
		if(p[x] == x) {
			return x;
		}
		else {
			p[x] =  findset(p[x]);
			return p[x];
		}
	}
	public static void union(int x, int y) {
		int px = findset(x);
		int py = findset(y);
		
//		p[py] = px;
		link(p[x], p[y]);
	}
	public static void link(int i, int j) {
		//x대표자와 y대표자를 합침
		if(rank[i]>rank[j]) {
			p[j] = i;
		}
		else {
			p[i] = j;
			if(rank[i]==rank[j]) {
				rank[j]++;
			}
		}
	}
	
	
	public static class Edge implements Comparable<Edge> {
		int a;
		int b;
		int val;
		public Edge(int a, int b, int val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}
		@Override
		public int compareTo(Edge o) { //가중치를 기준으로 정렬한다
			return o.val - this.val;
		}
		
	}
}//class
