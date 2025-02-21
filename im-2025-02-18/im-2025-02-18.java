/*
1. minBall을 다음 좌표가 더 작다면 거기에 임시저장해준다.
2. --> 만약 minBall이  다음 좌표보다 더 크다면 break;
3. while 문 안에서 현 좌표와, 다음좌표를 저장해주며 1개씩 확인 
*/


package ttt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class test {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for (int tc = 1; tc< T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] matrix = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String[] col = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					matrix[i][j] = Integer.parseInt(col[j]);
				}
				
			}
			
			
			
			int max_length = 0;
			
			for (int y = N-1; y >= 0; y--) {
				for (int x = N-1; x >= 0; x--) {
					int cnt = 1;
					int cur_x = x;
					int cur_y = y;
					
					
					while (true) {
						int minBall = Integer.MAX_VALUE;
						int next_x = -999;
						int next_y = -999;
						
						for (int d = 0; d < 4; d++) {
							int nx = dx[d] + cur_x;
							int ny = dy[d] + cur_y;
							
							
							if (0 <= nx && nx < N && 0 <= ny && ny < N && matrix[ny][nx] < minBall) {
								minBall = matrix[ny][nx];
								next_x = nx;
								next_y = ny;
							}
							
	
						}
						
						
						if (minBall >= matrix[cur_y][cur_x]) {
							break;
						}
						
						// 가장 작은값으로 이동
						cur_x = next_x;
						cur_y = next_y;
						cnt++;
							
							
							
							
						}
						
//						max_length = Math.max(max_length, cnt);
						if (cnt > max_length) {
							max_length = cnt;
						}	
						
						
						
						
					}
						
					

			}
			
			System.out.println("#" + tc + " " + max_length);
			
			
			
			
		}
		
		
		
		
		
		
		
		
	}
}



/*
3
5
19 57 74 73 94
26 27 32 98 61
40 88 49 38 25
21 66 53 95 46
80 23 58 39 89
7
40 49 56 83 84 31 11
42 95 12 16 21 19 26
98 93 29 68 10 92 82
23 13 24 58 35 25 47
17 66 39 67 70 14 87
22 34 46 94 69 96 89
62 88 50 51 61 71 86
9
90 57 65 18 25 93 64 11 54
95 19 80 37 63 44 15 14 10
89 59 46 70 38 36 21 51 97
53 47 60 88 40 48 79 56 55
83 13 27 86 45 71 75 28 84
30 20 29 35 99 98 61 94 23
85 42 43 22 16 77 31 78 34
74 26 73 92 50 72 87 49 32
68 24 91 12 17 82 69 67 81


# 1 6
# 2 10
# 3 9
*/
