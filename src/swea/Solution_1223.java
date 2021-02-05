package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1223 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		int N;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= T; i++) {
			sb.append("#").append(i).append(" ");
			
			StringBuilder ex = new StringBuilder();
			
			N = Integer.parseInt(br.readLine());
			char[] chars = br.readLine().toCharArray();
			
			int j = 1;
			while (j < N) {
				char ch = chars[j];
				
				if(ch == '*') {
					chars[j] = chars[j+1];
					chars[j+1] = '*';
				}
				j += 2;
			}
			

			boolean first = true;
			for (int k = 0; k < N; k++) {
				char ch = chars[k];
				
				if(first == true && ch=='+') {
					first = false;
					continue;
				}
				ex.append(ch);
			}
			ex.append('+');
			
			String expression = ex.toString();
			
			int[] numbers = new int[N];
			int top = -1;
			for (int k = 0; k < N; k++) {
				char ch = expression.charAt(k);
				if(ch>='0' && ch <= '9') {
					numbers[++top] = ch - '0';
				}
				else if(ch=='+'||ch=='*') {
					int operand1 = numbers[top--];
					int operand2 = numbers[top--];
					numbers[++top] = (ch=='+')? operand1 + operand2: operand1 * operand2;
				}					
			}
			int result = numbers[top--];
			
			sb.append(result).append("\n");
		}
		System.out.print(sb.toString());
	}

}
