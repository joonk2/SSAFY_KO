package alg;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class binary_search {
	static int[] lst;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		lst = new int[] {4,2,9,7,11,23,19};
		
		Arrays.sort(lst);
//		System.out.println(Arrays.toString(lst));
		System.out.println(binary_search(100));
		
	}
	
	
	public static int binary_search(int target) {
		int left = 0;
		int right = lst.length-1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			// mid 에서 검색 완료
			if (lst[mid] == target) {
				return mid;
			}
			
			// 왼쪽에 정답이 있다
			if (target < lst[mid]) {
				right = mid-1;
			} 
			else {
				left = mid+1;
			}
			
			
		}
		
		
		// failure of searching
		return 404;
		
		
		
	}
	
	
	
	
	
}