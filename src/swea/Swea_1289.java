package swea;

import java.util.Scanner;

public class Swea_1289 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			char[] str_char = str.toCharArray();
			int cnt = 0;
			char cur = '0';
			for(int j=0, size=str_char.length; j<size; j++) {
				if(cur!=str_char[j]) {
					cur = str_char[j];
					cnt++;
				}
			}
			System.out.printf("#"+(i+1)+" "+cnt+"\n");

		}

		sc.close();
	}

}