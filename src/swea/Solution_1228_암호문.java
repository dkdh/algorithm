package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1228_암호문 {
	
	// 연결 리스트
	private static Node head;
	private static Node tail;
	
	private static Node temp;
	
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		int N;
		int C;
		int M;
	
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			// 암호문의 길이
			N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			// 원본 암호문을 받아 저장
			for (int i = 0; i < N; i++) {
				C = Integer.parseInt(st.nextToken());
				
				// 리스트에 추가
				addLastNode(C);
			}
			
			// 명령어의 개수 입력받기
			M = Integer.parseInt(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				// I
				st2.nextToken();
				// 위치
				int x = Integer.parseInt(st2.nextToken());
				// 개수
				int y = Integer.parseInt(st2.nextToken());
				
				for (int j = 0; j < y; j++) {
					insert(x+j, Integer.parseInt(st2.nextToken()));
				}
				temp = null;
			}
			
			printList();
			head = tail = null;
		}
		System.out.println(sb.toString());
	}

	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
		
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	static public void addLastNode(int C) {
		Node newNode = new Node(C);
		
		// 공백 리스트이면
		if(head==null) {
			// 헤드와 테일을 newNode로 설정
			head = newNode;
			tail = newNode;
			return;
		}
		
		tail.next = newNode;
		tail = newNode;
		
	}
	
	static public void printList() {
		if(head==null) {
			System.out.println("공백 리스트");
			return;
		}
		
		Node cur = head;
		for (int i=0; i<10; i++) {
			sb.append(cur.data).append(" ");
			cur = cur.next;
		}
		sb.append("\n");
	}
	
	
	static public void insert(int x, int s) {
		Node newNode = new Node(s);
		Node prev = null;
		
		if(temp==null) {
			if(x==0) {
				newNode.next = head;
				head = newNode;
				temp = newNode;
				return;
			}else {
				prev = head;
				for (int i = 0; i < x-1; i++) {
					prev = prev.next;
				}
			}
		}else {
			prev = temp;
		}
		newNode.next = prev.next;
		prev.next = newNode;
		temp = newNode;

	}
	
}
