package Solution;
/**
 * 지렁이의 개수는 짝수개
 * 둘씩 짝을 지어준다
 * 짝을 지어주는 모든 경우의 수
 * 
 * 각각의 짝으로 만드는 벡터를 구함 -> 벡터의 전체 함 구함 -> 벡터합의 크기 구한다 => 최소값 찾기
 * 
 * 전체 벡터의 합 = 출발위치의 지렁이 좌표합 - 도착 위치의 지렁이 좌표합
 * -> 짝 지어줄 필요없이 그룹만 나누면 된다
 * 
 * ===> 조합문제이다 이것은
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1494_사랑의카운슬러_이재우2 {
	public static int arr[][];
	public static long minn; //벡터 크기의 최소값
	public static int sumx, sumy;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int t = Integer.parseInt(str);
		for (int test = 1; test <= t; test++) {
			str = br.readLine();
			int n = Integer.parseInt(str); //지렁이 개수
			
			arr = new int[n][2];
			sumx = 0;
			sumy = 0;
			for (int i = 0; i < n; i++) {
				str = br.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				
				arr[i][0] = x1;
				arr[i][1] = y1;
				
				sumx+=x1;
				sumy+=y1;
			}//arr완성
			
			minn = Long.MAX_VALUE;
			comb(n,n/2, 0, 0);
			
			System.out.println("#"+test+" "+minn);
		}
	}

	public static void comb(int n, int r, int sx, int sy) {
		if(n < r) return;
		else if(r == 0) { //하나의 조합이 완성
			int unSelx = sumx - sx;
			int unSely = sumy - sy;
			
			long vX = unSelx - sx;
			long vY = unSely - sy;
			
			long v = vX*vX + vY*vY;
			
			if(minn > v) minn = v;
		}
		else {
			comb(n-1, r-1, sx+arr[n-1][0], sy+arr[n-1][1]);
			comb(n-1, r, sx, sy);
		}
	}
}
