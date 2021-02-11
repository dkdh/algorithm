package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 * @author THKim
 */
public class Solution_1223_2_계산기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// '*' : 42, '+':43
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = 10;
		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			char[] line = br.readLine().toCharArray();
			
			// step1. 후위표기식 만들기  , 3+4+5*6+7
			char temp;
			Stack<Character> stack  = new Stack<Character>();
			StringBuilder expression = new StringBuilder();
			for(int i=0; i<N; ++i) {
				temp = line[i];
				if(Character.isDigit(temp)) {// 피연산자이면
					expression.append(temp);
				}else{ 
					// 스택에 상단에 있는 피연산자가 현재처리하려는 피연산자보다 우선순위가 같거나 크다면 먼저 처리
					// 그래야 후위표기 연산시 피연산자뒤에 우선순위 높은연산자가 바로 붙어 연산을 먼저 처리하게 됨.
					while(!stack.isEmpty() && getPriority(stack.peek())>=getPriority(temp)) expression.append(stack.pop());
					stack.push(temp);
				}
			}
			// 스택에 남아있는 연산자들 빼서 후위표기에 붙임 
			while(!stack.isEmpty()) expression.append(stack.pop());
			
			// step2 후위표기식 계산하기  : 피연산자 스택에 push,연산자 스택 pop,pop 하여 연산 후 다시 스택에 push
			Stack<Integer> stack2  = new Stack<Integer>();
			int k=0,value1,value2;
			for(int i=0; i<N; ++i) {
				temp = expression.charAt(i);
				k = temp-'0';
				if(k>=0 && k<=9) { //피연산자
					stack2.push(k);
				}else {// 연산자
					value2 = stack2.pop();
					value1 = stack2.pop();
					stack2.push(temp=='+'?value1+value2:value1*value2);
				}
			}
			System.out.println("#"+tc+" "+stack2.pop());
		}
		
	}
	private static int getPriority(char ch) {
		if(ch=='+') return 1;
		return 2;
	}


}
