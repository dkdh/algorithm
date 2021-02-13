package boj;

import java.util.Scanner;

// dp
public class Main_1453_2_1로만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		sc.close();
		
		int[] cnts = new int[N+1];
		
		for (int i = 2; i <= N; i++) {
			cnts[i] = cnts[i-1]+1;
			
			if(i%2==0)
				cnts[i] = Math.min(cnts[i/2]+1, cnts[i]);
			
			if(i%3==0)
				cnts[i] = Math.min(cnts[i/3]+1, cnts[i]);
		}
		
		System.out.print(cnts[N]);
	}

}
