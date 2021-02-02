package com.swea;

import java.util.Scanner;

class Node{
	private int data;
	private Node next;
	
	Node() {
		
	}
	
	Node(int data) {
		this.data = data;
		next = null;
	}
	
	public int getData() {
		return data;
	}
	
	public void setNext(Node n) {
		next = n;
	}
	
	public Node getNext() {
		return next;
	}
	
}

class LinkedList {
	private Node head;
	private Node tail;
	private int size;
	
	LinkedList() {
		
	}
	
	public int peek() { // 제일 앞의 값 반환
		if(head!=null)
			return head.getData();
		return 0;
	}
	
	public int getSize() { // 사이즈 반환
		return size;
	}
	
	public void add(int data) { // 줄줄이 노드 추가
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
			size++;
		} else {
			Node temp = head;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
			tail = newNode;
			size++;
		}
	}
	
	public void remove() { // 맨 앞에서 제거
		if(getSize() !=0 ) {
			Node temp = head.getNext();
			head.setNext(null);
			head = temp;
			size--;
		}
	}
	
	
}



public class Solution_SWEA_8189 {

		public static void main(String[] args){
			
			Scanner sc = new Scanner(System.in);
			
			int T = sc.nextInt();

			for (int tc = 1; tc <= T; tc++) { 
				LinkedList list = new LinkedList();
				int t = sc.nextInt();
				
				int countLimit = sc.nextInt(); // 편지 제한 개수
				int timeLimit = sc.nextInt(); // 시간 제한
				int[] time = new int[t];

				// 편지가 온 시간 입력
				for (int i = 0; i < t; i++) 
					time[i] = sc.nextInt();
				

				System.out.print("#" + tc + " ");
				int flowTime = 0; // 시간흐름
				int index = 0;
				int count = 0;
				while (true) {
					if (count == t)
						break;
					flowTime++; // 시간흐름
					if ((index <= t-1) && (time[index] == flowTime)) // 편지가 도착하는 시간이 되면 보관함에 넣기
						list.add(time[index++]);
					
					if (flowTime - list.peek() >= timeLimit) { // 보관한 편지가 일정이상 오래되면
						int halfSize = list.getSize() / 2; 
						int realSize = list.getSize()%2==1 ? halfSize + 1 : halfSize;
						for (int i = 0; i < realSize; i++) { // 절반꺼내고 시간 찍기
							if(count == t-1)
								System.out.println(flowTime);
							else
								System.out.print(flowTime + " ");
							list.remove();
							count++;
						}
					}
					
					if(list.getSize() >= countLimit) { // 보관함 편지가 일정 개수 이상이면
						int halfSize = list.getSize() / 2; 
						int realSize = list.getSize()%2==1 ? halfSize + 1 : halfSize;
						
						for (int i = 0; i < realSize; i++) { // 절반꺼내고 시간 찍기
							if(count == t-1)
								System.out.println(flowTime);
							else
								System.out.print(flowTime + " ");
							list.remove();
							count++;
						}
					}				
				}

			}

			sc.close();
		} // main end



}
