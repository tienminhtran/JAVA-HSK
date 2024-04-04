package main;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class ViduDeque {
public static void main(String[] args) {
	Deque<String> danhsachsv= new ArrayDeque<String>();
	danhsachsv.offer("TITV 1");
	danhsachsv.offer("Nguyen Van B");
	danhsachsv.offer("Nguyen Van A");
	danhsachsv.offer("TITV 2");
	danhsachsv.offerLast("TITV 4");
	danhsachsv.offerFirst("TITV 0");
	while(true) {
		String ten= danhsachsv.poll();//lay ra nhung ko xoa
		if(ten==null) break;
			
		System.out.println(ten);
	}
}
}
