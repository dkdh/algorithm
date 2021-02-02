package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 스위치 개수 입력
		int n = Integer.parseInt(br.readLine());
		int[] switches = new int[n];
		
		// 스위치 초기 상태 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			switches[i] = Integer.parseInt(st.nextToken());
		}
		
		// 사람 수 입력
		int n2 = Integer.parseInt(br.readLine());
		for (int i = 0; i < n2; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			// 입력받은 스위치 번호를 저장할 변수
			int s = 0;
			
			// 남자면
			if(st2.nextToken().equals("1")) {
				s = Integer.parseInt(st2.nextToken());
//				for (int j = 0; j < n; j++) {
//					if((j+1)%s==0)
//						switches[j] = (switches[j] == 1)? 0 : 1;
//				}
				int sx = s;
				while(sx <= n) {
					switches[sx-1] = switches[sx-1]^1;
					sx += s;
				}
			}
			// 여자면
			else {
				s = Integer.parseInt(st2.nextToken());
				
				// 경계 확인
//				int bound = n-s < s-1 ? n-s: s-1;
				
				// 스위치 번호->인덱스
				s--;
				
				// 받은 번호의 스위치 반전
//				switches[s] = switches[s]==1 ? 0 : 1;
				switches[s] = switches[s]^1;
				
				// 대칭 확인
//				for (int j = 1; j <= bound; j++) {
//					// 대칭인 스위치는 반전
//					if(switches[s-j] == switches[s+j])
//						switches[s-j] = switches[s+j] = switches[s+j]==1? 0: 1;
//					else
//						break;
//				}
				
				int left = s;
				int right = s;
				while(--left>=0 && ++right<n && switches[left]==switches[right])
					switches[left] = switches[right] = switches[right]^1;
				
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(switches[i]);
			
			if((i+1)%20==0)
				sb.append("\n");
			else
				sb.append(" ");
		}
		System.out.println(sb.toString());
	}

}
