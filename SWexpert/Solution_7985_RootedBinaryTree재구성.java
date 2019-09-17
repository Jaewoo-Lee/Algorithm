import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_7985_RootedBinaryTree¿Á±∏º∫ {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		for (int test = 1; test <= t; test++) {
			int depth = s.nextInt();
			int[] tree = new int[1<<depth];
		
			s.nextLine();
			String str = s.nextLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			
			int cnt = 1;
			int[] index = new int[depth+1];
			for (int i = 1; i <= depth; i++) {
				index[i] = 1<<(depth-i);
			}
			
//			System.out.println(index);
			
			int[] plus = new int[depth];
			while (st.hasMoreTokens()) {
				for (int i = 1; i <= depth; i++) {
					if(cnt == index[i]) {
						tree[1<<(i-1)+plus[i]] = Integer.parseInt(st.nextToken());
						index[i]+=1<<(depth-i+1);
						plus[i]++;
					}
				}
				cnt++;
			}
		}
	}
}
