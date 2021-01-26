package com.baekjoon;

import java.util.Scanner;
import java.util.ArrayDeque;

//
class Pair {
	public int value;
	public int sequence;
	
	public Pair() {
		
	}
	
	public Pair(int value, int sequence) {
		this.value = value;
		this.sequence = sequence;
	}
}

public class PoppingBalloon {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayDeque<Pair> sequence = new ArrayDeque<>(); // 풍선 터트리는 순서


		int N = sc.nextInt();
		int seq = 0;
		
		for (int i = 0; i < N; i++) { // 덱에 종이적힌 풍선넣기
			seq = sc.nextInt();
			sequence.addLast(new Pair(i+1 , seq));
		}
		
		Pair move = sequence.pollFirst(); // 첫번째 풍선 터트리기
		System.out.print(move.value + " ");
		
		Pair temp = new Pair();
		
		int check = 0;

		while (sequence.size() != 0) {
			
			if (move.sequence > 0) {
				for (int i = 0; i < move.sequence; i++) {
					temp = sequence.pollFirst();
					if (i != move.sequence - 1) { // 마지막이 아니면 다시 넣기
						if(temp!=null)
						sequence.addLast(temp);
					}
				}
				// 다 뽑았으면
				if(temp!=null)
				System.out.print(temp.value + " ");

			} else if (move.sequence < 0) {
				for (int i = 0; i > move.sequence; i--) {
					temp = sequence.pollLast();
					if (i != move.sequence + 1) { // 마지막이 아니면 다시 넣기
						if(temp!=null)
						sequence.addFirst(temp);
					}
				}
				// 다 뽑았으면
				if(temp!=null)
				System.out.print(temp.value + " ");
			}

			if(temp!=null)
				move = temp; // 움직여야하는 수
		}
		
		sc.close();

	} // main end
} // class end
