/*
# ------------ 10진수 --> 2진수로 변환 -------------------
10진수를 지속적으로 2로 나누어 구현한다
마지막으로 List를 거꾸로 뒤집는다


[tc]
1
149

출력값
10010101
*/


package base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.util.Arrays;

public class binary_number {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// test case
		int T = Integer.parseInt(br.readLine());
		
		// test case 횟수만큼 반복
		for (int tc = 1; tc < T+1; tc++) {	
//			int target = 149;
			
			// target
			int decimal = Integer.parseInt(br.readLine());
			
			// 0이 되면 종료
			if (decimal == 0) {
				System.out.println(0);
				return;
			}
			
			// 2진수의 최대 크기가 32비트라서 최대 32칸
			char[] res = new char[32];
			
			// 배열의 끝에서부터 채우기
			int idx = 31;
			
			// 진법은 거꾸로 입력하는 것이기 때문에 -- 적용
			while (decimal > 0) {
				res[idx--] = (char) ( (decimal % 2) + '0' );
				decimal /= 2;
			}
			
			// 출력
			// new String(res, startIdx, endIdx) 슬라이싱이다
			// 10010101
			System.out.println(new String(res, idx+1, 31-idx));
			
			// 이 경우는 String(res)
			// 000000000000000000000000010010101
//			System.out.println(new String(res));
			
			
			
			
		}
				
			
			

		}
		
	}