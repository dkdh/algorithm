package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805 {
	// 입력받아 배열에 저장하는 과정을 생략함
	// 정사각형 마름모이기 때문에
	// 처음 주어진 정사각형의 한 변의 길이가 N이라고 했을 때
	// 인덱스, 정수 연산 기준임
	// 첫째 줄에서는 N/2 요소부터 1개
	// 다음 줄에서는 앞선 요소 -1 번째부터 앞서 가져온 개수+2개를 가져오게 된다.
	// N/2 줄에서는 한 줄 전체 다 가져오게 되고, 이후부터는 요소와 개수를 반대로 적용

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(i).append(" ");
			
			int n = Integer.parseInt(br.readLine());
			int total = 0;
			
			int cnt = 1;
			int d = 1;
			int start = n/2;
			for (int j = 0; j < n; j++) {

				for (int k = 0; k < start; k++) {
					br.read();
				}
				for (int k = 0; k < cnt; k++) {
					total += Character.getNumericValue(br.read());
				}
				br.readLine();
				
//				String str = br.readLine();
//				for (int k = 0; k < cnt; k++) {
//					total += Character.getNumericValue(str.charAt(start+k));
//				}
				
				if(cnt==n) {
					d *= -1;
				}
				start -= d;
				cnt += d*2;
			}
			
			sb.append(total);
			
			System.out.println(sb.toString());
		}
	}

}
