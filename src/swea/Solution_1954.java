package swea;

import java.util.Scanner;

public class Solution_1954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			int size = sc.nextInt();
			
			int[][] snail = new int[size][size];
			makeSnail(snail, 0, 0, size, 1);
			
			System.out.println("#"+(i+1));
			for (int j = 0; j < size; j++) {
				for (int j2 = 0; j2 < size; j2++) {
					System.out.print(snail[j][j2]);
					if(j2!=size-1)
						System.out.print(" ");
				}
				System.out.println();
			}
		}
	}
	
	public static void makeSnail(int[][] snail, int r, int c, int size, int cnt) {
		
		if(size <= 0)
			return;
		if(size == 1) {
			snail[r][c] = cnt;
			return;
		}
			
		
		for (int i = 0; i < size-1; i++) {
			snail[r][c+i] = cnt++;
		}
		for (int i = 0; i < size-1; i++) {
			snail[r+i][c+size-1] = cnt++;
		}
		for (int i = 0; i < size-1; i++) {
			snail[r+size-1][c+size-1-i] = cnt++;
		}
		for (int i = 0; i < size-1; i++) {
			snail[r+size-1-i][c] = cnt++;
		}
		
		makeSnail(snail, r+1, c+1, size-2, cnt);
	}

}
