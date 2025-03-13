/*
[문제]
민철이에게는 3명의 친구가 있다
{MIN, CO, TIM}

함께 영화관에 갈 수 있는 멤버를 구성하고자 한다.
모든 경우의 수를 출력해보자

*/


package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BruteForce_and_bit {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] friend = {"MIN", "CO", "TIM"};
		
		int leng = friend.length;
		int subset = 1 << leng;
		
		// 부분집합 최대 갯수
		for (int i = 0; i < subset; i++) {
			System.out.print("{");
			// 각 subset에 들어갈 선택 가능한 원소의 갯수들
			for (int j = 0; j < leng; j++) {
				// j만큼 이동했을 때 i에 포함이 되는지v
				if ( (i & (1 << j)) != 0) {
					System.out.print(friend[j] + ", ");
				}
			}
			System.out.println("}");
			
			
			
		} 
		
		
		
		
		
	}
}