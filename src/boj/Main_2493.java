package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] tops = new int[N+1];
		int[] numbers = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			tops[i] = Integer.parseInt(st.nextToken());
		}
		tops[0] = Integer.MAX_VALUE;
		
		Stack<int[]> top = new Stack<int[]>();
		for (int i = N; i > 0 ; i--) {

			if(tops[i-1]<tops[i]) {
				top.add(new int[] {tops[i], i});
			}else {
				numbers[i] = i-1;
				while(!top.isEmpty() && (top.peek())[0]<tops[i-1]) {
					numbers[top.pop()[1]] = i-1;
					
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(numbers[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

}
