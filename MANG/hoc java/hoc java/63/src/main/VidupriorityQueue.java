package main;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class VidupriorityQueue {
	public static void main(String[] args) {
		Queue<String> danhsachsv= new PriorityQueue<String>();
		danhsachsv.offer("TITV 1");
		danhsachsv.offer("Nguyen Van B");
		danhsachsv.offer("Nguyen Van A");
		danhsachsv.offer("TITV 2");
		while(true) {
			String ten= danhsachsv.poll();//lay ra nhung ko xoa
			if(ten==null) break;
				
			System.out.println(ten);
		}
	}
}
