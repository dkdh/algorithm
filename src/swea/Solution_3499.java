package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int N;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= T; i++) {
			sb.append("#").append(i).append(" ");
			N = Integer.parseInt(br.readLine());
			String[] shuffle = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int idx = 0;
			while(st.hasMoreTokens()) {
				if(idx > N-1) {
					idx = 1;
				}
				shuffle[idx] = st.nextToken();
				idx += 2;
			}
			
			for (int j = 0; j < N; j++) {
				sb.append(shuffle[j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}

}
