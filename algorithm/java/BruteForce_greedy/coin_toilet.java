/*
[문제]
<화장실>

어떤 기준으로 접근해야 대기시간의 누적합이 최소가 될지 고민해보고 직접 구핸해보자
{"A" : 15, "B" : 30, "C" : 50, "D" : 10}
 
*/

package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class coin_toilet {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// HashMap
		Map<String, Integer> people = new HashMap<>();
		
		people.put("A", 15);
		people.put("B", 30);
		people.put("C", 50);
		people.put("D", 10);
		
		
		for (Map.Entry<String, Integer> entry : people.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		
	}
}
