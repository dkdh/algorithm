package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {
	
	public static int[][] input;
	public static int[][] result;
	public static int[] dr = {1, 0, -1, 0};
	public static int[] dc = {0, 1, 0, -1};
	
	public static int R;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		input = new int[N][M];
		result = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		turn(0, 0, N, M, N-1, M-1);
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
	
	public static void turn(int rStart, int cStart, int rSize, int cSize, int rLastIndex, int cLastIndex) {
		int size = 2*(rSize+cSize)-4;
		int cnt = R % size;
		
		if(rSize<2 || cSize<2)
			return;
		
		// 방향. 하 우 상 좌  0 1 2 3
		int dResult = 0;
		int dd = 0;
		int r = rStart;
		int c = cStart;
		while(cnt!=0) {
			if(dResult%2==0) {
				if(cnt >= rSize-1) {
					cnt -= rSize-1;
					r += dResult==0? rSize-1: -(rSize-1);
				}
				else {
					r += dResult==0? cnt: -cnt;
					break;
				}
			}
			else {
				if(cnt >= cSize-1) {
					cnt -= cSize-1;
					c += dResult==1? cSize-1: -(cSize-1);
				}
				else {
					c += dResult==1? cnt: -cnt;
					break;
				}
			}
			dResult = (dResult+1)%4;
		}
		
		// 이제 옮기기
		dd = 0;
		int rf = rStart, cf = cStart;
		for (int i = 0; i < size; i++) {
			result[r][c] = input[rf][cf];
			
			int nr = r + dr[dResult];
			int nc = c + dc[dResult];
			
			if(nr>rLastIndex || nr<rStart || nc>cLastIndex || nc<cStart) {
				dResult = (dResult+1)%4;
			}
			r += dr[dResult];
			c += dc[dResult];
			
			int nrf = rf + dr[dd];
			int ncf = cf + dc[dd];
			
			if(nrf>rLastIndex || nrf<rStart || ncf>cLastIndex || ncf<cStart) {
				dd = (dd+1)%4;
			}
			
			rf += dr[dd];
			cf += dc[dd];
		}
		
		turn(rStart+1, cStart+1, rSize-2, cSize-2, rLastIndex-1, cLastIndex-1);
	}

}
