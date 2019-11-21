import java.util.Scanner;
  
public class Main_2634_이재우 {
    public static void main(String[] args) {
          
        //동물의 좌표 x+y == 사대의 사정거리냐
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();//사대
        int n = s.nextInt();//동물
        int l = s.nextInt();//사정거리
          
        int shot[] = new int[m];
        for (int i = 0; i < m; i++) {
            shot[i] = s.nextInt();
        }
          
        int cnt = 0;
        int x,y;
        for (int i = 0; i < n; i++) {
            x = s.nextInt();
            y = s.nextInt();
              
            if(y > l) continue;
             
            for (int j = 0; j < m; j++) {
                if(Math.abs(x-shot[j])+y <= l) {
                    cnt++;
                    break;
                }
            }
             
       }
          
        System.out.println(cnt);
          
    }
}