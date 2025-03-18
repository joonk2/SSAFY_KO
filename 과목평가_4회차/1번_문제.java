
/*
[idea]
----- BruteForce -----
모든 조합을 찾다가 K == 2인 구간부터 cnt를 max_cnt에 저장 후, cnt를 초기화해주고 다시 센다.

[input & output]
3
6 2
100101
7 3
1001011
7 5
1001011


#1 4
#2 6
#3 0 
*/

package samsung02;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String[] NK = br.readLine().split(" ");
			int N = Integer.parseInt(NK[0]);
			int K = Integer.parseInt(NK[1]);
			String seq_arr = br.readLine();
			
			int[] seq = new int[N];
			for (int i = 0; i < N; i++) {
				seq[i] = seq_arr.charAt(i) - '0';
			}
			
			
			int max_leng = 0;
			for (int i = 0; i < N; i++) {
				int cnt_leng = 0;
				int flag = 0;
				for (int j = i; j < N; j++) {
					if (flag == K) {
						if (cnt_leng > max_leng) {
							max_leng = cnt_leng;
							
							// 초기화
							cnt_leng = 0;
						}
					}
					
					if (seq[j] == 1) {
						flag++;
					}
					
					cnt_leng++;
				}
			}
			
			
//			System.out.println(Arrays.toString(seq));
			System.out.println("#" + tc + " " + max_leng);
			
			
			
		}
		
		
	}
}