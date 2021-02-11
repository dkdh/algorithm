package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dfs 사용 재귀 구현
// 각각의 방에서 1.사방탐색 2.네 곳 중 하나가 정확히 +1이면 ㄱ 반복됨.
// 사용된 논리는 앞과 같음.

// 메모리 30,000 실행 시간 191ms

public class Solution_1861_2_정사각형방 {
	
	public static int[][] map;
	public static int N;
	
	// 상 하 좌 우
	public static int[] dr = {-1, 1, 0, 0};
	public static int[] dc = {0, 0, -1, 1};
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		int idx_r[];
		int idx_c[];
		
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
		
			N = Integer.parseInt(br.readLine());
			map = new int[N+2][N+2];
			idx_r = new int[N*N+1];
			idx_c = new int[N*N+1];
			
			// 입력 받기
			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					int a = Integer.parseInt(st.nextToken());
					map[i][j] = a;
					idx_r[a] = i;
					idx_c[a] = j;
				}
			}
			
			int max_room = 0;
			int max_cnt = 0;
			
			int room = 1;
			int cnt = 0;
			
			while(room < N*N+1) {
				cnt = go(idx_r[room], idx_c[room]);
				if(cnt > max_cnt) {
					max_cnt = cnt;
					max_room = room;
					room = room + cnt;
				}else {
					room++;
				}
			}
			
			sb.append(max_room).append(" ").append(max_cnt).append("\n");
		}
		System.out.print(sb.toString());
	}

	public static int go(int r, int c) {
		int res = 0;
		
		int nr, nc;
		
		for (int d = 0; d < 4; d++) {
			nr = r + dr[d];
			nc = c + dc[d];
			if(map[nr][nc]==map[r][c]+1) {
				res = go(nr, nc);
				break;
			}
		}
		
		return res+1;
	}
}
