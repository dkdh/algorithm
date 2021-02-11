package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		int N;
		
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			N = Integer.parseInt(br.readLine());
			
			// 입력 받기
			int possible = 1;
			for (int i = 0; i < N; i++) {
				if(possible==0) {
					br.readLine();
					continue;
				}
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				int cnt = 2;
				// 노드 번호
				st.nextToken();
				char data = st.nextToken().charAt(0);
				while(st.hasMoreTokens()) {
					st.nextToken();
					cnt++;
				}
				// 연산자를 가진 노드의 자식 개수가 2 미만이면 계산 불가이므로 케이스 종료
				if(!(data>='0'&&data<='9')) {
					if(cnt<4) {
						possible = 0;
					}
				}
				// 숫자가 자식 가지면 계산 불가
				else {
					if(cnt > 2) {
						possible = 0;
					}
				}
			}
			sb.append(possible).append("\n");

		}
		
		System.out.print(sb.toString());
	}
}
