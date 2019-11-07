package Solution;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * AD 수준 정도로 예상
 * 숫자 사이사이를 쪼개는 방법을 바이너리카운팅을 이용, 각 쪼갠값을 곱한 값으로 재귀호출
 * 
 * 재귀호출 (중복호출 많이 발생) -> 메모이제이션(저장) -> DP(작은해부터 구해서 큰 해를 찾는 방법) 
 */
public class Solution_7206_숫자게임_이재우 {
	public static int[] memo = new int[99999]; // f 함수를 호출한 결과를 저장할 배열
	//한번만 배열객체를 생성해서 재활용 못하는 이유 : f함수의 호출한 결과 값은 동일하기 떄문에 어떤 테스트케이스에서 한번이라도 구했으면, 재활용
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
//		long time = System.currentTimeMillis();
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.println("#"+testCase+" "+f(N));
		} // end of for testCase
//		System.out.println(System.currentTimeMillis()-time+"ms");
	} // end of main

	/** 숫자 N으로 쪼갤 수 있는 최대 턴 수를 리턴하는 메서드 */
	private static int f(int N) {
		if(N<10) {
			return 0;
		}
		String s = N + "";
		int len = s.length() - 1; // 쪼갤 개수
		int maxCnt = 0;
		for (int i = 1; i < 1<<len; i++) { // 쪼개는 방법. 바이너리 카운팅을 이용, 0은 안쪼개기 때문에 1부터 시작
//			System.out.printf("%3s: ", Integer.toBinaryString(i));
			
			int mul = 1; // 곱셈에 대한 항등원으로 초기화
			int num = s.charAt(0) - '0'; // 첫 번째 자리수의 문자를 숫자로 변환
			for (int j = 0; j < len; j++) { // 비트마스킹
				if((i&1<<j)==0) { // 안쪼갬
					num = num * 10 + s.charAt(j+1) - '0'; // 연결된 숫자로 계산
				} else { // 쪼갬
					mul *= num;
//					System.out.print(num+", ");
					num = s.charAt(j+1)-'0';
				}
				
			}
			mul *= num;
//			System.out.print(num+", ");
//			System.out.println(mul);
//			int cnt = f(mul); // mul을 쪼갤 수 있는 최대 턴 수를 받아옴
			if(mul >= 10 && memo[mul]== 0) { //아직 구하지 않은 경우
				memo[mul] = f(mul); //mul을 쪼갤 수 있는 초대 턴 수 를 받아옴
			}
			if(maxCnt<memo[mul]) maxCnt = memo[mul];
		}
		
		return maxCnt + 1;
	}
} // end of class