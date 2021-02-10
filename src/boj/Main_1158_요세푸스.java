package boj;

import java.util.Scanner;

// 원형 리스트 구현해서 품
public class Main_1158_요세푸스 {
	
	public static Node head;

	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 사람 수
		int N = sc.nextInt();
		// 제거할 순번
		int K = sc.nextInt();
		
		initList(N);
		sb.append("<");
		deleteList(K);
		sb.append(">");
		
		sc.close();
		System.out.print(sb.toString());
	}
	
	public static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void initList(int N) {
		Node firstNode = new Node(1);
		
		head = firstNode;
		firstNode.next = firstNode;
		
		Node prev = firstNode;
		
		for (int i = 2; i <= N; i++) {
			Node newNode = new Node(i);
			
			prev.next = newNode;
			newNode.next = head;
			prev = newNode;
		}
	}
	
	public static void printList() {
		Node temp = head;
		if(head==null) return;
		do {
			System.out.println("data: "+temp.data+" "+temp.next.data);
			temp = temp.next;
		}while(temp!=head);
	}
	
	public static void deleteList(int K) {
		Node temp = head;
		Node prev = null;
		
		// K==1일 때는 temp 바로 삭제 들어가야 해서
		// prev를 순차탐색으로 찾아야 함
		if(K==1) {
			while(temp.next!=head) {
				temp = temp.next;
			}
			prev = temp;
		}
		
		temp = head;
		
		while(temp.next!=temp) {
			for (int i = 0; i < K-1; i++) {
				prev = temp;
				temp = temp.next;
			}
			
			// 삭제
			sb.append(temp.data).append(",").append(" ");
			prev.next = temp.next;
			temp.next = null;
			temp = prev.next;
		}
		
		sb.append(temp.data);
		temp.next = null;
		
	}

}
