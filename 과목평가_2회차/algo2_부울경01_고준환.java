/*
2
3
0000000000
0000001000
0000000000
0002000000
0000000000
0000000000
0000003000
0000000000
0000000000
0000000000
8
0000000000
0020000000
0000030000
0000000200
0010000000
0000000000
0000200000
0304000030
0400000010
0000000000


#1 73
#2 42
*/

package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import java.util.Arrays;

public class Day1 {
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			int monster = Integer.parseInt(br.readLine());
			int N = 10;
			
			int[][] matrix = new int[N][N];
			
			for (int y = 0; y < N; y++) {
				String col = br.readLine();
				for (int x = 0; x < N; x++) {
					matrix[y][x] = col.charAt(x) - '0';
				}
			}
			
			
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					int target = matrix[y][x];
					
					// 괴물 1 ~ 3
					if (1 <= target && target <= 3) {
						for (int d = 0; d < 4; d++) {
							for (int k = 1; k < target + 1; k++) {
								int ny = (dy[d]*k) + y;
								int nx = (dx[d]*k) + x;
								
								// cond-1 범위 밖이면 break
								if (ny < 0 || ny > N-1 || nx < 0 || nx > N-1) {
									break;
								}
								
								// cond-2 괴물을 만나도 break
								if ( (1 <= matrix[ny][nx] && matrix[ny][nx] <= 3)  || (matrix[ny][nx] == 4) ) {
									break;
								}
								
								// cond-3 괴물의 광선이 비춰지는 곳 0 --> 123;
								if (matrix[ny][nx] == 0) {
									matrix[ny][nx] = 123;
								}
								
								
							}
						}
					}
					
					
				}
			}
			
			
			
			int cnt = 0;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (matrix[y][x] == 0) {
						cnt++;
					}
				}
			}
			
			System.out.println("#" + tc + " "+ cnt);
			
//			System.out.println(Arrays.deepToString(matrix));
			
			
			
		}
		
		
		
		
		
		
		
	}
}
