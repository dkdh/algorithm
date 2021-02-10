package boj;

import java.util.LinkedList;
import java.util.Scanner;

// 가변적인 자료 구조에 저장하고 인덱스로 삭제.
// 인덱스가 사람 수 넘어가는 경우 다시 돌아오는 방식: % 사용
public class Main_1158_2_요세푸스 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		sc.close();
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		int cur = 0;
		
		sb.append('<');
		while(!list.isEmpty()) {
			cur += K-1;
			int size = list.size();
			if(cur >= size) {
				cur %= size;
			}
			int data = list.remove(cur);
			
			sb.append(data).append(",").append(" ");
		}
		sb.setLength(sb.length()-2);
		sb.append('>');
		
		System.out.println(sb.toString());
	}

}
