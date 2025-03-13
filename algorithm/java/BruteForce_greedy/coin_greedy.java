/*
[문제]
<동전교환>

아래 그림과 같이 총 네종류의 동전이 있다.
손님의 돈을 최소한의 동전 수를 사용해 교환해주려고 한다.
만약 1730원을 거슬러주기 위해
사용할 수 있는 최소 동전의 수는 몇개인가?

10, 50, 100, 500

*/

package algorithm;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class coin_greedy {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 1730;
		int[] coin_lst = {500, 100, 50, 10};
		int min_cnt = 0;
		
		for (int c : coin_lst) {
			// 각 동전 갯수 획득(몫)
			int mod = (N/c);
			
			// 동전 횟수 적립
			min_cnt += mod;
			
			// 디버깅용 (각 동전별 몇개 가능한지)
			System.out.println("cur_coin is" + " " + c + " " + "and" + " " +  "cnt is" + " " + mod);
			
			// 나머지를 N에 최신화
			N %= c;
			


		}
		
		System.out.println(min_cnt);
		
		
	}
}