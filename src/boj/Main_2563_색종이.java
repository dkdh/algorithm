package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[][] white = new boolean[100][100];
		
		// 색종이 수
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			for (int j = r; j < r+10; j++) {
				for (int k = c; k < c+10; k++) {
					if(white[j][k]==false)
						white[j][k]=true;
				}
			}
		}
		
		
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(white[i][j]) sum++;
			}
		}
		System.out.println(sum);
	}

}
