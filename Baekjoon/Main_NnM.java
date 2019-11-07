import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main_NnM {
	static int arr[];
	static int len;
	static HashSet<Integer> hs;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		len = m;
		
		hs = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			hs.add(s.nextInt());
		}
		int arr[] = new int[hs.size()];
		for (int i = 0; i < hs.size(); i++) {
			arr[i] = (int) (hs.toArray())[i];
		}
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			String re = arr[i]+" ";
			start(i, 1, re, arr);
		}
		
		
	}

	public static void start(int i, int cnt, String res, int[] arr) {
		
	}
}
