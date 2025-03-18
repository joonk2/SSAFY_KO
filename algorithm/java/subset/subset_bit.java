/*
{1,2,3,4,5,6,7,8,9,10}의 powerset 중 원소의 합이 10인 부분집합을 모두 출력하시오 
*/

package alg;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class subset_bit {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] lst = new int[] {1,2,3,4,5,6,7,8,9,10};
		
		int subset = (1 << lst.length)-1;
		int target = 10;
		
		int cnt = 0;
		for (int i = 1; i < subset; i++) {
			int temp_sum = 0;
			for (int j = 0; j < lst.length; j++) {
				
				// Optimization
				//  ----- pruning -----
				if (temp_sum > 10) {
					break;
				}
				// ---------------------
				
				
				
				if ( (i & (1<<j)) != 0) {
					temp_sum += lst[j];
					}
				}
			
				if (temp_sum == target) {
					cnt++;
				}
			
			
			}
		
		System.out.println(cnt);
		
	
	}
}