/*
[문제]
주사위 1개로  나올 수 있는 3개의 순서쌍을 구하고 갯수를 구하라

*/

package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class dice {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 6;
		boolean[] selected = new boolean[N+1];
		
		int res = 0;
		
		// 중복 허용X
		for (int i = 1; i < N+1; i++) {
			selected[i] = true;
			for (int j = 1; j < N+1; j++) {
				if (selected[j]) continue;
				selected[j] = true;
				for (int k = 1; k < N+1; k++) {
					if (selected[k]) continue;
					System.out.println("{" + i + "," + j + "," + k + "]");
					res++;
				}
				selected[j] = false;
			}
			selected[i] = false;
		}
		
		System.out.println("N==3 일때 나올 수 있는 모든 조합" + res);
		
		
		
	}
}