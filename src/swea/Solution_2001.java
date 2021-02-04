package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[][] flies = new int[n][n];
			
			int max = -1;
			
			for (int j = 0; j < n; j++) {
				StringTokenizer s = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < n; k++) {
					flies[j][k] = Integer.parseInt(s.nextToken());
				}
			}
			
			for (int j = 0; j <= n-m; j++) {
				for (int k = 0; k <= n-m; k++) {
					int total = 0;
					for(int a=0; a<m; a++) {
						for(int b=0; b<m; b++) {
							total += flies[j+a][k+b];
						}
					}
					if(total>max)
						max = total;
					total = 0;
				}
			}
			
			System.out.println("#"+i+" "+max);
		}
	}
}
