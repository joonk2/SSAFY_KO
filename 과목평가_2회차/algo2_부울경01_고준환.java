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





package swea;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Solution {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int monster = Integer.parseInt(br.readLine());
			int[][] map = new int[10][10];
			
			for (int r = 0; r < 10; r++) {
				String col = br.readLine();
				for (int c = 0; c < 10; c++) {
					map[r][c] = col.charAt(c)-'0';
				}
			}
			
			
			for (int r = 0; r < 10; r++) {
				for (int c = 0; c < 10; c++) {
					int temp_pos = map[r][c];
					int monster_power = map[r][c];
					if (temp_pos == 1 || temp_pos == 2 || temp_pos == 3) {
						for (int d = 0; d < 4; d++) {
							for (int k = 1; k < monster_power+1; k++) {
								int nr = r + (dr[d]*k);
								int nc = c + (dc[d]*k);
								
								// cond-1 (range)
								if (nr < 0 || nr >= 10 || nc < 0 || nc >= 10) break;
								
								// cond-2 (monster or wall, then break)
								if (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 3 || map[nr][nc] == 4) {
									break;
								} 
								
								// cond-3 (infesting area)
								if (map[nr][nc] == 0) map[nr][nc] = 999;
								
							}
						}
					}
				}
			}
			
			
			
			
//			for (int i = 0; i < 10; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
			
			
			
			int cnt_safeZone = 0;
			for (int r = 0; r < 10; r++) {
				for (int c = 0; c < 10; c++) {
					if(map[r][c] == 0) cnt_safeZone++;
				}
			}
			
			
			System.out.println("#" + tc + " " + cnt_safeZone);
			
			
		}
		
		
		
		
		
		
	}
}