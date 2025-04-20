/*
[문제]
야구선수의 능력치 차이가 K미만으로 나는 인원들끼리 팀을 짜려고 한다

[입출력]
3 = TestCase
다음 숫자 4 2는 아래와 같다
N은 야구 선수의 능력치 갯수, K는 허용범위다

아래 숫자 4개는 팀원의 능력치로
이때 최대한 만들 수 있는 팀원 수를 구하는 것이다
ex) 각각 6 4 2 3 일때 [2,3,4] 로 cnt=3이 최대 팀원 수다.


3
4 2
6 4 2 3
4 3
1 2 3 4
4 1
1 3 7 5


#1 3
#2 4
#3 1








[코드 개요]
1. BruteForce(완전탐색)를 통해 left, right를 사용하여 범위 안에 해당되는 것들을 비교하며 최대 값 출력
2. p[right]-p[left]를 통해 범위 안에 해당되면 ++
*/


package im_2025_03_04;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Brute_Force {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// test case
		int T = Integer.parseInt(br.readLine());
		
		// test case 횟수만큼 반복
		for (int tc = 1; tc < T+1; tc++) {
			
			// N, K(범위값)
			// 두  값들을 비교할때 K보다 크면 안됨
			String[] arr = br.readLine().split(" ");
			int N = Integer.parseInt(arr[0]);
			int K = Integer.parseInt(arr[1]);
			
			// String[] Player_lst --> int[]
			String[] player_lst = br.readLine().split(" ");
			int[] player = new int[player_lst.length];
			
			for (int i = 0; i < player_lst.length; i++) {
				player[i] = Integer.parseInt(player_lst[i]);
			}
			
			// sort (asc)
			Arrays.sort(player);
			
			
			// Brute-Force
			int max_player_cnt = 0;
			for (int i = 0; i < N; i++) {
				int playert_temp_cnt = 0;
				for (int j = i; j < N; j++) {
					
					// K의 범위안에 해당되는 값들은 전부 ++
					if(player[i]-K <= player[j] && player[j] <= player[i] + K) {
						player_cnt++;
					}
				}
				
				// 최대값 비교 후 갱신
				if (player_cnt > max_player_cnt) {
					max_player_cnt = player_cnt;
				}
				
				
			}
				
			
			
			// debug
//			System.out.println(Arrays.sort(player));
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " " + max_player_cnt);
			System.out.println(sb);
			
		}
		
	}
}