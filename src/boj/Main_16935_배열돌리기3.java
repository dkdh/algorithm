package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935_배열돌리기3 {
	
	public static int N;
	public static int M;
	public static int R;
	
	public static int[][] arr;
	public static int[][] arr2;
	
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
	
		arr = new int[N][M];
		arr2 = new int[M][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < R; i++) {
			int r = Integer.parseInt(st.nextToken());
			switch (r) {
			case 1:
				oper1();
				break;
			case 2:
				oper2();
				break;
			case 3:
				oper3();
				break;
			case 4:
				oper4();
				break;
			case 5:
				oper5();
				break;
			case 6:
				oper6();
				break;
			default:
				break;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	public static void oper1() {
		int[] row;
		for (int i = 0, size=arr.length; i < size/2; i++) {
			row = arr[i];
			arr[i] = arr[size-1-i];
			arr[size-1-i] = row;
		}
	}

	public static void oper2() {
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0, size=arr[0].length; j < size/2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][size-1-j];
				arr[i][size-1-j] = temp;
			}
		}
	}
	
	public static void oper3() {

		for (int i = 0, r_size = arr.length; i < r_size; i++) {
			for (int j = 0, c_size=arr[0].length; j < c_size; j++) {
				arr2[j][i] = arr[r_size-1-i][j];
			}
		}
		int[][] temp = arr;
		arr = arr2;
		arr2 = temp;
	}
	
	public static void oper4() {

		for (int i = 0, r_size = arr.length; i < r_size; i++) {
			for (int j = 0, c_size=arr[0].length; j < c_size; j++) {
				arr2[c_size-1-j][i] = arr[i][j];
			}
		}
		int[][] temp = arr;
		arr = arr2;
		arr2 = temp;
	}
	
	public static void oper5() {
		int r_size = arr.length;
		int c_size = arr[0].length;
		
		int[][] temp = new int[r_size/2][c_size/2];
		
		for (int i = 0, s=temp.length; i < s; i++) {
			for (int j = 0, s2=temp[0].length; j < s2; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		
		for (int i = 0; i < r_size/2; i++) {
			for (int j = 0; j < c_size/2; j++) {
				arr[i][j] = arr[i+r_size/2][j];
				arr[i+r_size/2][j] = arr[i+r_size/2][j+c_size/2];
				arr[i+r_size/2][j+c_size/2] = arr[i][j+c_size/2];
				arr[i][j+c_size/2] = temp[i][j];
			}
		}
	}
	
	public static void oper6() {
		int r_size = arr.length;
		int c_size = arr[0].length;
		
		int[][] temp = new int[r_size/2][c_size/2];
		
		for (int i = 0, s=temp.length; i < s; i++) {
			for (int j = 0, s2=temp[0].length; j < s2; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		
		for (int i = 0; i < r_size/2; i++) {
			for (int j = 0; j < c_size/2; j++) {
				arr[i][j] = arr[i][j+c_size/2];
				arr[i][j+c_size/2] = arr[i+r_size/2][j+c_size/2];
				arr[i+r_size/2][j+c_size/2] = arr[i+r_size/2][j];
				arr[i+r_size/2][j] = temp[i][j];
			}
		}
	}
	
}
