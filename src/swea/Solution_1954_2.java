package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author taeheekim
 */

// delta 사용 방법, 시뮬레이션 방법
public class Solution_1954_2 {

	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int[][] arr;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; ++t) {
			N = Integer.parseInt(in.readLine());
			arr = new int[N][N];
			fill();
            System.out.println("#"+t);
			print();
		}
	}
	private static void fill() {
		int r=0,c=0,nr=0,nc=0;
		int d=0, target = N*N, i=1;
		while(i<=target) {
			arr[r][c] = i; // 현위치에 값 세팅 
			// 다음위치 
			nr = r+dr[d];
			nc = c+dc[d];
			if(nr<0 || nr>=N || nc<0 || nc>=N 
					  || arr[nr][nc] != 0) { // 경계를 벗어나거나 이미 해당위치에 값이 채워져 있으면 방향 전환후 다음위치 
				d = (d+1)%4; // 방향전환 
				r += dr[d];
				c += dc[d];
			}else {
				r = nr;
				c = nc;
			}
			i++; // 값증가 
		}
	}
	private static void print() {
		for (int[] is : arr) {
			for (int i : is) {
//				System.out.printf("%3d ",i);
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
