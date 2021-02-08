package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9229_한빈이의SpotMart {
	
	public static int N;
	public static int M;
	
	public static int max;
	
	public static int[] snacks;
	public static int[] mySnacks;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T ; t++) {
			sb.append("#").append(t).append(" ");
			
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		
			N = Integer.parseInt(s.nextToken());
			M = Integer.parseInt(s.nextToken());
			
			snacks = new int[N];
			mySnacks = new int[2];
			
			max = -1;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) {	
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(snacks);
		
			select(0, 0);
			
			sb.append(max).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void select(int cnt, int start) { 
		
		if(cnt==2) {
			int sum = 0;
			for (int i = 0; i < 2; i++) {
				sum += mySnacks[i];
			}
			if(sum<=M && sum>max) {
				max = sum;
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			mySnacks[cnt] = snacks[i];
			select(cnt+1, i+1);
		}
	}
}
