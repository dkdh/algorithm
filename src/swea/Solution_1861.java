package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int N;
		
		int[][] map;
		
		int idx_r[];
		int idx_c[];
		
		int r = 1;
		int c = 1;
		
		// 상 하 좌 우 
		int[] dr = new int[] {-1, 1, 0, 0};
		int[] dc = new int[] {0, 0, -1, 1};
		
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= T; i++) {
			sb.append("#").append(i).append(" ");
		
			N = Integer.parseInt(br.readLine());
			map = new int[N+2][N+2];
			idx_r = new int[N*N+1];
			idx_c = new int[N*N+1];
			
			// 입력 받기
			for (int j = 1; j <= N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j2 = 1; j2 <= N; j2++) {
					int a = Integer.parseInt(st.nextToken());
					map[j][j2] = a;
					idx_r[a] = j;
					idx_c[a] = j2;
					if(a==1) {
						r = j;
						c = j2;
					}
				}
			}
				
			int room = 1;
			int cnt = 1;
			int max_room = 0;
			int max_cnt = 0;
			boolean find = false;
			while(true) {
				for (int k = 0; k < 4; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];
					if(map[nr][nc] == room+cnt) {
						cnt++;
						r = nr;
						c = nc;
						find = true;
						break;
					}
				}
				if(find==false) {
					if(cnt>max_cnt) {
						max_room = room;
						max_cnt = cnt;
						room += cnt;
					}
					else {
						room += 1;
					}
					cnt = 1;
					if(room>N*N)
						break;
					r = idx_r[room];
					c = idx_c[room];
				
				}
				find = false;
			}
			sb.append(max_room).append(" ").append(max_cnt).append("\n");
		}
			
		System.out.print(sb.toString());

	}

}
