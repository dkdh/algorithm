package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1208 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t++) {
			// 각 상자 높이에 해당하는 상자 쌓인 자리가 몇 개인지 저장
			int[] boxes = new int[101];
			
			// dump 횟수 입력 받기
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// 가장 높게/낮게 쌓인 상자 층 수를 저장할 변수
			int max = 0;
			int min = 101;
			
			// 상자 정보 입력 받기
			for (int i = 0; i < 100; i++) {
				int stock = Integer.parseInt(st.nextToken());
				boxes[stock]++;
				
				if(stock > max)
					max = stock;
				if(stock < min)
					min = stock;
			}
			
			int diff = 1000;
			
			// 주어진 덤프 횟수 n만큼 반복
			for (int i = n; i > 0; --i) {
				int dump = boxes[max]<boxes[min]? boxes[max]: boxes[min];
				
				dump = i<=dump ? i:dump;
				
				i -= dump-1;
				
				boxes[max] -= dump;
				boxes[max-1] += dump;
				boxes[min] -= dump;
				boxes[min+1] += dump;
				
				if(boxes[max]==0)
					max--;
				if(boxes[min]==0)
					min++;
				
				diff = max-min;
				
				if(diff<=1)
					break;
			}
			
			System.out.println("#"+(t+1)+" "+diff);
		}
		
	}
}
