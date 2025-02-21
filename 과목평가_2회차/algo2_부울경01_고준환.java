package ttt;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Arrays;

public class test {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			int monster = Integer.parseInt(br.readLine());
			int N = 10;
			
			int[][] matrix = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					matrix[i][j] = line.charAt(j) - '0';
				}
			}
			
			
			
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					int target = matrix[y][x];
					
					
					if ( 1 <= target && target <= 3) {
						for (int d = 0; d < 4; d++) {
							for (int k = 1; k < target + 1; k++) {
								int nx = (dx[d] * k) + x;
								int ny = (dy[d] * k) + y;
								
								// cond-1
								if (!  (0 <= ny && ny < N && 0 <= nx && nx < N) ) {
									break;
								}
								
								// cond-2
								if ( (1 <= matrix[ny][nx] && matrix[ny][nx] <= 3) || (matrix[ny][nx] == 4)   ) {
									break;
								}
								
								// cond-3
								// distinguish  0 --> 123
								if (matrix[ny][nx] == 0) {
									matrix[ny][nx] = 123;
								}
								
								
							}
						}
					}
					
					
					
				}
			}
			
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (matrix[i][j] == 0) {
						cnt++;
					}
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
			
			
			
//			System.out.println(Arrays.deepToString(matrix));
			
			
			
		}
		
		
	}
}





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
