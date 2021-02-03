package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int w = 0;
		int h = 0;
		
		int[] dr = {0, -1, 1, 0, 0};
		int[] dc = {0, 0, 0, -1, 1};
		
		int d = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[h][w];
			
			// 전차의 위치를 저장할 변수
			int r = 0;
			int c = 0;
			
			// 지도 입력받기
			for (int j = 0; j < h; j++) {
				for (int j2 = 0; j2 < w; j2++) {
					int status = char2int((char)br.read());
					map[j][j2] = status;
					if(status<5) {
						r = j;
						c = j2;
					}
				}
				br.readLine();
			}
			
			// 사용자 입력 횟수
			int n = Integer.parseInt(br.readLine());
			
			int nr = r;
			int nc = c;
		
			for (int j = 0; j < n; j++) {
				char ch = (char)br.read();
				
				nr = r;
				nc = c;
				// 쏠 때
				if(ch=='S') {
					// 전차의 방향 가져오기
					switch(map[r][c]) {
					case 1: d = 1; break;
					case 2: d = 2; break;
					case 3: d = 3; break;
					case 4: d = 4; break;
					}
					
					// 방향대로 쭉 전진하면서
					while(true) {
						nr += dr[d];
						nc += dc[d];
						
						// 맵 밖으로 나가면 break
						if(!(nr>=0 && nr<= h-1
								&& nc>=0 && nc<=w-1)) {
							break;
						}
						
						// 벽돌 벽을 만나면 평지로 바꾸고 break
						if(map[nr][nc]==6) {
							map[nr][nc] = 5;
							break;
						}
						// 강철 벽을 만나면 break
						else if(map[nr][nc]==7) {
							break;
						}
					}
				}
				// 이동일 때
				else {
					switch(ch) {
					case 'U': d = 1; break;
					case 'D': d = 2; break;
					case 'L': d = 3; break;
					case 'R': d = 4; break;
					}
					nr += dr[d];
					nc += dc[d];
					
					// 경계 확인 + 평지인지 확인
					if(nr>=0 && nr<= h-1
							&& nc>=0 && nc<=w-1
							&& map[nr][nc]==5) {
						map[r][c] = 5;
						map[nr][nc] = d;
						r = nr;
						c = nc;
					}
					// 이동이 불가하면 방향만 바꾸기
					else {
						map[r][c] = d;
					}
				}
			}
			br.readLine();
		
			// 출력
			sb.append("#").append(i).append(" ");
			
			for (int j = 0; j < h; j++) {
				for (int j2 = 0; j2 < w; j2++) {
					sb.append(int2char(map[j][j2]));
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());

	}
	
	public static char int2char(int n) {
		char c = '0';
		
		switch(n) {
		case 1: c = '^';
				break;
		case 2: c = 'v';
				break;
		case 3: c = '<';
				break;
		case 4: c = '>';
				break;
		case 5: c = '.';
				break;
		case 6: c = '*';
				break;
		case 7: c = '#';
				break;
		case 8: c = '-';
				break;
		}
		
		return c;
	}
	
	public static int char2int(char ch) {
		int n = 0;
		
		switch(ch) {
		case '^': n = 1;
				break;
		case 'v': n = 2;
				break;
		case '<': n = 3;
				break;
		case '>': n = 4;
				break;
		case '.': n = 5;
				break;
		case '*': n = 6;
				break;
		case '#': n = 7;
				break;
		case '-': n = 8;
				break;
		}
		
		return n;
	}

}
