package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] ladder = new int[100][100];
		
		// 방향 조정용: 상 좌 우
		int[] dr = {-1,0,0};
		int[] dc = {0,-1,1};
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 10; i++) {
			sb.append("#").append(br.readLine()).append(" ");
			
			// 사다리 입력 받기
			for (int j = 0; j < 100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < 100; k++) {
					ladder[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 도착 지점 찾기
			int r = 99;
			int c = 0;
			for (int j = 0; j < 100; j++) {
				if(ladder[99][j]==2) {
					c = j;
					break;
				}
			}
			
			// 사다리 타기
			int d = 0;
			while(true) {
				r += dr[d];
				c += dc[d];
				
				if(r==0)
					break;
				
				// 위로 이동 중이면
				if(d==0) {
					// 좌우 탐색
					if(c-1>=0 && ladder[r][c-1]==1)
						d = 1;
					if(c+1<100 && ladder[r][c+1]==1)
						d = 2;
				}
				// 좌우 이동 중
				else {
					// 위로 이동 가능하면 방향 전환
					if(ladder[r-1][c]==1) {
						d = 0;
					}
				}
				
			}
			sb.append(c).append("\n");
		}
		System.out.println(sb.toString());
	}

}
