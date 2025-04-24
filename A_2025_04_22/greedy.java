/*
최대한 많은 사람들에게 모자를 나눠주려고 한다
단 조건이 있는데 이는 아래와 같다
a) 같은 모자를 여러 사람에게 줄 수 없게 해야 함
b) 최대한 많은 사람들이 모자를 쓸 수 있게 하자

여기서 사람과 모자의 크기 차이가 N 이하면 착용 가능하다.

[제약사항]
a) N은 3 이상 500 이하
b) 원하는 모자 크기와 실제 모자 크기들은 모두 1 이상 2000 이하 정수이다.

input에 대해
1. 테스트케이스 수 T

각 테스트 케이스에 대해:
2. N (사람 수 = 모자 수)
3. N개의 정수 (사람들이 원하는 모자 크기)
4. N개의 정수 (실제 모자 크기)


[input]
3
3
4 8 2
6 10 7
4
1 2 3 4
4 3 2 1
6
5 8 3 4 2 1
6 3 7 9 5 2

[output]
#1 2
#2 4
#3 6
*/

package A_2025_04_22;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

public class greedy {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] people_arr = br.readLine().split(" ");
			String[] hat_arr = br.readLine().split(" ");
			int[] people = new int[people_arr.length];
			int[] hat = new int[hat_arr.length];
			
			for (int i = 0; i < N; i++) {
				people[i] = Integer.parseInt(people_arr[i]);
				hat[i] = Integer.parseInt(hat_arr[i]);
			}
			
			
			// greedy는 정렬  필수!!!!!!!!!!!!!!!!
			Arrays.sort(people);
			Arrays.sort(hat);
			
			
			int total_cnt = 0;
			boolean[] used = new boolean[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!used[j] && Math.abs(people[i]-hat[j]) <= N) {
						total_cnt++;
						used[j] = true;
						break;
					}
				}
			}
			
			
			
//			System.out.println(Arrays.toString(people));
//			System.out.println(Arrays.toString(hat));
			System.out.println("#" + tc + " " + total_cnt);
			
			
		}
		
		
	}
}