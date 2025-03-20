package im;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Union_find {
	static int[] parents;
	static int[] ranks;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 6;
		
		// 집합 초기화
		makeSet(N);
		
		// 유니온 연산 수행 (하나씩 주석 체크하며 비교해보면 이해가 잘 될 것이야)
		union(1,3);
		union(2,3);
		union(5,6);
		
		// 부모 배열 출력
		System.out.println("부모배열: " + Arrays.toString(parents));
		
		// 1과 2가 같은 집합인지 확인
		if (findSet(1) == findSet(2)) {
			System.out.println("같은 집합이랑께");
		}
		else {
			System.out.println("다른 집합이랑께");
		}
		
		
		// rank 출력
		System.out.println(Arrays.toString(ranks));
	
		
		
		
		
		
	}
	
	
	
	// makeSet
	public static void makeSet(int x) {
		parents = new int[x+1];
		ranks = new int[x+1];
		
		for (int i = 1; i < x+1; i++) {
			// 부모를 자기 자신으로 초기화
			parents[i] = i;
			// 랭크는 0으로 초기화
			ranks[i] = 0;
			
		}
	}
	
	// findSet
	public static int findSet(int k) {
		
		// path compression (경로 압축)
		// 부모를 갱신해 k가 바로 최상위 부모를 가리키도록 함
		if (parents[k] != k) {
			parents[k] = findSet(parents[k]);
		}
		
		// res 반환
		return parents[k];
	}
	
	// union (based on rank)
	public static void union(int a, int b) {
		int boss_a = findSet(a);
		int boss_b = findSet(b);
		
		// 이미 같은 집합이면종료
		if (boss_a == boss_b) return;
		
		// 랭크 기반 병합 (랭크가 높은쪽이 대장이됨)
		if (ranks[boss_a] < ranks[boss_b]) {
			parents[boss_a] = parents[boss_b];
		}
		else if (ranks[boss_a] > ranks[boss_b]) {
			parents[boss_b] = parents[boss_a];
		}
		
		// 랭크가 같다면 그냥 한쪽을 대장으로 몰아주자
		else if (ranks[boss_a] == ranks[boss_b]) {
			parents[boss_b] = boss_a;
			ranks[boss_a]++;
		}
		
		
	}
	
	
	
	
}