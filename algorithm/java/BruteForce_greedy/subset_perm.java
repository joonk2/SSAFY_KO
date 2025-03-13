/*
[문제]
<친구와 카페 방문>

민철이는 친구 {A,B,C,D,E}가 있다
이 중 최소 2명 이상의 친구를 선정하여 함께 카페에 가려고 한다.
총 몇가지 경우가 가능할까?
*/

package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class subset_perm {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] friend = {"A", "B", "C", "D", "E"};
		int leng = friend.length;
		
		// 모든 부분집합 중 원소의 수가 2개 이상인 집합의 수를 구하자
		int res = 0;
		
		// 최소 1명 이상을 선택한 경우부터 고려 (공집합 제외)
		for (int target = 1; target < (1<< leng); target++) {
			// 선택된 친구가 2명미만이면 패스
			if (Integer.bitCount(target) < 2) {
				continue;
			}
			
			// 뚜껑 생성
			System.out.print("{");
			
			
			
			for (int j = 0; j < leng; j++) {
				if ( (target & (1<<j)) != 0 ) {
					System.out.print(friend[j] + ",");
				}
			}
			System.out.println("}");
			res++;
			
		}
		
		System.out.println("총 경우의 수 : " + res);
		
		
	}
}