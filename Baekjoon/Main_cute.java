import java.util.Scanner;

public class Main_cute {
	public static void main(String[] args) {
		int cute = 0;
		int ncute = 0;
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		for (int i = 0; i < n; i++) {
			int temp = s.nextInt();
			if(temp == 1) cute++;
			else ncute++;
		}
		
		System.out.printf("%s",(cute>ncute)? "Junhee is cute!\n":"Junhee is not cute!\n");
	}
}
