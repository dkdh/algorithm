package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int T = 10;
		
		for (int i = 1; i <= T; i++) {
			br.readLine();
			sb.append("#").append(i).append(" ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 8; j++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			int cnt = 1;
			
			while(true) {
				int temp = queue.poll();
				temp -= cnt++;
				
				if(cnt>5)
					cnt = 1;
				
				if(temp<=0) {
					temp = 0;
					queue.add(temp);
					break;
				}
				
				queue.add(temp);
			}
			
			for (int j = 0; j < 8; j++) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

}
