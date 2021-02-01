package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_4963 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = 0;
		
		int w = 0;
		int h = 0;
		
		// 메인 반복문: 주어진 지도마다 반복
		while(true) {
			// w와 h 입력받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			count = 0;
			// 둘 다 0이면 종료
			if(w==0 && h==0) break;
			
			// 패딩을 포함해 지도 저장할 배열
			int[][] map = new int[h+2][w+2];
			
			// 방문 여부를 저장할 boolean 배열
			boolean[][] visited = new boolean[h][w];
			
			// 입력 받기
			for (int i = 0; i < h; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					if(st1.hasMoreTokens())
						map[i+1][j+1] = Integer.parseInt(st1.nextToken());
				}
			}
			
			// 주어진 지도에서 각 지역에 대해 반복
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					// 각 지역에 대해
					// 1. visited 확인
					if(visited[i+1][j+1]==true)
						continue;
					
					// 방문한 적 없는 지역이라면 섬의 개수 +1
					count++;
					// 2. 방문한 적 없는 지역이라면 이 지역과 연결된 모든 지역 탐색 -> 한 섬이 된다.
					bfs(map, visited, i+1, j+1);
				}
			}
			System.out.println(count);
		}
	}
	
	public static void bfs(int[][] map, boolean[][] visited, int r, int c) {
		// 이미 방문한 지역이라면 탐색x
		if(visited[r][c]==true)
			return;
		
		// 방문 마킹
		visited[r][c] = true;
		
		// 주변 갈 수 있는 곳 탐색(3x3). 패딩을 해둬서 경계 확인 필요x
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(map[r-1+i][c-1+j]==1) {
					bfs(map, visited, r-1+i, c-1+j);
				}
			}
		}
	}

}