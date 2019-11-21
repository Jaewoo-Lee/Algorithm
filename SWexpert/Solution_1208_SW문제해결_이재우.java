import java.util.Scanner;

public class Solution_1208_SW문제해결_이재우 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		for (int test = 1; test <= 10; test++) {
			int dump = s.nextInt();
			int arr[] = new int[100];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = s.nextInt();
			}
			while(dump != 0){
				int mxidx = -1;
				int mnidx = -1;
				int mx = -1;
				int mn = 1000;
				for (int i = 0; i < arr.length; i++) {
					if(mx < arr[i]) {
						mx = arr[i];
						mxidx = i;
					}
					if(mn > arr[i]){
						mn = arr[i];
						mnidx = i;
					}
				}
				arr[mxidx]-=1;
				arr[mnidx]+=1;
				dump--;
			}
			int maxx = -1;
			int minn = 1000;
			
			for (int i = 0; i < arr.length; i++) {
				if(maxx < arr[i]) maxx = arr[i];
				if(minn > arr[i]) minn = arr[i];
			}
			
			System.out.println("#"+test+" "+(maxx-minn));
		}
	}
}
