package com.sk.practice.interfaces;

import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueInterface {
	
	public static void main(String[] args) throws InterruptedException {
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=10; i >=0; i--) {
			queue.add(i);
		}
		
		//구현체를 linked list
		linkedListExample(queue);
		//구현체를 prioriry queue
		priorityQueueExample(queue);
	}

	/*특정 위치에 추가 삭제가 빈번한 경우, 발생되는 비용은 O(1)*/
	private static void linkedListExample(Collection<Integer> c) throws InterruptedException {
		Queue<Integer> queue = new LinkedList<>(c);
		while(!queue.isEmpty()) {
			System.out.println(queue.remove());
			Thread.sleep(1000);
		}
		
	}

	private static void priorityQueueExample(Collection<Integer> c) throws InterruptedException {
		Queue<Integer> queue = new PriorityQueue<>(c);
		while(!queue.isEmpty()) {
			System.out.println(queue.remove());
			Thread.sleep(1000);
		}
	}
}
