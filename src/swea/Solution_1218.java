package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1218 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		char[] chars;

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= T; i++) {
			sb.append("#").append(i).append(" ");
			
			br.readLine();
			chars = br.readLine().toCharArray();
			
			int valid = 1;
			int[] cnts = new int[4];
			
			for (int j = 0, size=chars.length; j < size; j++) {
				switch(chars[j]) {
				case '(': cnts[0]++; break;
				case ')': cnts[0]--; break;
				case '[': cnts[1]++; break;
				case ']': cnts[1]--; break;
				case '{': cnts[2]++; break;
				case '}': cnts[2]--; break;
				case '<': cnts[3]++; break;
				case '>': cnts[3]--; break;
				}
				
//				for (int k = 0; k < 4; k++) {
//					if(cnts[k]<0) {
//						valid = 0;
//						break;
//					}
//				}
			}
			for (int k = 0; k < 4; k++) {
				if(cnts[k]!=0) {
					valid = 0;
					break;
				}
			}
			sb.append(valid).append("\n");
		}
		System.out.print(sb.toString());
	}

}
